package grimwootier.com.olinadmissions;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.firebase.client.Firebase;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayList<Fragment> activeFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Starts Firebase */
        Firebase.setAndroidContext(this);

        /* Runs login fragment */
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
        }
    }

    public void switchFragment(Fragment fragment) {
        activeFragments.add(fragment);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public ArrayList<Fragment> getActiveFragments() {
        return activeFragments;
    }
}