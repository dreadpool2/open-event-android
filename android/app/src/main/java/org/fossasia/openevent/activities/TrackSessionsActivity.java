package org.fossasia.openevent.activities;

import android.content.res.Configuration;
import android.graphics.Color;
<<<<<<< HEAD
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
=======
import android.os.Build;
import android.os.Bundle;
>>>>>>> text_align
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.SessionsListAdapter;
import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.BookmarkChangedEvent;
import org.fossasia.openevent.utils.ConstantStrings;
<<<<<<< HEAD
import org.fossasia.openevent.utils.DateConverter;
import org.fossasia.openevent.utils.DateService;
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.utils.Views;
import org.threeten.bp.ZonedDateTime;
=======
import org.fossasia.openevent.utils.Views;
>>>>>>> text_align

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.realm.RealmObjectChangeListener;
import timber.log.Timber;


/**
 * User: MananWason
 * Date: 14-06-2015
 */
public class TrackSessionsActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    final private String SEARCH = "org.fossasia.openevent.searchText";

    private SessionsListAdapter sessionsListAdapter;

    private GridLayoutManager gridLayoutManager;

<<<<<<< HEAD
    private List<Session> sessions = new ArrayList<>();

    private String searchText = "";
    private int fontColor;
=======
    private List<Session> mSessions = new ArrayList<>();

    private String searchText;
>>>>>>> text_align

    private SearchView searchView;
    private Menu menu;

    private static final int trackWiseSessionList = 4;
    private int trackId;

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private Track track;

    private ActionBar actionBar;

    private int ongoingPosition, upcomingPosition, flag;

<<<<<<< HEAD
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView sessionsRecyclerView;
    @BindView(R.id.txt_no_sessions)
    TextView noSessionsView;
=======
    private static final int trackWiseSessionList = 4;
    private int trackId;

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private Track track;

    private ActionBar actionBar;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recyclerView) RecyclerView sessionsRecyclerView;
    @BindView(R.id.txt_no_sessions) TextView noSessionsView;
>>>>>>> text_align

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);

        setSupportActionBar(toolbar);
        String track = getIntent().getStringExtra(ConstantStrings.TRACK);

        actionBar = getSupportActionBar();
