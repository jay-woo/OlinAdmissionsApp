package grimwootier.com.olinadmissions;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String>{
    private final Activity context;
    private final ArrayList<String> title;
    private final ArrayList<Integer> imageId;
    private final ArrayList<String> location;

    public CustomList(Activity context,
                      ArrayList<String> title, ArrayList<Integer> imageId, ArrayList<String> location) {
        super(context, R.layout.story_list_single, title);
        this.context = context;
        this.title = title;
        this.imageId = imageId;
        this.location = location;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.story_list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        TextView txtLocation = (TextView) rowView.findViewById(R.id.loc);
        txtTitle.setText(title.get(position));
        imageView.setImageResource(imageId.get(position));
        txtLocation.setText(location.get(position));

        return rowView;
    }
}