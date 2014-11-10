package grimwootier.com.olinadmissions;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class StoryList extends Fragment {

    public StoryList() {
    }

    ListView list;

//    String[] title = {
//            "MobProto Madness",
//            "3D Printing Cool Things",
//            "These Fruit Flies Though",
//            "So Many Frisbees",
//            "Fun Times with ORS",
//            "Unicycling Like a Boss",
//            "Sketching Hoppers",
//            "Watching The Legend of Korra",
//            "Computing Conversations",
//            "OFAC Burn",
//            "Go Soccer Team!",
//            "And Then I Blew an OpAmp...",
//            "Glass, Everywhere!",
//            "Town Hall Meeting"
//    } ;
//    String[] location = {
//            "Academic Center Room 113",
//            "Milas Hall Library",
//            "Campus Center Dining Hall",
//            "Great Lawn",
//            "Large Project Building",
//            "The O",
//            "Parcel B",
//            "West Hall Third Floor Lounge",
//            "East Hall First Floor Lounge",
//            "Lot D",
//            "Soccer Fields",
//            "Academic Center Room 426",
//            "Campus Center Pool Room",
//            "Milas Hall Auditorium"
//    } ;
//    Integer[] imageId = {
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1,
//            R.drawable.olin1
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_story_list, container, false);

        CustomList adapter = new CustomList(this.getActivity(), title, imageId, location);

        final Firebase firebase = new Firebase("https://boiling-inferno-4244.firebaseio.com/");

        firebase.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                titleList .add(snapshot.getValue().toString());  //prints "Do you have data? You'll love Firebase."
            }
            @Override public void onCancelled(FirebaseError error) { }
        });

        list=(ListView)rootView.findViewById(R.id.story_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //LINK TO PICTURE/STORY VIEW
            }
        });

        return rootView;
    }
}


