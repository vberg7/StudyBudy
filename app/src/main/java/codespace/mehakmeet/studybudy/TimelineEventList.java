package codespace.mehakmeet.studybudy;

import java.util.Arrays;
import java.util.List;

public class TimelineEventList {


    private TimelineEventList() {
    }

    public static TimelineEventList get() {
        return new TimelineEventList();
    }

    public List<Event> getEvents() {
        return Arrays.asList(
// Dxy denotes Day x, Event Y
                new Event("JAVA", R.drawable.java_main, "JAVA", Timeline.D11),
                new Event("C++", R.drawable.cpp_main, "C++", Timeline.D23),
                new Event("Python", R.drawable.py_main, "Python", Timeline.D12),
                new Event("HTML", R.drawable.html_5_main, "HTML5", Timeline.D13),
                new Event("Android", R.drawable.android_main, "Android", Timeline.D14),
                new Event("iOS", R.drawable.swift, "iOS", Timeline.D21),
                new Event("JavaScript", R.drawable.js_main, "JavaScript", Timeline.D22));

                /*new Event("8 AM", R.drawable.line_drawable_food, "Breakfast", Timeline.D24),
                new Event("12 PM", R.drawable.line_drawable_registration, "Hack Conclusion Alert Call", Timeline.D25),
                new Event("1 PM", R.drawable.line_drawable_liftoff, "Hack Concludes\nFirst Call for Pitch Submission", Timeline.D26),
                new Event("2 PM", R.drawable.line_drawable_pitch, "Final Call for Pitch Submission\nPitching Starts", Timeline.D27),
                new Event("5 PM", R.drawable.line_drawable_speaker, "Speakers 2 and 3", Timeline.D28),
                new Event("6 PM", R.drawable.line_drawable_prizes, "Results Announcement", Timeline.D29));*/
    }
}
