package org.fossasia.openevent.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v7.widget.DividerItemDecoration;
=======
>>>>>>> text_align
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.GlobalSearchAdapter;
import org.fossasia.openevent.data.Microlocation;
<<<<<<< HEAD
import org.fossasia.openevent.data.Session;
=======
>>>>>>> text_align
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.data.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import timber.log.Timber;

public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener {

    private GlobalSearchAdapter globalSearchAdapter;
    private List<Object> results = new ArrayList<>();

    private Realm realm = Realm.getDefaultInstance();

    private SearchView searchView;
    private String searchText;

    private final String SEARCH = "SAVE_KEY_ON_ROTATE";

    @BindView(R.id.search_recyclerView)
<<<<<<< HEAD
    protected RecyclerView searchRecyclerView;
=======
    protected  RecyclerView searchRecyclerView;
>>>>>>> text_align
    @BindView(R.id.txt_no_results)
    protected TextView noResultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OpenEventApp.getEventBus().register(this);

<<<<<<< HEAD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

=======
>>>>>>> text_align
        handleVisibility();

        globalSearchAdapter = new GlobalSearchAdapter(results, this);
        searchRecyclerView.setAdapter(globalSearchAdapter);
<<<<<<< HEAD
        searchRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
=======
>>>>>>> text_align
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState != null && savedInstanceState.getString(SEARCH) != null) {
            searchText = savedInstanceState.getString(SEARCH);
        }

        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            handleIntent(getIntent());
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_search;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
<<<<<<< HEAD
        inflater.inflate(R.menu.menu_search_activity, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
=======
        inflater.inflate(R.menu.menu_home, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search_home).getActionView();
>>>>>>> text_align
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(this);
<<<<<<< HEAD
        // To expand search view by default
        searchView.setIconified(false);
        searchView.requestFocus();
=======
>>>>>>> text_align
        if (searchText != null) {
            searchView.setQuery(searchText, true);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (query != null) {
            searchQuery(query);
            searchText = query;
        } else {
            results.clear();
            handleVisibility();
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent) {
        final String query = intent.getStringExtra(SearchManager.QUERY);
        searchQuery(query);
    }

    private void searchQuery(String constraint) {
        results.clear();

        if (!TextUtils.isEmpty(constraint)) {
            String query = constraint.toLowerCase(Locale.getDefault());
            String wildcardQuery = String.format("*%s*", query);
            addResultsFromTracks(wildcardQuery);
<<<<<<< HEAD
            addResultFromSessions(wildcardQuery);
=======
>>>>>>> text_align
            addResultsFromSpeakers(wildcardQuery);
            addResultsFromLocations(wildcardQuery);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (searchView != null) {
            outState.putString(SEARCH, searchText);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OpenEventApp.getEventBus().unregister(this);

        //Closing realm instance and detaching listeners to avoid memory leaks
        realm.close();
        realm.removeAllChangeListeners();

        //Set listener to null to avoid memory leaks
        if (searchView != null) searchView.setOnQueryTextListener(null);
    }

    public void addResultsFromTracks(String queryString) {
        RealmResults<Track> filteredTracks = realm.where(Track.class)
                .like("name", queryString, Case.INSENSITIVE).findAllSortedAsync("name");

        filteredTracks.addChangeListener(tracks -> {
<<<<<<< HEAD
            if (tracks.size() > 0) {
=======
            if(tracks.size()>0){
>>>>>>> text_align
                results.add("Tracks");
            }
            results.addAll(tracks);
            globalSearchAdapter.notifyDataSetChanged();
            Timber.d("Filtering done total results %d", tracks.size());
            handleVisibility();
        });
    }

    public void addResultsFromSpeakers(String queryString) {
        RealmResults<Speaker> filteredSpeakers = realm.where(Speaker.class)
                .like("name", queryString, Case.INSENSITIVE).or()
                .like("country", queryString, Case.INSENSITIVE).or()
                .like("organisation", queryString, Case.INSENSITIVE).findAllSortedAsync("name");

        filteredSpeakers.addChangeListener(speakers -> {
<<<<<<< HEAD
            if (speakers.size() > 0) {
=======
            if(speakers.size()>0){
>>>>>>> text_align
                results.add("Speakers");
            }
            results.addAll(speakers);
            globalSearchAdapter.notifyDataSetChanged();
            Timber.d("Filtering done total results %d", speakers.size());
            handleVisibility();
        });
    }

    public void addResultsFromLocations(String queryString) {
        RealmResults<Microlocation> filteredMicrolocations = realm.where(Microlocation.class)
                .like("name", queryString, Case.INSENSITIVE).findAllSortedAsync("name");

        filteredMicrolocations.addChangeListener(microlocations -> {
<<<<<<< HEAD
            if (microlocations.size() > 0) {
                results.add("Locations");
=======
            if(microlocations.size()>0) {
                results.add("Location");
>>>>>>> text_align
            }
            results.addAll(filteredMicrolocations);
            globalSearchAdapter.notifyDataSetChanged();
            Timber.d("Filtering done total results %d", microlocations.size());
            handleVisibility();
        });
    }

<<<<<<< HEAD
    public void addResultFromSessions(String queryString) {
        RealmResults<Session> filteredSessions = realm.where(Session.class)
                .like("title", queryString, Case.INSENSITIVE).findAllSortedAsync("title");

        filteredSessions.addChangeListener(sessions -> {
            if (sessions.size() > 0) {
                results.add("Sessions");
            }
            results.addAll(filteredSessions);
            globalSearchAdapter.notifyDataSetChanged();
            Timber.d("Filtering done total results %d", sessions.size());
            handleVisibility();
        });
    }

=======
>>>>>>> text_align
    public void handleVisibility() {
        if (results.size() == 0) {
            noResultsView.setVisibility(View.VISIBLE);
            searchRecyclerView.setVisibility(View.INVISIBLE);
        } else {
            noResultsView.setVisibility(View.INVISIBLE);
            searchRecyclerView.setVisibility(View.VISIBLE);
        }
    }
}

