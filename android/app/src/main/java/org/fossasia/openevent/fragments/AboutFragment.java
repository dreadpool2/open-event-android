package org.fossasia.openevent.fragments;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
<<<<<<< HEAD
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
>>>>>>> text_align

import com.squareup.otto.Subscribe;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
<<<<<<< HEAD
import org.fossasia.openevent.activities.SearchActivity;
import org.fossasia.openevent.adapters.GlobalSearchAdapter;
import org.fossasia.openevent.adapters.SocialLinksListAdapter;
import org.fossasia.openevent.data.Event;
import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.data.extras.Copyright;
import org.fossasia.openevent.data.extras.EventDates;
import org.fossasia.openevent.data.extras.SocialLink;
import org.fossasia.openevent.data.extras.SpeakersCall;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.BookmarkChangedEvent;
import org.fossasia.openevent.events.EventLoadedEvent;
import org.fossasia.openevent.utils.DateConverter;
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.utils.Views;
import org.threeten.bp.format.DateTimeParseException;
=======
import org.fossasia.openevent.adapters.SessionsListAdapter;
import org.fossasia.openevent.data.Event;
import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.data.extras.SocialLink;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.BookmarkChangedEvent;
import org.fossasia.openevent.events.EventLoadedEvent;
import org.fossasia.openevent.utils.DateUtils;
import org.fossasia.openevent.utils.Views;
>>>>>>> text_align

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.realm.RealmResults;
import timber.log.Timber;

/**
 * Created by harshita30 on 9/3/17.
 */

public class AboutFragment extends BaseFragment {

    @BindView(R.id.welcomeMessage)
    protected TextView welcomeMessage;
    @BindView(R.id.event_description)
<<<<<<< HEAD
    protected TextView eventDescription;
    @BindView(R.id.organiser_description)
    protected TextView organiserDescription;
    @BindView(R.id.event_timing_details)
    protected TextView eventTiming;
    @BindView(R.id.item_description_img)
    protected ImageView descriptionImg;
=======
    protected TextView event_description;
    @BindView(R.id.event_timing_details)
    protected TextView event_timing;
    @BindView(R.id.organiser_description)
    protected TextView organiser_description;
    @BindView(R.id.item_description_img)
    protected ImageView mDescriptionImg;
>>>>>>> text_align
    @BindView(R.id.readmore)
    protected TextView readMore;
    @BindView(R.id.readless)
    protected TextView readLess;
<<<<<<< HEAD
    @BindView(R.id.list_social_links)
    protected RecyclerView socialLinksRecyclerView;
    @BindView(R.id.event_venue_details)
    protected TextView venueDetails;
    @BindView(R.id.list_bookmarks)
    protected RecyclerView bookmarksRecyclerView;
    @BindView(R.id.bookmark_header)
    protected TextView bookmarkHeader;
    @BindView(R.id.event_details_header)
    protected TextView eventDetailsHeader;

    private ArrayList<String> dateList = new ArrayList<>();

    private GlobalSearchAdapter bookMarksListAdapter;
    private SocialLinksListAdapter socialLinksListAdapter;
    private RealmResults<Session> bookmarksResult;
    private List<Object> sessions = new ArrayList<>();
    private List<SocialLink> socialLinks = new ArrayList<>();
=======
    @BindView(R.id.img_twitter)
    protected ImageView img_twitter;
    @BindView(R.id.img_facebook)
    protected ImageView img_facebook;
    @BindView(R.id.img_github)
    protected ImageView img_github;
    @BindView(R.id.img_linkedin)
    protected ImageView img_linkedin;
    @BindView(R.id.event_venue_details)
    protected TextView venue_details;
    @BindView(R.id.list_bookmarks)
    protected RecyclerView bookmarksRecyclerView;

    final private String SEARCH = "org.fossasia.openevent.searchText";

    private String searchText = "";
    private SearchView searchView;

