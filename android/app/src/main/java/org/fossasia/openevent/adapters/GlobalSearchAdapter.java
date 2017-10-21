package org.fossasia.openevent.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD

import org.fossasia.openevent.R;
import org.fossasia.openevent.activities.SearchActivity;
import org.fossasia.openevent.adapters.viewholders.DayScheduleViewHolder;
import org.fossasia.openevent.adapters.viewholders.DividerViewHolder;
import org.fossasia.openevent.adapters.viewholders.LocationViewHolder;
import org.fossasia.openevent.adapters.viewholders.SpeakerViewHolder;
import org.fossasia.openevent.adapters.viewholders.TrackViewHolder;
import org.fossasia.openevent.data.Microlocation;
import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.dbutils.RealmDataRepository;
=======
import android.widget.TextView;

import org.fossasia.openevent.R;
import org.fossasia.openevent.data.Microlocation;
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.adapters.viewholders.LocationViewHolder;
import org.fossasia.openevent.adapters.viewholders.SpeakerViewHolder;
import org.fossasia.openevent.adapters.viewholders.TrackViewHolder;
>>>>>>> text_align

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import butterknife.BindView;
import butterknife.ButterKnife;

>>>>>>> text_align
public class GlobalSearchAdapter extends BaseRVAdapter<Object, RecyclerView.ViewHolder> {

    private Context context;

    private List<Object> filteredResultList = new ArrayList<>();
<<<<<<< HEAD
    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
=======
>>>>>>> text_align

    //ViewType Constants
    private final int TRACK = 0;
    private final int SPEAKER = 2;
    private final int LOCATION = 3;
    private final int DIVIDER = 4;
<<<<<<< HEAD
    private final int SESSION = 5;

    public GlobalSearchAdapter(List<Object> dataList, Context context) {
        super(dataList);
        this.context = context;
=======

    public GlobalSearchAdapter(List<Object> dataList, Context context) {
        super(dataList);
        this.context = context.getApplicationContext();
>>>>>>> text_align
        this.filteredResultList = dataList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        if (filteredResultList.get(position) instanceof Track) {
            return TRACK;
        } else if (filteredResultList.get(position) instanceof String) {
            return DIVIDER;
        } else if (filteredResultList.get(position) instanceof Speaker) {
            return SPEAKER;
        } else if (filteredResultList.get(position) instanceof Microlocation) {
            return LOCATION;
<<<<<<< HEAD
        } else if (filteredResultList.get(position) instanceof Session) {
            return SESSION;
=======
>>>>>>> text_align
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return filteredResultList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredResultList.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder resultHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TRACK:
                View track = inflater.inflate(R.layout.item_track, parent, false);
                resultHolder = new TrackViewHolder(track, context);
                break;
            case SPEAKER:
                View speaker = inflater.inflate(R.layout.search_item_speaker, parent, false);
                resultHolder = new SpeakerViewHolder(speaker, context);
<<<<<<< HEAD
                ((SpeakerViewHolder)resultHolder).setIsImageCircle(true);
=======
>>>>>>> text_align
                break;
            case LOCATION:
                View location = inflater.inflate(R.layout.item_location, parent, false);
                resultHolder = new LocationViewHolder(location, context);
                break;
            case DIVIDER:
<<<<<<< HEAD
                View header;
                if (context instanceof SearchActivity) {
                    header = inflater.inflate(R.layout.search_result_type_header_format, parent, false);
                } else {
                    header = inflater.inflate(R.layout.recycler_view_header, parent, false);
                }
                resultHolder = new DividerViewHolder(header);
                break;
            case SESSION:
                View bookmark = inflater.inflate(R.layout.item_schedule, parent, false);
                resultHolder = new DayScheduleViewHolder(bookmark, context);
=======
                View header = inflater.inflate(R.layout.search_result_type_header_format, parent, false);
                resultHolder = new SearchResultTypeViewHolder(header);
>>>>>>> text_align
                break;
            default:
                //If viewType doesn't match any of the above objects no view is created
                break;
        }
        return resultHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TRACK:
                TrackViewHolder trackSearchHolder = (TrackViewHolder) holder;
                Track currentTrack = (Track) getItem(position);
                trackSearchHolder.bindTrack(currentTrack);
                break;
            case SPEAKER:
                SpeakerViewHolder speakerSearchHolder = (SpeakerViewHolder) holder;
                Speaker speaker = (Speaker) getItem(position);
                speakerSearchHolder.bindSpeaker(speaker);
                break;
            case LOCATION:
                LocationViewHolder locationSearchHolder = (LocationViewHolder) holder;
                Microlocation location = (Microlocation) getItem(position);
                locationSearchHolder.bindLocation(location);
                break;
            case DIVIDER:
<<<<<<< HEAD
                DividerViewHolder resultTypeViewHolder = (DividerViewHolder) holder;
                String headerItem = (String) getItem(position);
                resultTypeViewHolder.bindHeader(headerItem);
                break;
            case SESSION:
                DayScheduleViewHolder bookmarkTypeViewHolder = (DayScheduleViewHolder) holder;
                Session bookmarkItem = (Session) getItem(position);
                bookmarkTypeViewHolder.setSession(bookmarkItem);
                bookmarkTypeViewHolder.bindSession(realmRepo);
                break;
=======
                SearchResultTypeViewHolder resultTypeViewHolder = (SearchResultTypeViewHolder) holder;
                String headerItem = (String) getItem(position);
                resultTypeViewHolder.bindHeader(headerItem);
                break;
>>>>>>> text_align
            default:
                //If viewType is none of the above then nothing is done
                break;
        }
    }

<<<<<<< HEAD
=======
    protected class SearchResultTypeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_result_type_view)
        protected TextView resultTypeHeader;

        protected SearchResultTypeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void bindHeader(String headerItem) {
            resultTypeHeader.setText(headerItem);
        }
    }
>>>>>>> text_align
}
