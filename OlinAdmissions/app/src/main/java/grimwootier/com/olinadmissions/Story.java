package grimwootier.com.olinadmissions;

/**
 * Created by root on 11/10/14.
 */
public class Story {
    private String title;
    private String location;
    private String story_text;
    private String date;

    public Story(String title, String location, String story_text, String date) {
        this.title = title;
        this.location = location;
        this.story_text = story_text;
        this.date = date;
    }

    public String get_title() {
        return title;
    }

    public String get_location() {
        return location;
    }

    public String get_storytext() {
        return story_text;
    }

    public String get_date() {
        return date;
    }
}
