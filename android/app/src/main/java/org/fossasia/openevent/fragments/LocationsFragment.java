package org.fossasia.openevent.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
<<<<<<< HEAD
import android.support.v7.widget.DividerItemDecoration;
=======
>>>>>>> text_align
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.LocationsListAdapter;
import org.fossasia.openevent.api.DataDownloadManager;
import org.fossasia.openevent.data.Microlocation;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.MicrolocationDownloadEvent;
<<<<<<< HEAD
import org.fossasia.openevent.utils.NetworkUtils;
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.utils.Views;
import org.fossasia.openevent.views.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.lang.ref.WeakReference;
=======
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.views.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

>>>>>>> text_align
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
<<<<<<< HEAD
import io.realm.RealmResults;
=======
import io.reactivex.disposables.CompositeDisposable;
>>>>>>> text_align
import timber.log.Timber;

/**
 * User: MananWason
 * Date: 8/18/2015
 */
public class LocationsFragment extends BaseFragment implements SearchView.OnQueryTextListener {

    final private String SEARCH = "searchText";

    @BindView(R.id.locations_swipe_refresh) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.list_locations) RecyclerView locationsRecyclerView;
    @BindView(R.id.txt_no_microlocations) TextView noMicrolocationsView;

<<<<<<< HEAD
    private List<Microlocation> locations = new ArrayList<>();
=======
    private List<Microlocation> mLocations = new ArrayList<>();
>>>>>>> text_align
    private LocationsListAdapter locationsListAdapter;
    
    private String searchText = "";
    private SearchView searchView;

<<<<<<< HEAD
    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private RealmResults<Microlocation> realmResults;
=======
    private CompositeDisposable compositeDisposable;
    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
>>>>>>> text_align

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = super.onCreateView(inflater, container, savedInstanceState);

        Utils.registerIfUrlValid(swipeRefreshLayout, this, this::refresh);
<<<<<<< HEAD
        setUpRecyclerView();

        if (savedInstanceState != null && savedInstanceState.getString(SEARCH) != null) {
            searchText = savedInstanceState.getString(SEARCH);
        }

        realmResults = realmRepo.getLocations();
        realmResults.addChangeListener((microlocations, orderedCollectionChangeSet) -> {
            this.locations.clear();
            this.locations.addAll(microlocations);

            locationsListAdapter.setCopyOfTracks(microlocations);
            locationsListAdapter.notifyDataSetChanged();
            if (!Utils.isEmpty(searchText))
                locationsListAdapter.filter(searchText);
            handleVisibility();
        });

        handleVisibility();

        return view;
    }

    private void setUpRecyclerView() {
        locationsListAdapter = new LocationsListAdapter(getContext(), locations);

        locationsRecyclerView.setHasFixedSize(true);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        locationsRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
=======

        compositeDisposable = new CompositeDisposable();

        locationsRecyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        locationsRecyclerView.setLayoutManager(linearLayoutManager);
        locationsListAdapter = new LocationsListAdapter(getContext(), mLocations);
>>>>>>> text_align
        locationsRecyclerView.setAdapter(locationsListAdapter);

        final StickyRecyclerHeadersDecoration headersDecoration = new StickyRecyclerHeadersDecoration(locationsListAdapter);
        locationsRecyclerView.addItemDecoration(headersDecoration);
        locationsListAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
<<<<<<< HEAD
            @Override
            public void onChanged() {
=======
            @Override public void onChanged() {
>>>>>>> text_align
                headersDecoration.invalidateHeaders();
            }
        });
    }

<<<<<<< HEAD
=======
        if (savedInstanceState != null && savedInstanceState.getString(SEARCH) != null) {
            searchText = savedInstanceState.getString(SEARCH);
        }

        realmRepo.getLocations()
                .addChangeListener((microlocations, orderedCollectionChangeSet) -> {
                    mLocations.clear();
                    mLocations.addAll(microlocations);

                    locationsListAdapter.notifyDataSetChanged();
                    handleVisibility();
                });

        handleVisibility();

        return view;
    }

>>>>>>> text_align
    private void handleVisibility() {
        if (locationsListAdapter.getItemCount() != 0) {
            noMicrolocationsView.setVisibility(View.GONE);
            locationsRecyclerView.setVisibility(View.VISIBLE);
        } else {
            noMicrolocationsView.setVisibility(View.VISIBLE);
            locationsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_locations;
    }

    public void setVisibility(Boolean isDownloadDone) {
        if (isDownloadDone) {
            noMicrolocationsView.setVisibility(View.GONE);
            locationsRecyclerView.setVisibility(View.VISIBLE);
        } else {
            noMicrolocationsView.setVisibility(View.VISIBLE);
            locationsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        if (isAdded() && searchView != null) {
            bundle.putString(SEARCH, searchText);
        }
        super.onSaveInstanceState(bundle);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_locations_fragment, menu);
        MenuItem item = menu.findItem(R.id.action_search_locations);
        searchView = (SearchView) MenuItemCompat.getActionView(item);
        DrawableCompat.setTint(menu.findItem(R.id.action_search_locations).getIcon(), Color.WHITE);
        searchView.setOnQueryTextListener(this);
        searchView.setQuery(searchText, false);
    }

    @Override
    public boolean onQueryTextChange(String query) {
<<<<<<< HEAD
        locationsListAdapter.filter(query);
=======
        locationsListAdapter.getFilter().filter(query);
>>>>>>> text_align

        searchText = query;
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.unregisterIfUrlValid(this);

<<<<<<< HEAD
        // Remove listeners to fix memory leak
        realmResults.removeAllChangeListeners();
=======
        if(compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();

        // Remove listeners to fix memory leak
>>>>>>> text_align
        if(swipeRefreshLayout != null) swipeRefreshLayout.setOnRefreshListener(null);
        if(searchView != null) searchView.setOnQueryTextListener(null);
    }

    @Subscribe
    public void onLocationsDownloadDone(MicrolocationDownloadEvent event) {
<<<<<<< HEAD
        Views.setSwipeRefreshLayout(swipeRefreshLayout, false);
=======
        if(swipeRefreshLayout == null)
            return;
>>>>>>> text_align

        if (event.isState()) {
<<<<<<< HEAD
            Timber.d("Locations download completed");
        } else {
            Timber.d("Locations download failed");
            if (getActivity() != null && swipeRefreshLayout != null) {
                Snackbar.make(swipeRefreshLayout, getActivity().getString(R.string.refresh_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> refresh()).show();
            }
=======
            Timber.d("Locations Downloaded");
        } else {
            Snackbar.make(swipeRefreshLayout, getActivity().getString(R.string.refresh_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> refresh()).show();
>>>>>>> text_align
        }
    }

    private void refresh() {
        NetworkUtils.checkConnection(new WeakReference<>(getContext()), new NetworkUtils.NetworkStateReceiverListener() {

            @Override
            public void networkAvailable() {
                // Network is available
                DataDownloadManager.getInstance().downloadMicrolocations();
            }

            @Override
            public void networkUnavailable() {
                OpenEventApp.getEventBus().post(new MicrolocationDownloadEvent(false));
            }
        });
    }
}