    private static final int bookmarkedSessionList =3;
    private SessionsListAdapter sessionsListAdapter;
    private RealmResults<Session> bookmarksResult;
    private List<Session> mSessions = new ArrayList<>();
>>>>>>> text_align

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private Event event;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = super.onCreateView(inflater, container, savedInstanceState);

<<<<<<< HEAD
        setUpBookmarksRecyclerView();
        setUpSocialLinksRecyclerView();
=======
        bookmarksRecyclerView.setVisibility(View.VISIBLE);
        sessionsListAdapter = new SessionsListAdapter(getContext(), mSessions, bookmarkedSessionList);
        sessionsListAdapter.setBookmarkView(true);
        bookmarksRecyclerView.setAdapter(sessionsListAdapter);
        bookmarksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        if (savedInstanceState != null && savedInstanceState.getString(SEARCH) != null) {
            searchText = savedInstanceState.getString(SEARCH);
        }
>>>>>>> text_align

        return view;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_about;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        event = realmRepo.getEvent();
        event.addChangeListener(realmModel -> loadEvent(event));
    }

    @Subscribe
    public void onEventLoaded(EventLoadedEvent eventLoadedEvent) {
        loadEvent(eventLoadedEvent.getEvent());
    }

<<<<<<< HEAD
    private void setUpBookmarksRecyclerView() {
        bookmarksRecyclerView.setVisibility(View.VISIBLE);
        bookMarksListAdapter = new GlobalSearchAdapter(sessions, getContext());
        bookmarksRecyclerView.setAdapter(bookMarksListAdapter);
        bookmarksRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        bookmarksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        bookmarksRecyclerView.setNestedScrollingEnabled(false);
    }

    private void setUpSocialLinksRecyclerView() {
        socialLinksListAdapter = new SocialLinksListAdapter(socialLinks);
        socialLinksRecyclerView.setAdapter(socialLinksListAdapter);
        socialLinksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        socialLinksRecyclerView.setNestedScrollingEnabled(false);
    }

    private void loadEvent(Event event) {
        if (event == null || !event.isValid())
            return;

        String date = String.format("%s\n%s",
                DateConverter.formatDateWithDefault(DateConverter.FORMAT_DATE_COMPLETE, event.getStartsAt()),
                DateConverter.formatDateWithDefault(DateConverter.FORMAT_DATE_COMPLETE, event.getEndsAt()));

        welcomeMessage.setText(String.format(getResources().getString(R.string.welcome_message), event.getName()));
        Views.setHtml(organiserDescription, event.getOrganizerDescription(), true);
        Views.setHtml(eventDescription, event.getDescription(), true);
        venueDetails.setText(event.getLocationName());
        eventTiming.setText(date);
        descriptionImg.setOnClickListener(v -> collapseExpandTextView());
        // Listener to trigger when the TextView is ready to be drawn
        organiserDescription.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (organiserDescription.getLineCount() > 4)
                    readMore.setVisibility(View.VISIBLE);
                // Removing Listener after it has invoked once
                organiserDescription.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        readMore.setOnClickListener(v -> {
            organiserDescription.setMaxLines(Integer.MAX_VALUE);
=======
    private void loadEvent(Event event) {
        if(event == null || !event.isValid())
            return;

        String date = String.format("%s - %s",
                DateUtils.formatDateWithDefault(DateUtils.FORMAT_DATE_COMPLETE, event.getStartTime()),
                DateUtils.formatDateWithDefault(DateUtils.FORMAT_DATE_COMPLETE, event.getEndTime()));

        welcomeMessage.setText(getText(R.string.welcome_message));
        Views.setHtml(organiser_description, event.getOrganizerDescription(), true);
        Views.setHtml(event_description, event.getDescription(), true);
        venue_details.setText(event.getLocationName());
        event_timing.setText(date);
        mDescriptionImg.setOnClickListener(v -> collapseExpandTextView());
        readMore.setOnClickListener(v -> {
            organiser_description.setMaxLines(Integer.MAX_VALUE);
>>>>>>> text_align
            readMore.setVisibility(View.GONE);
            readLess.setVisibility(View.VISIBLE);
        });
        readLess.setOnClickListener(v -> {
<<<<<<< HEAD
            organiserDescription.setMaxLines(4);
=======
            organiser_description.setMaxLines(4);
>>>>>>> text_align
            readLess.setVisibility(View.GONE);
            readMore.setVisibility(View.VISIBLE);
        });

<<<<<<< HEAD
        socialLinks.clear();
        socialLinks.addAll(event.getSocialLinks());
        socialLinksListAdapter.notifyDataSetChanged();
=======
        final List<SocialLink> socialLinks = event.getSocialLinks();
        img_twitter.setOnClickListener(v -> setUpCustomTab(socialLinks.get(2).getLink()));

        img_facebook.setOnClickListener(v -> setUpCustomTab(socialLinks.get(3).getLink()));

        img_github.setOnClickListener(v -> setUpCustomTab(socialLinks.get(7).getLink()));

        img_linkedin.setOnClickListener(v -> setUpCustomTab(socialLinks.get(8).getLink()));

>>>>>>> text_align
    }

    @TargetApi(16)
    void collapseExpandTextView() {
<<<<<<< HEAD
        if (eventDescription.getVisibility() == View.GONE) {
            // it's collapsed - expand it
            eventDescription.setVisibility(View.VISIBLE);
            descriptionImg.setImageResource(R.drawable.ic_expand_less_black_24dp);
        } else {
            // it's expanded - collapse it
            eventDescription.setVisibility(View.GONE);
            descriptionImg.setImageResource(R.drawable.ic_expand_more_black_24dp);
        }

        ObjectAnimator animation = ObjectAnimator.ofInt(eventDescription, "maxLines", eventDescription.getMaxLines());
        animation.setDuration(200).start();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_search_home:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.action_ticket_home:
                if (!event.isValid()) {
                    Snackbar.make(getView(), R.string.info_not_available, Snackbar.LENGTH_SHORT).show();
                    break;
                }
                Utils.setUpCustomTab(getContext(), event.getTicketUrl());
                break;
            case R.id.action_display_copyright_dialog:
                displayCopyrightInformation();
                break;
            case R.id.action_display_speakers_call_dialog:
                displaySpeakersCallInformation();
            default:
                //No option selected. Do Nothing..
        }

        return true;
    }

    private void displayCopyrightInformation() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.copyright_dialog, null);
        dialogBuilder.setView(dialogView).setPositiveButton("Back", (dialog, which) -> dialog.cancel());
        Copyright copyright = event.getEventCopyright();
        TextView holder = (TextView) dialogView.findViewById(R.id.holder_textview);
        TextView licence = (TextView) dialogView.findViewById(R.id.licence);
        TextView licenceurl = (TextView) dialogView.findViewById(R.id.licence_url);

        licence.setText(copyright.getLicence() + " " + String.valueOf(copyright.getYear()));
        holder.setText(copyright.getHolder());
        String linkedurl = String.format("<a href=\"%s\">" + copyright.getLicenceUrl() + "</a> ", copyright.getLicenceUrl());
        licenceurl.setText(Html.fromHtml(linkedurl));
        licenceurl.setOnClickListener(view -> Utils.setUpCustomTab(getContext(), event.getEventCopyright().getLicenceUrl()));
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void displaySpeakersCallInformation() {
        AlertDialog.Builder dialogBuilder  = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.speakers_call_dialog, null);
        TextView holder = (TextView) dialogView.findViewById(R.id.holder_textview);
        TextView announcement = (TextView) dialogView.findViewById(R.id.announcement);
        TextView fromDateOfEvent = (TextView) dialogView.findViewById(R.id.from_date_textview);
        TextView toDateOfEvent = (TextView) dialogView.findViewById(R.id.to_date_textview);

        SpeakersCall speakersCall = event.getSpeakersCall();
        holder.setText(event.getEventCopyright().getHolder());
        String announcementString = Html.fromHtml(speakersCall.getAnnouncement()).toString();
        announcement.setText(announcementString + "at " + event.getEmail());
        int index = speakersCall.getStartsAt().indexOf("T");
        toDateOfEvent.setText("To: " + speakersCall.getStartsAt().substring(0, index));
        fromDateOfEvent.setText("From: " + speakersCall.getEndsAt().substring(0, index));
        dialogBuilder.setView(dialogView).setNegativeButton("Back", (dialog, which) -> dialog.cancel());
        dialogBuilder.setPositiveButton("Copy Email",
                (dialog, which) -> {
                    ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Email", event.getEmail());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getContext().getApplicationContext(), "Email copied to clipboard", Toast.LENGTH_SHORT).show();
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
=======
        if (event_description.getVisibility() == View.GONE) {
            // it's collapsed - expand it
            event_description.setVisibility(View.VISIBLE);
            mDescriptionImg.setImageResource(R.drawable.ic_expand_less_black_24dp);
        } else {
            // it's expanded - collapse it
            event_description.setVisibility(View.GONE);
            mDescriptionImg.setImageResource(R.drawable.ic_expand_more_black_24dp);
        }

        ObjectAnimator animation = ObjectAnimator.ofInt(event_description, "maxLines", event_description.getMaxLines());
        animation.setDuration(200).start();
    }

    private void setUpCustomTab(String url) {

        Uri uri = Uri.parse(url);

        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();

        intentBuilder.setToolbarColor(ContextCompat.getColor(getContext(), R.color.color_primary));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(getContext(), R.color.color_primary_dark));

        intentBuilder.setStartAnimations(getContext(), R.anim.slide_in_right, R.anim.slide_out_left);
        intentBuilder.setExitAnimations(getContext(), android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);

        CustomTabsIntent customTabsIntent = intentBuilder.build();

        customTabsIntent.launchUrl(getActivity(), uri);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_home, menu);
        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager)getContext(). getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search_home).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default
