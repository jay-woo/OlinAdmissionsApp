package grimwootier.com.olinadmissions;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class RoomStory extends Fragment {
    public RoomStory() {
    }
    private ViewFlipper viewflipper;
    private Button exitbutton;
    private Context context;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        context = this.getActivity();
        View rootView = inflater.inflate(R.layout.room_story, container, false);
        viewflipper = (ViewFlipper) rootView.findViewById(R.id.view_flipper);
        exitbutton = (Button) rootView.findViewById(R.id.exit_button);
        viewflipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
        exitbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().remove(RoomStory.this).commit();
            }
        });
        return rootView;
    }
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
// right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    viewflipper.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.left_in));
                    viewflipper.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.left_out));
                    viewflipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    viewflipper.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.right_in));
                    viewflipper.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.right_out));
                    viewflipper.showPrevious();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}