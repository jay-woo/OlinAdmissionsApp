package grimwootier.com.olinadmissions;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabMenu extends Fragment {

    public TabMenu() {
    }

    ActionBar.Tab tab1, tab2;//, tab3;
    //Fragment olinMap = new OlinMap();
    Fragment storyList = new StoryList();
    Fragment upload = new UploadHome();
    MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab_menu, container, false);

        ActionBar actionBar = this.getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //tab1 = actionBar.newTab().setText("MAP");
        tab1 = actionBar.newTab().setText("STORIES");
        tab2 = actionBar.newTab().setText("UPLOAD");

        activity.addFragment(storyList);
        activity.addFragment(upload);

        //tab1.setTabListener(new TabListener(olinMap));
        tab1.setTabListener(new TabListener(storyList));
        tab2.setTabListener(new TabListener(upload));

        //actionBar.addTab(tab1);
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

        return rootView;
    }

    public void onAttach(Activity activity) {
        this.activity = (MainActivity) activity;
        super.onAttach(activity);
    }
}


