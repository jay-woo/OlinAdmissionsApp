package grimwootier.com.olinadmissions;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
//
//import com.dropbox.client2.DropboxAPI;
//import com.dropbox.client2.android.AndroidAuthSession;
//import com.dropbox.client2.session.AppKeyPair;
//import com.dropbox.client2.session.Session;
import com.firebase.client.Firebase;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ArrayList<Fragment> activeFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ViewPager mViewPager;
        super.onCreate(savedInstanceState);

        /* Starts Firebase */
        Firebase.setAndroidContext(this);

        /* Runs login fragment */
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new UploadHome())
                    .commit();
        }
//        AppKeyPair appKeys = new AppKeyPair("14wbjnl7yh35vsk", "7jlfcmq7m501wec");
//        AndroidAuthSession session = new AndroidAuthSession(appKeys);
//        DropboxStuff.mDBApi = new DropboxAPI<AndroidAuthSession>(session);
//
//
//        DropboxStuff.mDBApi.getSession().startOAuth2Authentication(MainActivity.this);

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (DropboxStuff.mDBApi.getSession().authenticationSuccessful()) {
//            try {
//                // Required to complete auth, sets the access token on the session
//                DropboxStuff.mDBApi.getSession().finishAuthentication();
//
//                String accessToken = DropboxStuff.mDBApi.getSession().getOAuth2AccessToken();
//            } catch (IllegalStateException e) {
//                Log.i("DbAuthLog", "Error authenticating", e);
//            }
//        }
//    }

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