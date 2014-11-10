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
    ArrayList<Story> allStories = new ArrayList<Story>();
    ListView list;

    public StoryList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_story_list, container, false);

        CustomList adapter = new CustomList(this.getActivity(), titleList, imageIdList, locationList);

        final Firebase firebase = new Firebase("https://olinadmissionsapp.firebaseio.com/stories");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String title = child.getKey();
                    String location = child.child("location").getValue().toString();
                    String story_text = child.child("story_text").getValue().toString();
                    String date = child.child("date").getValue().toString();
                    String image = child.child("image").getValue().toString();
                    String image_caption = child.child("image_caption").getValue().toString();

                    Story storyItem = new Story(title, location, story_text, date, image, image_caption);

                    allStories.add(storyItem);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        list=(ListView)rootView.findViewById(R.id.story_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //if story, switch to story, if image switch to image
                activity.switchFragment(new StoryViewFragment(allStories.get(position)));
            }
        });

        return rootView;
    }
}


