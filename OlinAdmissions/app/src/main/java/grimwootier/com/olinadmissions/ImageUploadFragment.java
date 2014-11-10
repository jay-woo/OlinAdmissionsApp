package grimwootier.com.olinadmissions;

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

public class ImageUploadFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_image_upload, container, false);
        final EditText imageTitleEditText = (EditText) rootView.findViewById(R.id.title_image);
        final Button uploadImageButton = (Button) rootView.findViewById(R.id.upload_image);
        final EditText imageCaptionEditText = (EditText) rootView.findViewById(R.id.caption_image);
        final EditText imageTagEditText = (EditText) rootView.findViewById(R.id.enter_tag_picture);
        final EditText imageBuildingEditText = (EditText) rootView.findViewById(R.id.enter_building_picture);
        final EditText imageFloorEditText = (EditText) rootView.findViewById(R.id.enter_floor_picture);
        final EditText imageRoomEditText = (EditText) rootView.findViewById(R.id.enter_room_picture);

//        final Button buildingButton = (Button) rootView.findViewById(R.id.building_button);
//        final Button floorButton = (Button) rootView.findViewById(R.id.floor_button);
//        final Button roomButton = (Button) rootView.findViewById(R.id.room_button);
//        final Firebase firebase = new Firebase("https://boiling-inferno-4244.firebaseio.com/");

        //Initialize firebase
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot child : dataSnapshot.getChildren()) {
//                    //ChatObject chat = new ChatObject(child.get)
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

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
//        uploadImageButton.setOnClickListener(
//                new View.OnClickListener(){
//                    public void onClick (View view) {
//                        firebase.child("imageUploadTitle").setValue(imageTitleEditText.getText().toString());
//                        firebase.child("imageUploadCaption").setValue(imageCaptionEditText.getText().toString());
//                        firebase.child("imageUploadTags").setValue(imageTagEditText.getText().toString());
//                        firebase.child("storyUploadBuilding").setValue(imageBuildingEditText.getText().toString());
//                        firebase.child("storyUploadFloor").setValue(imageFloorEditText.getText().toString());
//                        firebase.child("storyUploadRoom").setValue(imageRoomEditText.getText().toString());
//                    }
//        });




        return rootView;
    }

}