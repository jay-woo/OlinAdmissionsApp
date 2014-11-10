package grimwootier.com.olinadmissions;

import android.app.Fragment;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wooj on 10/29/14.
 */
public class LoginFragment extends Fragment {
    private MainActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        /* Firebase variables */
        final Firebase ref = new Firebase("https://olinadmissionsapp.firebaseio.com");
        final Firebase accountRef = ref.child("users");

        /* References to XML items */
        final EditText username = (EditText) rootView.findViewById(R.id.username);
        final EditText password = (EditText) rootView.findViewById(R.id.password);
        final Button login = (Button) rootView.findViewById(R.id.login);
        final Button signup = (Button) rootView.findViewById(R.id.signup);

        final ArrayList<Account> accounts = new ArrayList<Account>();

        /* Login button - check username/password */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                boolean authenticated = false;        // True if there is a match

                for(Account item : accounts) {
                    if(item.get_username().equals(inputUsername) && item.get_password().equals(inputPassword)) {
                        authenticated = !authenticated;
                        activity.switchFragment(new TabMenu());
                        Log.i("DEBUGGING", "LOGGED IN");
                    }
                }

                if(!authenticated) {
                    Log.i("DEBUGGING", "NOT LOGGED IN");
                }
            }
        });

        /* Signup button */
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.switchFragment(new SignupFragment());
            }
        });

        /* Adds all account information to an ArrayList */
        accountRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    String childUsername = child.getName().toString();
                    String childPassword = child.child("password").getValue().toString();
                    String childFirstName = child.child("firstname").getValue().toString();
                    String childLastName = child.child("lastname").getValue().toString();
                    String childOlinConnection = child.child("olinconnection").getValue().toString();

                    Account childAccount = new Account(childUsername, childPassword,
                                                       childFirstName, childLastName,
                                                       childOlinConnection);

                    accounts.add(childAccount);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.i("DEBUGGING PURPOSES", "Failure: " + firebaseError.getMessage());
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