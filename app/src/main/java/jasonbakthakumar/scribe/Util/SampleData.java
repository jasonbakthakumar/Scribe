package jasonbakthakumar.scribe.Util;

import java.util.ArrayList;

/**
 * Created by jasonbakthakumar on 20/08/17.
 */

public class SampleData {

    String topic;
    String content;

    public SampleData(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private static int lastContactId = 0;

    public static ArrayList<SampleData> createSampleList(int numContacts) {
        ArrayList<SampleData> contacts = new ArrayList<SampleData>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new SampleData("Topic", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In facilisis mauris at ante feugiat, rutrum ornare tellus tristique. Fusce nec lorem cursus purus scelerisque hendrerit sed sit amet ipsum. Aliquam id nisi ut enim eleifend malesuada. Morbi pretium vitae magna quis pharetra. Suspendisse turpis lectus, interdum et felis at, rutrum bibendum augue. Etiam id porttitor erat. Nullam vitae orci leo. Vivamus posuere est ac tellus ultrices, vel convallis metus convallis. Proin elementum sagittis felis id ultricies. Sed faucibus nisi sit amet urna egestas, sit amet imperdiet elit lacinia."));
        }

        return contacts;
    }
}
