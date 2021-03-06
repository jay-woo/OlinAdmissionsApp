package grimwootier.com.olinadmissions;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.Map;

public class StoryViewFragment extends Fragment {
    Story story;
    MainActivity activity;

    public StoryViewFragment(Story story) {
        this.story = story;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_story_view, container, false);
        final TextView storyTitle = (TextView) rootView.findViewById(R.id.title_story_view);
        final TextView storyText = (TextView) rootView.findViewById(R.id.story_text_view);
        final TextView storyLocation = (TextView) rootView.findViewById(R.id.story_view_location);
        final Button backButton = (Button) rootView.findViewById(R.id.story_back_button);

        //fill in textviews
        storyTitle.setText(story.get_title());
        storyText.setText(story.get_storytext());
        storyLocation.setText(story.get_location());

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //activity.switchFragment(new StoryList());
                getFragmentManager().popBackStack();
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