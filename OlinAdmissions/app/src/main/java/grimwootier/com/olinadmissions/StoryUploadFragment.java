package grimwootier.com.olinadmissions;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class StoryUploadFragment extends Fragment {
    MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_story_upload, container, false);
        final EditText storyTitleEditText = (EditText) rootView.findViewById(R.id.title_story);
        final Button uploadStoryButton = (Button) rootView.findViewById(R.id.upload_story);
        final EditText storyTextEditText = (EditText) rootView.findViewById(R.id.story_text);
        final EditText storyTagEditText = (EditText) rootView.findViewById(R.id.enter_tag_story);
        final EditText storyLocationEditText = (EditText) rootView.findViewById(R.id.story_upload_location);
//        final EditText storyBuildingEditText = (EditText) rootView.findViewById(R.id.enter_building_story);
//        final EditText storyFloorEditText = (EditText) rootView.findViewById(R.id.enter_floor_story);
//        final EditText storyRoomEditText = (EditText) rootView.findViewById(R.id.enter_room_story);

//        final Button buildingButton = (Button) rootView.findViewById(R.id.building_button);
//        final Button floorButton = (Button) rootView.findViewById(R.id.floor_button);
//        final Button roomButton = (Button) rootView.findViewById(R.id.room_button);
        final Firebase firebase = new Firebase("https://olinadmissionsapp.firebaseio.com/stories");

//        //Building button click
//        buildingButton.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View view) {
//                        //drop down menu
//                        //send building to firebase
//                        //pick proper floor array
//                    }
//                });
//
//        //Floor button click
//        floorButton.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View view) {
//                        //default to "choose building first"
//                        //drop down menu
//                        //send floor to firebase
//                        //choose correct room array
//                    }
//                });
//
//        //Room button click
//        roomButton.setOnClickListener(
//                new View.OnClickListener() {
//                    public void onClick(View view) {
//                        //default to "choose building and room first"
//                        //drop down menu
//                        //send room to firebase
//                    }
//                });

        //Upload button click
        uploadStoryButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View view) {

                        Map<String, String> newItemMap = new HashMap<String, String>();
                        Map<String, Map<String, String>> newTitle = new HashMap<String, Map<String, String>>();

                        newItemMap.put("story_text", storyTextEditText.getText().toString());
                        newItemMap.put("tags", storyTagEditText.getText().toString());
                        newItemMap.put("location", storyLocationEditText.getText().toString());
                        newItemMap.put("image", "N/A");
                        newItemMap.put("image_caption", "N/A");
                        newItemMap.put("date", "November");

                        firebase.child(storyTitleEditText.getText().toString()).setValue(newItemMap);

                        getFragmentManager().popBackStack();

//                        for (Fragment activeFragment : activity.getActiveFragments()) {
//                            if (activeFragment instanceof UploadHome) {
//                                activity.switchFragment(activeFragment);
//
//                            }
//                        }
                    }
                });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        this.activity = (MainActivity) activity;
        super.onAttach(activity);
    }
}