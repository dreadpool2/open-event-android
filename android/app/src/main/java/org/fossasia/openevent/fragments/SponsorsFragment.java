package org.fossasia.openevent.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.SponsorsListAdapter;
import org.fossasia.openevent.api.DataDownloadManager;
import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.SponsorDownloadEvent;
import org.fossasia.openevent.utils.NetworkUtils;
<<<<<<< HEAD
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.utils.Views;
import org.fossasia.openevent.views.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
=======
import org.fossasia.openevent.utils.ShowNotificationSnackBar;
import org.fossasia.openevent.utils.Utils;
>>>>>>> text_align

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
<<<<<<< HEAD
import io.realm.RealmResults;
=======
import io.realm.Realm;
>>>>>>> text_align
import timber.log.Timber;

/**
 * Created by MananWason on 05-06-2015.
 */
public class SponsorsFragment extends BaseFragment {

<<<<<<< HEAD
    private List<Sponsor> sponsors = new ArrayList<>();
=======
    private List<Sponsor> mSponsors = new ArrayList<>();
>>>>>>> text_align
    private SponsorsListAdapter sponsorsListAdapter;

    @BindView(R.id.txt_no_sponsors)
    TextView noSponsorsView;
    @BindView(R.id.sponsor_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.list_sponsors)
    RecyclerView sponsorsRecyclerView;

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
<<<<<<< HEAD
    private RealmResults<Sponsor> realmResults;
=======
    private Realm realm = realmRepo.getRealmInstance();
>>>>>>> text_align

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final View view = super.onCreateView(inflater, container, savedInstanceState);

        Utils.registerIfUrlValid(swipeRefreshLayout, this, this::refresh);
<<<<<<< HEAD
        setUpRecyclerView();

        realmResults = realmRepo.getSponsors();
        realmResults.addChangeListener((sponsors, orderedCollectionChangeSet) -> {
            this.sponsors.clear();
            this.sponsors.addAll(sponsors);

            sponsorsListAdapter.notifyDataSetChanged();
            handleVisibility();
        });

        return view;
    }

    private void setUpRecyclerView() {
        sponsorsListAdapter = new SponsorsListAdapter(getContext(), sponsors);

        sponsorsRecyclerView.setHasFixedSize(true);
        sponsorsRecyclerView.setAdapter(sponsorsListAdapter);
        sponsorsRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        sponsorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final StickyRecyclerHeadersDecoration headersDecoration = new StickyRecyclerHeadersDecoration(sponsorsListAdapter);
        sponsorsRecyclerView.addItemDecoration(headersDecoration);
        sponsorsListAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                headersDecoration.invalidateHeaders();
            }
        });
    }

=======

        sponsorsListAdapter = new SponsorsListAdapter(getContext(), mSponsors,
                getActivity(), true);
        sponsorsRecyclerView.setAdapter(sponsorsListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        sponsorsRecyclerView.setLayoutManager(linearLayoutManager);

        RealmDataRepository.getDefaultInstance()
                .getSponsors()
                .addChangeListener((sponsors, orderedCollectionChangeSet) -> {
                    mSponsors.clear();
                    mSponsors.addAll(realm.copyFromRealm(sponsors));

                    sponsorsListAdapter.notifyDataSetChanged();
                    handleVisibility();
                });

        return view;
    }

>>>>>>> text_align
    private void handleVisibility() {
        if (sponsorsListAdapter.getItemCount() != 0) {
            noSponsorsView.setVisibility(View.GONE);
            sponsorsRecyclerView.setVisibility(View.VISIBLE);
        } else {
            noSponsorsView.setVisibility(View.VISIBLE);
            sponsorsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_sponsors;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.unregisterIfUrlValid(this);

        // Remove listeners to fix memory leak
<<<<<<< HEAD
        realmResults.removeAllChangeListeners();
=======
>>>>>>> text_align
        if(swipeRefreshLayout != null) swipeRefreshLayout.setOnRefreshListener(null);
    }

    @Subscribe
    public void sponsorDownloadDone(SponsorDownloadEvent event) {
<<<<<<< HEAD
        Views.setSwipeRefreshLayout(swipeRefreshLayout, false);
=======
        if(swipeRefreshLayout == null)
            return;
>>>>>>> text_align

        if (event.isState()) {
<<<<<<< HEAD
            Timber.i("Sponsors download completed");
        } else {
            Timber.i("Sponsors download failed");
            if (getActivity() != null && swipeRefreshLayout != null) {
                Snackbar.make(swipeRefreshLayout, getActivity().getString(R.string.refresh_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> refresh()).show();
            }
=======
            Timber.d("Refresh done");
        } else {
            Snackbar.make(swipeRefreshLayout, getActivity().getString(R.string.refresh_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> refresh()).show();
            Timber.d("Refresh not done");
>>>>>>> text_align
        }
    }

    private void refresh() {
        NetworkUtils.checkConnection(new WeakReference<>(getContext()), new NetworkUtils.NetworkStateReceiverListener() {
<<<<<<< HEAD

            @Override
            public void networkAvailable() {
                // Network is available
                DataDownloadManager.getInstance().downloadSponsors();
            }

            @Override
            public void networkUnavailable() {
=======
            @Override
            public void activeConnection() {
                //Internet is working
                DataDownloadManager.getInstance().downloadSponsors();
            }

            @Override
            public void inactiveConnection() {
                //Device is connected to WI-FI or Mobile Data but Internet is not working
                ShowNotificationSnackBar showNotificationSnackBar = new ShowNotificationSnackBar(getContext(),getView(),swipeRefreshLayout) {
                    @Override
                    public void refreshClicked() {
                        refresh();
                    }
                };
                //show snackbar will be useful if user have blocked notification for this app
                showNotificationSnackBar.showSnackBar();
                //show notification (Only when connected to WiFi)
                showNotificationSnackBar.buildNotification();
            }

            @Override
            public void networkAvailable() {
                // Network is available but we need to wait for activity
            }

            @Override
            public void networkUnavailable() {
                Snackbar.make(swipeRefreshLayout, getActivity().getString(R.string.refresh_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> refresh()).show();
>>>>>>> text_align
                OpenEventApp.getEventBus().post(new SponsorDownloadEvent(true));
            }
        });
    }

}
