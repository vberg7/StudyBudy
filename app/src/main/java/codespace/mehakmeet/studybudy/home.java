package codespace.mehakmeet.studybudy;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

import codespace.mehakmeet.studybudy.adapter.EventAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment implements DiscreteScrollView.ScrollStateChangeListener<EventAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<EventAdapter.ViewHolder>,
        View.OnClickListener{

    private List<Event> events;

    private EventView eventView;
    private DiscreteScrollView timelineEventPicker;

    private View rootView;

    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        eventView = (EventView) rootView.findViewById(R.id.event_detail_view);
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        events = TimelineEventList.get().getEvents();
        timelineEventPicker = (DiscreteScrollView) rootView.findViewById(R.id.timeline_event_picker);
        timelineEventPicker.setSlideOnFling(true);
        timelineEventPicker.setClickable(true);
        timelineEventPicker.setAdapter(new EventAdapter(events));
        timelineEventPicker.addOnItemChangedListener(this);
        timelineEventPicker.addScrollStateChangeListener(this);
        timelineEventPicker.setItemTransitionTimeMillis(50);
        timelineEventPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        eventView.setEvent(events.get(0));
        // Inflate the layout for this fragment
        return rootView;


    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCurrentItemChanged(@Nullable EventAdapter.ViewHolder holder, int position) {
        if (holder != null) {
            eventView.setEvent(events.get(position));
            //holder.showText();
        }
    }
    @Override
    public void onScrollStart(@NonNull EventAdapter.ViewHolder holder, int position) {
       // holder.hideText();
    }

    @Override
    public void onScroll(
            float position,
            int currentIndex, int newIndex,
            @Nullable EventAdapter.ViewHolder currentHolder,
            @Nullable EventAdapter.ViewHolder newHolder) {
        Event current = events.get(currentIndex);
        if (newIndex >= 0 && newIndex < timelineEventPicker.getAdapter().getItemCount()) {
            Event next = events.get(newIndex);
            eventView.onScroll(1f - Math.abs(position));
        }
    }

    @Override
    public void onScrollEnd(@NonNull EventAdapter.ViewHolder holder, int position) {

    }

}