<<<<<<< HEAD
        if (actionBar != null) {
=======
        if(actionBar != null) {
>>>>>>> text_align
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (!TextUtils.isEmpty(track))
                actionBar.setTitle(track);
        }
        if (savedInstanceState != null && savedInstanceState.getString(SEARCH) != null) {
            searchText = savedInstanceState.getString(SEARCH);
        }

        //setting the grid layout to cut-off white space in tablet view
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float width = displayMetrics.widthPixels / displayMetrics.density;
        int spanCount = (int) (width / 250.00);

        sessionsRecyclerView.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(this, spanCount);
        sessionsRecyclerView.setLayoutManager(gridLayoutManager);
<<<<<<< HEAD
        sessionsListAdapter = new SessionsListAdapter(this, sessions, trackWiseSessionList);
=======
        sessionsListAdapter = new SessionsListAdapter(this, mSessions, trackWiseSessionList);
        if(searchText!=null){
            sessionsListAdapter.getFilter().filter(searchText);
        }
>>>>>>> text_align
        sessionsRecyclerView.setAdapter(sessionsListAdapter);
        sessionsRecyclerView.scrollToPosition(SessionsListAdapter.listPosition);
        sessionsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        trackId = getIntent().getIntExtra(ConstantStrings.TRACK_ID, -1);

        sessionsListAdapter.setTrackId(trackId);

        loadData();

        handleVisibility();
    }

    private void loadData() {
        track = realmRepo.getTrack(trackId);
        track.removeAllChangeListeners();
        track.addChangeListener((RealmObjectChangeListener<Track>) (track, objectChangeSet) -> {
            int color = Color.parseColor(track.getColor());
<<<<<<< HEAD
            fontColor = Color.parseColor(track.getFontColor());
            setUiColor(color);

            actionBar.setTitle(track.getName());
            toolbar.setTitleTextColor(fontColor);

            //coloring status bar icons for marshmallow+ devices
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && (sessionsRecyclerView != null) && (fontColor != Color.WHITE)) {
                sessionsRecyclerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

            sessions.clear();
            sessions.addAll(track.getSessions().sort("startsAt"));
            sessionsListAdapter.setCopyOfSessions(track.getSessions().sort("startsAt"));
            if (!Utils.isEmpty(searchText))
                sessionsListAdapter.filter(searchText);
            sessionsListAdapter.notifyDataSetChanged();

            //finding upcoming and ongoing sessions
            int countUpcoming = 0;
            int countOngoing = 0;
            for (Session trackSession : sessions) {
                flag = 0;
                ZonedDateTime start = DateConverter.getDate(trackSession.getStartsAt());
                ZonedDateTime end = DateConverter.getDate((trackSession.getEndsAt()));
                ZonedDateTime current = ZonedDateTime.now();
                if (DateService.isOngoingSession(start, end, current)) {
                    ongoingPosition = countOngoing;
                    break;
                } else if (DateService.isUpcomingSession(start, end, current)) {
                    upcomingPosition = countUpcoming;
                    break;
                } else flag += 1;
                countUpcoming += 1;
                countOngoing += 1;
            }
=======
            setUiColor(color);

            actionBar.setTitle(track.getName());

            mSessions.clear();
            mSessions.addAll(track.getSessions().sort("startTime"));
            sessionsListAdapter.notifyDataSetChanged();
>>>>>>> text_align

            handleVisibility();
        });
    }

    private void handleVisibility() {
<<<<<<< HEAD
        if (!sessions.isEmpty()) {
=======
        if (!mSessions.isEmpty()) {
>>>>>>> text_align
            noSessionsView.setVisibility(View.GONE);
            sessionsRecyclerView.setVisibility(View.VISIBLE);
        } else {
            noSessionsView.setVisibility(View.VISIBLE);
            sessionsRecyclerView.setVisibility(View.GONE);
        }
    }

    private void setUiColor(int color) {
        toolbar.setBackgroundColor(color);

        sessionsListAdapter.setColor(color);

<<<<<<< HEAD
        //setting of back button according to track font color
        Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(fontColor, PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

=======
>>>>>>> text_align
        if (Views.isCompatible(Build.VERSION_CODES.LOLLIPOP)) {
            getWindow().setStatusBarColor(Views.getDarkColor(color));
            sessionsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    Views.setEdgeGlowColorRecyclerView(sessionsRecyclerView, color);
                }
            });

        }
    }

    @Subscribe
    public void onBookmarksChanged(BookmarkChangedEvent bookmarkChangedEvent) {
        Timber.d("Bookmarks Changed");
        loadData();
    }

    @Override
    public void onStart() {
        super.onStart();
        OpenEventApp.getEventBus().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        OpenEventApp.getEventBus().unregister(this);
<<<<<<< HEAD
        if (track != null) track.removeAllChangeListeners();
=======
        if(track != null) track.removeAllChangeListeners();
>>>>>>> text_align
    }

    @Override
    protected void onResume() {
        super.onResume();
        sessionsListAdapter.notifyDataSetChanged();
    }

<<<<<<< HEAD
    @Override
    protected void onDestroy() {
        super.onDestroy();
        DrawableCompat.setTint(menu.findItem(R.id.action_search_tracks).getIcon(), Color.WHITE);
    }

=======
>>>>>>> text_align
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_tracks;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        if (searchView != null) {
            bundle.putString(SEARCH, searchText);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search_sessions:
                return true;
<<<<<<< HEAD
            case R.id.upcoming_sessions:
                if (ongoingPosition != 0)
                    gridLayoutManager.scrollToPositionWithOffset(ongoingPosition, 0);
                else if (upcomingPosition != 0)
                    gridLayoutManager.scrollToPositionWithOffset(upcomingPosition, 0);
                else if (flag > 0) {
                    Toast.makeText(this, getString(R.string.no_upcoming_ongoing), Toast.LENGTH_SHORT).show();
                }
=======
>>>>>>> text_align
            default:
                //Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_tracksessions, menu);
        searchView = (SearchView) menu.findItem(R.id.action_search_tracks).getActionView();
        DrawableCompat.setTint(menu.findItem(R.id.action_search_tracks).getIcon(), Color.parseColor(track.getFontColor()));
        DrawableCompat.setTint(menu.findItem(R.id.upcoming_sessions).getIcon(), Color.parseColor(track.getFontColor()));

        searchView.setOnQueryTextListener(this);
        if (searchText != null) {
            searchView.setQuery(searchText, false);
        }
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float width = displayMetrics.widthPixels / displayMetrics.density;
        int spanCount = (int) (width / 250.00);
        gridLayoutManager.setSpanCount(spanCount);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
<<<<<<< HEAD
=======
        sessionsListAdapter.getFilter().filter(query);

>>>>>>> text_align
        searchText = query;
        sessionsListAdapter.filter(searchText);

        return true;
    }
}
