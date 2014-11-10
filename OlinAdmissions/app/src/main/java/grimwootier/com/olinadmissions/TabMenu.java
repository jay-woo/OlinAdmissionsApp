package grimwootier.com.olinadmissions;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabMenu extends Fragment {

    public TabMenu() {
    }

    ActionBar.Tab tab1, tab2, tab3;
    Fragment storyList = new StoryList();
    Fragment olinMap = new StoryList();
    Fragment upload = new UploadHome();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab_menu, container, false);

        ActionBar actionBar = this.getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1 = actionBar.newTab().setText("MAP");
        tab2 = actionBar.newTab().setText("LIST");
        tab3 = actionBar.newTab().setText("UPLOAD");

        tab1.setTabListener(new TabListener(storyList));
        tab2.setTabListener(new TabListener(olinMap));
        tab3.setTabListener(new TabListener(upload));

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);

        return rootView;
    }
}


