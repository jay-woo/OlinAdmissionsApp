package grimwootier.com.olinadmissions;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class StoryViewFragment extends Fragment {

    private String title;
    private String text;
    private String location;

    public StoryViewFragment (String title, String text, String location) {
        this.title = title;
        this.text = text;
        this.location = location;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_story_upload, container, false);
        final Firebase firebase = new Firebase("https://boiling-inferno-4244.firebaseio.com/");
        final TextView storyTitle = (TextView) rootView.findViewById(R.id.title_story_view);
        final TextView storyText = (TextView) rootView.findViewById(R.id.story_text_view);
        final TextView storyLocation = (TextView) rootView.findViewById(R.id.story_view_location);

        //fill in textviews
        storyTitle.setText(title);
        storyText.setText(text);
        storyLocation.setText(location);

        return rootView;
    }

}