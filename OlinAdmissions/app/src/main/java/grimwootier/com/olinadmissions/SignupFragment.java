package grimwootier.com.olinadmissions;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class SignupFragment extends Fragment {
    MainActivity activity;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.signup_fragment, container, false);

        /* All the XML variables */
        final EditText username = (EditText) rootView.findViewById(R.id.username_signup);
        final EditText password = (EditText) rootView.findViewById(R.id.password_signup);
        final EditText firstname = (EditText) rootView.findViewById(R.id.firstname_signup);
        final EditText lastname = (EditText) rootView.findViewById(R.id.lastname_signup);
        final EditText olinconnection = (EditText) rootView.findViewById(R.id.olinconnection_signup);
        final Button signUp = (Button) rootView.findViewById(R.id.signup_newAccount);

        /* Firebase variable */
        final Firebase ref = new Firebase("https://olinadmissionsapp.firebaseio.com/users");

        /* When the button is pressed, the new account information is uploaded to Firebase */
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acc_username = username.getText().toString();
                String acc_password = password.getText().toString();
                String acc_firstname = firstname.getText().toString();
                String acc_lastname = lastname.getText().toString();
                String acc_olinconnection = olinconnection.getText().toString();

                ref.child(acc_username).child("password").setValue(acc_password);
                ref.child(acc_username).child("firstname").setValue(acc_firstname);
                ref.child(acc_username).child("lastname").setValue(acc_lastname);
                ref.child(acc_username).child("olinconnection").setValue(acc_olinconnection);

                activity.switchFragment(new TabMenu());
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void onAttach(Activity activity) {
        this.activity = (MainActivity) activity;
        super.onAttach(activity);
    }
}