>>>>>>> text_align
    }

    @Subscribe
    public void onBookmarksChanged(BookmarkChangedEvent bookmarkChangedEvent) {
        Timber.d("Bookmarks changed");
        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void handleVisibility() {
<<<<<<< HEAD
        if (!sessions.isEmpty()) {
            bookmarksRecyclerView.setVisibility(View.VISIBLE);
            bookmarkHeader.setVisibility(View.VISIBLE);
        } else {
            bookmarksRecyclerView.setVisibility(View.GONE);
            bookmarkHeader.setVisibility(View.GONE);
        }
    }

    private void loadEventDates() {
        dateList.clear();
        RealmResults<EventDates> eventDates = realmRepo.getEventDatesSync();
        for (EventDates eventDate : eventDates) {
            dateList.add(eventDate.getDate());
=======
        if (!mSessions.isEmpty()) {
            bookmarksRecyclerView.setVisibility(View.VISIBLE);
        } else {
            bookmarksRecyclerView.setVisibility(View.GONE);
>>>>>>> text_align
        }
    }

    private void loadData() {
<<<<<<< HEAD
        loadEventDates();

        bookmarksResult = realmRepo.getBookMarkedSessions();
        bookmarksResult.removeAllChangeListeners();
        bookmarksResult.addChangeListener((bookmarked, orderedCollectionInnerChangeSet) -> {

            sessions.clear();
            for (String eventDate : dateList) {
                boolean headerCheck = false;
                for (Session bookmarkedSession : bookmarked) {
                    if (bookmarkedSession.getStartDate().equals(eventDate)) {
                        if (!headerCheck) {
                            String headerDate = "Invalid";
                            try {
                                headerDate = DateConverter.formatDay(eventDate);
                            } catch (DateTimeParseException e) {
                                e.printStackTrace();
                            }
                            sessions.add(headerDate);
                            headerCheck = true;
                        }
                        sessions.add(bookmarkedSession);
                    }
                }
                bookMarksListAdapter.notifyDataSetChanged();
                handleVisibility();
            }
=======
        bookmarksResult = realmRepo.getBookMarkedSessions();
        bookmarksResult.removeAllChangeListeners();
        bookmarksResult.addChangeListener((bookmarked, orderedCollectionChangeSet) -> {
            mSessions.clear();
            mSessions.addAll(bookmarked);

            sessionsListAdapter.notifyDataSetChanged();

            handleVisibility();
>>>>>>> text_align
        });
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
        if (bookmarksResult != null)
            bookmarksResult.removeAllChangeListeners();
        if (event != null && event.isValid())
            event.removeAllChangeListeners();
    }
=======
        if(bookmarksResult != null)
            bookmarksResult.removeAllChangeListeners();
        if(event != null && event.isValid())
            event.removeAllChangeListeners();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        if (searchView != null) {
            bundle.putString(SEARCH, searchText);
        }
        super.onSaveInstanceState(bundle);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        // Remove listeners to fix memory leak
        if(searchView != null) searchView.setOnQueryTextListener(null);
    }
>>>>>>> text_align
}