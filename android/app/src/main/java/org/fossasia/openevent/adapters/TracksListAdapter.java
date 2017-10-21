package org.fossasia.openevent.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD

import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.viewholders.HeaderViewHolder;
import org.fossasia.openevent.adapters.viewholders.TrackViewHolder;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.utils.Utils;
=======
import android.widget.Filter;
import android.widget.TextView;

import org.fossasia.openevent.R;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.adapters.viewholders.TrackViewHolder;
>>>>>>> text_align
import org.fossasia.openevent.views.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;
import java.util.Locale;

<<<<<<< HEAD
import io.reactivex.Observable;
=======
import io.realm.Realm;
>>>>>>> text_align
import timber.log.Timber;

/**
 * User: MananWason
 * Date: 07-06-2015
 */
<<<<<<< HEAD
public class TracksListAdapter extends BaseRVAdapter<Track, TrackViewHolder> implements StickyRecyclerHeadersAdapter<HeaderViewHolder> {

    private Context context;
    private List<Track> copyOfTracks = new ArrayList<>();
=======
public class TracksListAdapter extends BaseRVAdapter<Track, TrackViewHolder> implements StickyRecyclerHeadersAdapter {

    private Context context;

    @SuppressWarnings("all")
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            final String query = constraint.toString().toLowerCase(Locale.getDefault());

            Realm realm = Realm.getDefaultInstance();

            List<Track> filteredTracks = realm.copyFromRealm(RealmDataRepository.getInstance(realm)
                    .getTracksFiltered(constraint.toString()));

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredTracks;
            filterResults.count = filteredTracks.size();
            Timber.d("Filtering done total results %d", filterResults.count);

            realm.close();
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if(results == null || results.values == null) {
                Timber.e("No results published. There is an error in query. Check " + getClass().getName() + " filter!");

                return;
            }

            animateTo((List<Track>) results.values);
        }
    };
>>>>>>> text_align

    public TracksListAdapter(Context context, List<Track> tracks) {
        super(tracks);
        this.copyOfTracks = tracks;
        this.context = context;
    }

<<<<<<< HEAD
    public void setCopyOfTracks(List<Track> tracks) {
        this.copyOfTracks = tracks;
    }

    public void filter(String constraint) {
        final String query = constraint.toLowerCase(Locale.getDefault());

        List<Track> filteredTracksList = Observable.fromIterable(copyOfTracks)
                .filter(track -> track.getName()
                        .toLowerCase(Locale.getDefault())
                        .contains(query))
                .toList().blockingGet();

        Timber.d("Filtering done total results %d", filteredTracksList.size());

        if (filteredTracksList.isEmpty()) {
            Timber.e("No results published. There is an error in query. Check " + getClass().getName() + " filter!");
        }

        animateTo(filteredTracksList);
=======
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.bindTrack(getItem(position));
    }
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_track, parent, false);
        return new TrackViewHolder(view,context);
>>>>>>> text_align
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
<<<<<<< HEAD
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.bindTrack(getItem(position));
    }
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_track, parent, false);
        return new TrackViewHolder(view,context);
    }

    @Override
    public long getHeaderId(int position) {
        String trackName = Utils.checkStringEmpty(getItem(position).getName());
        if(!Utils.isEmpty(trackName))
            return trackName.toUpperCase().charAt(0);
        else
            return 0;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_header, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
        String trackName = getItem(position).getName();
        if (!TextUtils.isEmpty(trackName))
            holder.header.setText(String.valueOf(trackName.toUpperCase().charAt(0)));
    }
}
=======
    public long getHeaderId(int position) {
        String trackName = Utils.checkStringEmpty(getItem(position).getName());
        if(!Utils.isEmpty(trackName))
            return trackName.charAt(0);
        else
            return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_header, parent, false);
        return new RecyclerView.ViewHolder(view) {};
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView.findViewById(R.id.recyclerview_view_header);

        String trackName = getItem(position).getName();
        if(!TextUtils.isEmpty(trackName))
            textView.setText(String.valueOf(trackName.charAt(0)));
    }

}
>>>>>>> text_align
