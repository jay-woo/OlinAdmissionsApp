package grimwootier.com.olinadmissions;

import android.media.Image;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.plus.model.people.Person;

import java.util.ArrayList;

public class StoryList extends Fragment {

    MainActivity activity;

    ArrayList<String> titleList = new ArrayList<String>();
    ArrayList<String> tagList = new ArrayList<String>();
    ArrayList<String> locationList = new ArrayList<String>();
    ArrayList<String> storyTextList = new ArrayList<String>();
    ArrayList<String> imageList= new ArrayList<String>();
    ArrayList<String> captionList = new ArrayList<String>();
    ArrayList<Integer> imageIdList = new ArrayList<Integer>();

    public StoryList() {
    }

    ListView list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_story_list, container, false);

        CustomList adapter = new CustomList(this.getActivity(), titleList, imageIdList, locationList);

        final Firebase firebase = new Firebase("https://boiling-inferno-4244.firebaseio.com/");


        firebase.child("title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                titleList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        firebase.child("tags").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                tagList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        firebase.child("location").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                locationList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        firebase.child("storyText").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                storyTextList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        firebase.child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                imageList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });


        firebase.child("imageCaption").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                captionList.add(snapshot.getValue().toString());
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        for (int item = 0; item<titleList.size(); item = item+1);{
            imageIdList.add(R.drawable.olin1);
        }


        list=(ListView)rootView.findViewById(R.id.story_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //if story, switch to story, if image switch to image
                activity.switchFragment(new StoryViewFragment(titleList.get(position), locationList.get(position),storyTextList.get(position)));
            }
        });

        return rootView;
    }
}


