package org.fossasia.openevent.activities;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;
>>>>>>> text_align
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Html;
<<<<<<< HEAD
=======
import android.text.Spannable;
import android.text.SpannableString;
>>>>>>> text_align
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;
=======
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
>>>>>>> text_align
import com.squareup.otto.Subscribe;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
<<<<<<< HEAD
import org.fossasia.openevent.activities.auth.UserProfileActivity;
import org.fossasia.openevent.adapters.FeedAdapter;
import org.fossasia.openevent.api.APIClient;
=======
>>>>>>> text_align
import org.fossasia.openevent.api.DataDownloadManager;
import org.fossasia.openevent.api.Urls;
import org.fossasia.openevent.data.Event;
import org.fossasia.openevent.data.Microlocation;
import org.fossasia.openevent.data.Session;
<<<<<<< HEAD
import org.fossasia.openevent.data.SessionType;
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.data.extras.Copyright;
import org.fossasia.openevent.data.extras.SocialLink;
import org.fossasia.openevent.data.facebook.CommentItem;
=======
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.data.Track;
>>>>>>> text_align
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.events.CounterEvent;
import org.fossasia.openevent.events.DataDownloadEvent;
import org.fossasia.openevent.events.DownloadEvent;
import org.fossasia.openevent.events.EventDownloadEvent;
import org.fossasia.openevent.events.EventLoadedEvent;
import org.fossasia.openevent.events.JsonReadEvent;
import org.fossasia.openevent.events.MicrolocationDownloadEvent;
import org.fossasia.openevent.events.NoInternetEvent;
import org.fossasia.openevent.events.RetrofitError;
import org.fossasia.openevent.events.RetrofitResponseEvent;
import org.fossasia.openevent.events.SessionDownloadEvent;
import org.fossasia.openevent.events.SessionTypesDownloadEvent;
import org.fossasia.openevent.events.ShowNetworkDialogEvent;
import org.fossasia.openevent.events.SpeakerDownloadEvent;
import org.fossasia.openevent.events.SponsorDownloadEvent;
import org.fossasia.openevent.events.TracksDownloadEvent;
import org.fossasia.openevent.fragments.AboutFragment;
<<<<<<< HEAD
import org.fossasia.openevent.fragments.CommentsDialogFragment;
import org.fossasia.openevent.fragments.FeedFragment;
=======
>>>>>>> text_align
import org.fossasia.openevent.fragments.LocationsFragment;
import org.fossasia.openevent.fragments.ScheduleFragment;
import org.fossasia.openevent.fragments.SpeakersListFragment;
import org.fossasia.openevent.fragments.SponsorsFragment;
import org.fossasia.openevent.fragments.TracksFragment;
import org.fossasia.openevent.utils.AuthUtil;
import org.fossasia.openevent.utils.CommonTaskLoop;
import org.fossasia.openevent.utils.ConstantStrings;
<<<<<<< HEAD
import org.fossasia.openevent.utils.DateConverter;
=======
import org.fossasia.openevent.utils.DateUtils;
>>>>>>> text_align
import org.fossasia.openevent.utils.DownloadCompleteHandler;
import org.fossasia.openevent.utils.NetworkUtils;
import org.fossasia.openevent.utils.SharedPreferencesUtil;
import org.fossasia.openevent.utils.SmoothActionBarDrawerToggle;
import org.fossasia.openevent.utils.Utils;
<<<<<<< HEAD
=======
import org.fossasia.openevent.views.CustomTabsSpan;
>>>>>>> text_align
import org.fossasia.openevent.widget.DialogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.lang.reflect.Type;
>>>>>>> text_align
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
<<<<<<< HEAD
import io.realm.RealmList;
import io.realm.RealmResults;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements FeedAdapter.AdapterCallback {
=======
import timber.log.Timber;

import static org.fossasia.openevent.R.id.headerDrawer;

public class MainActivity extends BaseActivity {

    private final static String STATE_FRAGMENT = "stateFragment";
>>>>>>> text_align

    private static final String STATE_FRAGMENT = "stateFragment";
    private static final String NAV_ITEM = "navItem";
    private static final String BOOKMARK = "bookmarks";
    private static final String FRAGMENT_TAG_HOME = "HOME_FRAGMENT";
    private static final String FRAGMENT_TAG_REST = "REST_FRAGMENTS";

<<<<<<< HEAD
    private boolean fromServer = true;
    private boolean atHome = true;
    private boolean backPressedOnce;
    private boolean isTwoPane;
    private boolean isAuthEnabled = SharedPreferencesUtil.getBoolean(ConstantStrings.IS_AUTH_ENABLED, false);
    private boolean customTabsSupported;
    private int currentMenuItemId;
=======
    private static final String FRAGMENT_TAG_HOME = "FTAGH";

    private final String FRAGMENT_TAG_TRACKS = "FTAGT";

    private final String FRAGMENT_TAG_REST = "FTAGR";
>>>>>>> text_align

    private boolean fromServer = true;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.layout_main) CoordinatorLayout mainFrame;
    @BindView(R.id.appbar) AppBarLayout appBarLayout;
    @Nullable @BindView(R.id.drawer) DrawerLayout drawerLayout;
    private ImageView headerView;

<<<<<<< HEAD
    private Context context;
    private Dialog dialogNetworkNotification;
    private FragmentManager fragmentManager;
    private CustomTabsServiceConnection customTabsServiceConnection;
    private CustomTabsClient customTabsClient;
    private DownloadCompleteHandler completeHandler;
    private CompositeDisposable disposable;
    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private Event event; // Future Event, stored to remove listeners
=======
    private ImageView headerView;

    private DrawerLayout drawerLayout;
    private Context context;
    private SharedPreferences sharedPreferences;
    private boolean atHome = true;
    private boolean backPressedOnce = false;
    private int currentMenuItemId;
    private boolean mTwoPane = false;
    private boolean customTabsSupported;
    private CustomTabsServiceConnection customTabsServiceConnection;
    private CustomTabsClient customTabsClient;
    private Runnable runnable;
    private Handler handler;
    public static Dialog dialogNetworkNotiff;
>>>>>>> text_align

    private DownloadCompleteHandler completeHandler;

<<<<<<< HEAD
=======
    private CompositeDisposable disposable;

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();
    private Event event; // Future Event, stored to remove listeners

    public static Intent createLaunchFragmentIntent(Context context) {
        return new Intent(context, MainActivity.class)
                .putExtra(NAV_ITEM, BOOKMARK);
    }

>>>>>>> text_align
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
<<<<<<< HEAD
        ((OpenEventApp) getApplicationContext()).attachMainActivity(this);
        ButterKnife.setDebug(true);
        fragmentManager = getSupportFragmentManager();
        setTheme(R.style.AppTheme_NoActionBar_MainTheme);
        super.onCreate(savedInstanceState);

        SharedPreferencesUtil.putInt(ConstantStrings.SESSION_MAP_ID, -1);
        isTwoPane = drawerLayout == null;
        Utils.setTwoPane(isTwoPane);
=======
        ButterKnife.setDebug(true);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putInt(ConstantStrings.SESSION_MAP_ID, -1).apply();
        setTheme(R.style.AppTheme_NoActionBar_MainTheme);
        super.onCreate(savedInstanceState);

        if(findViewById(R.id.drawer)!=null) {
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
            mTwoPane = false;
        } else {
            mTwoPane = true;
        }
>>>>>>> text_align

        disposable = new CompositeDisposable();

        setUpToolbar();
        setUpNavDrawer();
        setUpCustomTab();
        setupEvent();

        completeHandler = DownloadCompleteHandler.with(context);

        if (Utils.isBaseUrlEmpty()) {
<<<<<<< HEAD
            if (!SharedPreferencesUtil.getBoolean(ConstantStrings.IS_DOWNLOAD_DONE, false)) {
                downloadFromAssets();
                SharedPreferencesUtil.putBoolean(ConstantStrings.IS_DOWNLOAD_DONE, true);
            }
        } else {
            setupConnection();
        }

        if (savedInstanceState == null) {
            currentMenuItemId = R.id.nav_home;
        } else {
            currentMenuItemId = savedInstanceState.getInt(STATE_FRAGMENT);
        }

        if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_HOME) == null &&
                getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_REST) == null) {
            doMenuAction(currentMenuItemId);
        }
=======
            if (!sharedPreferences.getBoolean(ConstantStrings.IS_DOWNLOAD_DONE, false)) {
                downloadFromAssets();
                sharedPreferences.edit().putBoolean(ConstantStrings.IS_DOWNLOAD_DONE, true).apply();
            }
        } else {
            downloadFromServer();
        }

        if (savedInstanceState == null) {
            currentMenuItemId = R.id.nav_home;
        } else {
            currentMenuItemId = savedInstanceState.getInt(STATE_FRAGMENT);
        }

        if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_HOME) == null &&
                getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_REST) == null) {
            doMenuAction(currentMenuItemId);
        }
    }

    private void downloadFromServer(){
        NetworkUtils.checkConnection(new WeakReference<>(this), new NetworkUtils.NetworkStateReceiverListener() {
            @Override
            public void activeConnection() {
                //Internet is working
                if (!sharedPreferences.getBoolean(ConstantStrings.IS_DOWNLOAD_DONE, false)) {
                    DialogFactory.createDownloadDialog(context, R.string.download_assets, R.string.charges_warning, (dialogInterface, button) -> {
                        if (button==DialogInterface.BUTTON_POSITIVE) {
                            fromServer = true;
                            Boolean preference = sharedPreferences.getBoolean(getResources().getString(R.string.download_mode_key), true);
                            if (preference) {
                                disposable.add(NetworkUtils.haveNetworkConnectionObservable(MainActivity.this)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(connected -> {
                                            if (connected) {
                                                OpenEventApp.postEventOnUIThread(new DataDownloadEvent());
                                            } else {
                                                final Snackbar snackbar = Snackbar.make(mainFrame, R.string.internet_preference_warning, Snackbar.LENGTH_INDEFINITE);
                                                snackbar.setAction(R.string.yes, view -> downloadFromAssets());
                                                snackbar.show();
                                            }
                                        }));
                            } else {
                                OpenEventApp.postEventOnUIThread(new DataDownloadEvent());
                            }
                        } else if (button==DialogInterface.BUTTON_NEGATIVE) {
                            fromServer = false;
                            downloadFromAssets();
                        }
                    }).show();
                } else {
                    completeHandler.hide();
                }
            }

            @Override
            public void inactiveConnection() {
                //Device is connected to WI-FI or Mobile Data but Internet is not working
                ShowNotificationSnackBar showNotificationSnackBar = new ShowNotificationSnackBar(MainActivity.this,mainFrame,null) {
                    @Override
                    public void refreshClicked() {
                        OpenEventApp.getEventBus().unregister(this);
                        OpenEventApp.getEventBus().register(this);
                    }
                };
                //show snackbar
                showNotificationSnackBar.showSnackBar();
                //snow notification (Only when connected to WiFi)
                showNotificationSnackBar.buildNotification();
            }

            @Override
            public void networkAvailable() {
                // Waiting for connectivity
            }

            @Override
            public void networkUnavailable() {
                Snackbar.make(mainFrame, R.string.display_offline_schedule, Snackbar.LENGTH_LONG).show();
                downloadFromAssets();
            }
        });
>>>>>>> text_align
    }

    private void setUpCustomTab() {
        Intent customTabIntent = new Intent("android.support.customtabs.action.CustomTabsService");
        customTabIntent.setPackage("com.android.chrome");
        customTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                customTabsClient = client;
                customTabsClient.warmup(0L);
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                //initially left empty
            }
        };
        customTabsSupported = bindService(customTabIntent, customTabsServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onPause() {
        super.onPause();
        OpenEventApp.getEventBus().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        OpenEventApp.getEventBus().register(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_FRAGMENT, currentMenuItemId);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        currentMenuItemId = savedInstanceState.getInt(STATE_FRAGMENT);
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        setupDrawerContent(navigationView);
        return super.onPrepareOptionsMenu(menu);
    }

    private void setUpToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private void setupEvent() {
        event = realmRepo.getEventSync();

        if(event == null)
            return;

        setNavHeader(event);
    }

    private void setUpNavDrawer() {
<<<<<<< HEAD
        setUpUserProfileMenu();
        headerView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.headerDrawer);
        if (toolbar != null && !isTwoPane) {
=======
        headerView = (ImageView) navigationView.getHeaderView(0).findViewById(headerDrawer);
        if (toolbar != null && !mTwoPane) {
>>>>>>> text_align
            final ActionBar ab = getSupportActionBar();
            if(ab == null) return;
            SmoothActionBarDrawerToggle smoothActionBarToggle = new SmoothActionBarDrawerToggle(this,
                    drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

                @Override
                public void onDrawerStateChanged(int newState) {
                    super.onDrawerStateChanged(newState);

                    if(toolbar.getTitle().equals(getString(R.string.menu_about))) {
                        navigationView.setCheckedItem(R.id.nav_home);
                    }
                }
            };

            drawerLayout.addDrawerListener(smoothActionBarToggle);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
            smoothActionBarToggle.syncState();
        } else if (toolbar!=null && toolbar.getTitle().equals(getString(R.string.menu_about))) {
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

<<<<<<< HEAD
    private void setUpUserProfileMenu() {
        if (!isAuthEnabled) {
            navigationView.getMenu().setGroupVisible(R.id.menu_user_profile, false);
            return;
        }

        MenuItem userProfileMenuItem = navigationView.getMenu().findItem(R.id.nav_user_profile);
        if (AuthUtil.isUserLoggedIn()) {
            String email = SharedPreferencesUtil.getString(ConstantStrings.USER_EMAIL, null);
            if (email != null) {
                userProfileMenuItem.setTitle(email);
            }
        }
    }

    private void setNavHeader(Event event) {
        String logo = event.getLogoUrl();
        if (!Utils.isEmpty(logo)) {
            OpenEventApp.picassoWithCache.load(logo).into(headerView);
        } else {
            OpenEventApp.picassoWithCache.load(R.mipmap.ic_launcher).into(headerView);
=======
    private void setNavHeader(Event event) {
        String logo = event.getLogo();
        if (!logo.isEmpty()) {
            OpenEventApp.picassoWithCache.load(logo).into(headerView);
>>>>>>> text_align
        }
    }

    private void saveEventDates(Event event) {
<<<<<<< HEAD
        String startTime = event.getStartsAt();
        String endTime = event.getEndsAt();

        Observable.fromCallable(() ->
                DateConverter.getDaysInBetween(startTime, endTime)
=======
        String startTime = event.getStartTime();
        String endTime = event.getEndTime();

        Observable.fromCallable(() ->
                DateUtils.getDaysInBetween(startTime, endTime)
>>>>>>> text_align
        ).subscribe(eventDates -> realmRepo.saveEventDates(eventDates).subscribe(), throwable -> {
            Timber.e(throwable);
            Timber.e("Error start parsing start date: %s and end date: %s in ISO format",
                    startTime, endTime);
            OpenEventApp.postEventOnUIThread(new RetrofitError(new Throwable("Error parsing dates")));
        });
    }

    private void syncComplete() {
        String successMessage = "Data loaded from JSON";

        if (fromServer) {
            // Event successfully loaded, set data downloaded to true
<<<<<<< HEAD
            SharedPreferencesUtil.putBoolean(ConstantStrings.IS_DOWNLOAD_DONE, true);
=======
            sharedPreferences.edit().putBoolean(ConstantStrings.IS_DOWNLOAD_DONE, true).apply();
>>>>>>> text_align

            successMessage = "Download done";
        }

        Snackbar.make(mainFrame, getString(R.string.download_complete), Snackbar.LENGTH_SHORT).show();
        Timber.d(successMessage);

        setupEvent();
        OpenEventApp.postEventOnUIThread(new EventLoadedEvent(event));
        saveEventDates(event);
<<<<<<< HEAD

        downloadPageId();
    }

    private void startDownloadFromNetwork() {
        fromServer = true;
        boolean preference = SharedPreferencesUtil.getBoolean(getResources().getString(R.string.download_mode_key), true);
        if (preference) {
            disposable.add(NetworkUtils.haveNetworkConnectionObservable(MainActivity.this)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(isConnected -> {
                        if (isConnected) {
                            OpenEventApp.postEventOnUIThread(new DataDownloadEvent());
                        } else {
                            final Snackbar snackbar = Snackbar.make(mainFrame, R.string.internet_preference_warning, Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction(R.string.yes, view -> downloadFromAssets());
                            snackbar.show();
                        }
                    }));
        } else {
            OpenEventApp.postEventOnUIThread(new DataDownloadEvent());
        }
    }

    private void downloadPageId() {
        //Store the facebook page name in the shared preference from the database
        if(SharedPreferencesUtil.getString(ConstantStrings.FACEBOOK_PAGE_NAME, null) == null) {
            RealmList<SocialLink> socialLinks = event.getSocialLinks();
            RealmResults<SocialLink> facebookPage = socialLinks.where().equalTo("name", "Facebook").findAll();
            if (facebookPage.size() == 0)
                return;

            SocialLink facebookLink = facebookPage.get(0);
            String link = facebookLink.getLink();
            String tempString = ".com";
            String pageName = link.substring(link.indexOf(tempString) + tempString.length()).replace("/", "");

            if (Utils.isEmpty(pageName))
                return;

            SharedPreferencesUtil.putString(ConstantStrings.FACEBOOK_PAGE_NAME, pageName);
        }

        if(SharedPreferencesUtil.getString(ConstantStrings.FACEBOOK_PAGE_ID, null) == null &&
                SharedPreferencesUtil.getString(ConstantStrings.FACEBOOK_PAGE_NAME, null) != null) {
            APIClient.getFacebookGraphAPI().getPageId(SharedPreferencesUtil.getString(ConstantStrings.FACEBOOK_PAGE_NAME, null),
                    getResources().getString(R.string.facebook_access_token))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(facebookPageId -> {
                                String id = facebookPageId.getId();
                                SharedPreferencesUtil.putString(ConstantStrings.FACEBOOK_PAGE_ID, id);
                            },
                            throwable -> Timber.d("Facebook page id download failed: " + throwable.toString()));
        }
    }

    private void setupConnection() {
        NetworkUtils.checkConnection(new WeakReference<>(this), new NetworkUtils.NetworkStateReceiverListener() {

            @Override
            public void networkAvailable() {
                // Network is available
                if (!SharedPreferencesUtil.getBoolean(ConstantStrings.IS_DOWNLOAD_DONE, false)) {
                    DialogFactory.createDownloadDialog(context, R.string.download_assets, R.string.charges_warning,
                            (dialogInterface, button) -> {
                                switch (button) {
                                    case DialogInterface.BUTTON_POSITIVE:
                                        startDownloadFromNetwork();
                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        downloadFromAssets();
                                        break;
                                    default:
                                        // No action to be taken
                                }
                            }).show();
                } else {
                    completeHandler.hide();
                }
            }

            @Override
            public void networkUnavailable() {
                downloadFromAssets();
                Snackbar.make(mainFrame, R.string.display_offline_schedule, Snackbar.LENGTH_LONG).show();
            }
        });
    }

=======
    }

>>>>>>> text_align
    private void downloadFailed(final DownloadEvent event) {
        Snackbar.make(mainFrame, getString(R.string.download_failed), Snackbar.LENGTH_LONG).setAction(R.string.retry_download, view -> {
            if (event == null)
                OpenEventApp.postEventOnUIThread(new DataDownloadEvent());
            else
                OpenEventApp.postEventOnUIThread(event);
        }).show();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            final int id = menuItem.getItemId();
<<<<<<< HEAD
            if(!isTwoPane) {
=======
            if(!mTwoPane) {
>>>>>>> text_align
                drawerLayout.closeDrawers();
                drawerLayout.postDelayed(() -> doMenuAction(id), 300);
            } else {
                doMenuAction(id);
            }
            return true;
        });
<<<<<<< HEAD
    }

    private void shareApplication() {
        try {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.whatsapp_promo_msg_template),
                    String.format(getString(R.string.app_share_url),getPackageName())));
            startActivity(shareIntent);
        }
        catch (Exception e) {
            Snackbar.make(mainFrame, getString(R.string.error_msg_retry), Snackbar.LENGTH_SHORT).show();
        }
    }


    private void replaceFragment(Fragment fragment, int title) {
        boolean isAtHome = false;
        String TAG = FRAGMENT_TAG_REST;

        if(fragment instanceof AboutFragment) {
            isAtHome = true;
            TAG = FRAGMENT_TAG_HOME;
        }

        addShadowToAppBar(currentMenuItemId != R.id.nav_schedule);
        atHome = isAtHome;

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment, TAG).commit();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        appBarLayout.setExpanded(true, true);
    }

    private void doMenuAction(int menuItemId) {
        Intent intent;
        currentMenuItemId = menuItemId;

        switch (menuItemId) {
            case R.id.nav_home:
                replaceFragment(new AboutFragment(), R.string.menu_home);
                break;
            case R.id.nav_tracks:
                replaceFragment(new TracksFragment(), R.string.menu_tracks);
=======
    }

    private void doMenuAction(int menuItemId) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        switch (menuItemId) {
            case R.id.nav_home:
                atHome = true;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new AboutFragment(), FRAGMENT_TAG_HOME).commit();
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_home);
                }
                if (currentMenuItemId == R.id.nav_schedule){
                    addShadowToAppBar(false);
                }
                break;
            case R.id.nav_tracks:
                atHome = false;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new TracksFragment(), FRAGMENT_TAG_REST).commit();
                addShadowToAppBar(true);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_tracks);
                }
>>>>>>> text_align
                break;
            case R.id.nav_feed:
                replaceFragment(new FeedFragment(), R.string.menu_feed);
                break;
<<<<<<< HEAD
            case R.id.nav_schedule:
                replaceFragment(new ScheduleFragment(), R.string.menu_schedule);
                break;
            case R.id.nav_speakers:
                replaceFragment(new SpeakersListFragment(), R.string.menu_speakers);
                break;
            case R.id.nav_sponsors:
                replaceFragment(new SponsorsFragment(), R.string.menu_sponsor);
                break;
            case R.id.nav_locations:
                replaceFragment(new LocationsFragment(), R.string.menu_locations);
                break;
            case R.id.nav_map:
                Bundle bundle = new Bundle();
                bundle.putBoolean(ConstantStrings.IS_MAP_FRAGMENT_FROM_MAIN_ACTIVITY, true);
                Fragment mapFragment = ((OpenEventApp)getApplication())
                        .getMapModuleFactory()
                        .provideMapModule()
                        .provideMapFragment();
                mapFragment.setArguments(bundle);
                replaceFragment(mapFragment, R.string.menu_map);
                break;
            case R.id.nav_user_profile:
                intent = new Intent(MainActivity.this, UserProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                shareApplication();
=======
            case R.id.nav_speakers:
                atHome = false;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new SpeakersListFragment(), FRAGMENT_TAG_REST).commit();
                addShadowToAppBar(true);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_speakers);
                }
                break;
            case R.id.nav_sponsors:
                atHome = false;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new SponsorsFragment(), FRAGMENT_TAG_REST).commit();
                addShadowToAppBar(true);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_sponsor);
                }
                break;
            case R.id.nav_locations:
                atHome = false;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new LocationsFragment(), FRAGMENT_TAG_REST).commit();
                addShadowToAppBar(true);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_locations);
                }
                break;
            case R.id.nav_map:
                atHome = false;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.content_frame,
                        ((OpenEventApp) getApplication())
                                .getMapModuleFactory()
                                .provideMapModule()
                                .provideMapFragment(), FRAGMENT_TAG_REST).commit();
                addShadowToAppBar(true);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("");
                }
                break;
            case R.id.nav_settings:
                final Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.whatsapp_promo_msg_template),
                            String.format(getString(R.string.app_share_url),getPackageName())));
                    startActivity(shareIntent);
                }
                catch (Exception e) {
                    Snackbar.make(mainFrame, getString(R.string.error_msg_retry), Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_about:

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                String app_name = sharedPreferences.getString(ConstantStrings.APP_NAME, "");
                String org_description = sharedPreferences.getString(ConstantStrings.ORG_DESCRIPTION, "");

                final AlertDialog aboutUs = new AlertDialog.Builder(this)
                        .setTitle(app_name)
                        .setMessage(Html.fromHtml(org_description))
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();
                aboutUs.show();

                TextView aboutUsTV = (TextView) aboutUs.findViewById(android.R.id.message);
                if(aboutUsTV == null) break;
                aboutUsTV.setMovementMethod(LinkMovementMethod.getInstance());
                if (customTabsSupported) {
                    SpannableString welcomeAlertSpannable = new SpannableString(aboutUsTV.getText());
                    URLSpan[] spans = welcomeAlertSpannable.getSpans(0, welcomeAlertSpannable.length(), URLSpan.class);
                    for (URLSpan span : spans) {
                        CustomTabsSpan newSpan = new CustomTabsSpan(span.getURL(), getApplicationContext(), this,
                                customTabsClient.newSession(new CustomTabsCallback()));
                        welcomeAlertSpannable.setSpan(newSpan, welcomeAlertSpannable.getSpanStart(span),
                                welcomeAlertSpannable.getSpanEnd(span),
                                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                        welcomeAlertSpannable.removeSpan(span);
                    }
                    aboutUsTV.setText(welcomeAlertSpannable);
                }
>>>>>>> text_align
                break;
            default:
                //Do nothing
        }
<<<<<<< HEAD
=======
        currentMenuItemId = menuItemId;
>>>>>>> text_align
    }

    @Override
    public void onBackPressed() {
<<<<<<< HEAD
        if (!isTwoPane && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (atHome) {
            if (backPressedOnce) {
                super.onBackPressed();
            } else {
                backPressedOnce = true;
                Snackbar snackbar = Snackbar.make(mainFrame, R.string.press_back_again, 2000);
                snackbar.show();
                new Handler().postDelayed(() -> backPressedOnce = false, 2000);
            }
        } else {
            replaceFragment(new AboutFragment(), R.string.menu_home);
            navigationView.setCheckedItem(R.id.nav_home);
            addShadowToAppBar(true);
=======
        if(!mTwoPane) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (atHome) {
                if (backPressedOnce) {
                    super.onBackPressed();
                } else {
                    backPressedOnce = true;
                    Snackbar snackbar = Snackbar.make(mainFrame, R.string.press_back_again, 2000);
                    snackbar.show();
                    runnable = () -> backPressedOnce = false;
                    handler = new Handler();
                    long timer = 2000;
                    handler.postDelayed(runnable, timer);
                }
            } else {
                atHome = true;
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, new AboutFragment(), FRAGMENT_TAG_REST).commit();
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(R.string.menu_home);
                }
                if (currentMenuItemId == R.id.nav_schedule) {
                    addShadowToAppBar(false);
                }
            }
>>>>>>> text_align
        }
    }

    public void addShadowToAppBar(boolean addShadow) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            return;

        if (addShadow) {
            appBarLayout.setElevation(Utils.dpToPx(4));
        } else {
            appBarLayout.setElevation(0);
        }
    }

    private void startDownloadListener() {
        completeHandler.startListening()
                .show()
                .withCompletionListener()
                .subscribe(this::syncComplete, throwable -> {
                    throwable.printStackTrace();
                    Timber.e(throwable);
                    if (throwable instanceof DownloadCompleteHandler.DataEventError) {
                        downloadFailed(((DownloadCompleteHandler.DataEventError) throwable)
                                .getDataDownloadEvent());
                    } else {
                        OpenEventApp.postEventOnUIThread(new RetrofitError(throwable));
                    }
                });
    }

    private void startDownload() {
<<<<<<< HEAD
        int eventId = SharedPreferencesUtil.getInt(ConstantStrings.EVENT_ID, 0);
        if (eventId == 0)
            return;
        DataDownloadManager.getInstance().downloadEvent(eventId);
=======
        realmRepo.clearVersions().subscribe(() -> {
            Timber.d("Cleared JSON db versions");
        }, throwable -> {
            throwable.printStackTrace();
            Timber.e(throwable);
        });

        DataDownloadManager.getInstance().downloadEvents();
>>>>>>> text_align
        startDownloadListener();
        Timber.d("Download has started");
    }

    public void showErrorDialog(String errorType, String errorDesc) {
        completeHandler.hide();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.error)
                .setMessage(errorType + ": " + errorDesc)
                .setNeutralButton(android.R.string.ok, null)
                .create();
        builder.show();
    }

<<<<<<< HEAD
    public void showErrorSnackbar(String errorType, String errorDesc) {
        completeHandler.hide();
        Snackbar.make(mainFrame, errorType + ": " + errorDesc, Snackbar.LENGTH_LONG).show();
    }

    public void dismissDialogNetworkNotification() {
        if (dialogNetworkNotification != null)
            dialogNetworkNotification.dismiss();
    }

=======
>>>>>>> text_align
    @Subscribe
    public void noInternet(NoInternetEvent event) {
        downloadFailed(null);
    }

    @Subscribe
    public void showNetworkDialog(ShowNetworkDialogEvent event) {
        completeHandler.hide();
<<<<<<< HEAD
        if (dialogNetworkNotification == null) {
            dialogNetworkNotification = DialogFactory.createSimpleActionDialog(this,
                    R.string.net_unavailable,
                    R.string.turn_on,
                    (dialog, which) -> {
                        Intent setNetworkIntent = new Intent(Settings.ACTION_SETTINGS);
                        startActivity(setNetworkIntent);
                    });
        }

        dialogNetworkNotification.show();
=======
        dialogNetworkNotiff = DialogFactory.createSimpleActionDialog(this,
                R.string.net_unavailable,
                R.string.turn_on,
                (dialog, which) -> {
                    Intent setNetworkIntent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(setNetworkIntent);
                });
        dialogNetworkNotiff.show();
>>>>>>> text_align
    }

    @Subscribe
    public void downloadData(DataDownloadEvent event) {
        switch (Urls.getBaseUrl()) {
            case Urls.INVALID_LINK:
                showErrorDialog("Invalid Api", "Api link doesn't seem to be valid");
                downloadFromAssets();
                break;
            case Urls.EMPTY_LINK:
                downloadFromAssets();
                break;
            default:
                startDownload();
                break;
        }
    }

    @Subscribe
    public void handleResponseEvent(RetrofitResponseEvent responseEvent) {
        Integer statusCode = responseEvent.getStatusCode();
        if (statusCode.equals(404)) {
            showErrorDialog("HTTP Error", statusCode + "Api Not Found");
        }
    }

    @Subscribe
    public void handleJsonEvent(final JsonReadEvent jsonReadEvent) {
        final String name = jsonReadEvent.getName();
        final String json = jsonReadEvent.getJson();
<<<<<<< HEAD

        Completable.fromAction(() -> {
            ObjectMapper objectMapper = OpenEventApp.getObjectMapper();

            // Need separate instance for background thread
            Realm realm = Realm.getDefaultInstance();

            RealmDataRepository realmDataRepository = RealmDataRepository
                    .getInstance(realm);

            switch (name) {
                case ConstantStrings.EVENT: {
                    Event event = objectMapper.readValue(json, Event.class);

                    saveEventDates(event);
                    realmDataRepository.saveEvent(event).subscribe();

                    realmDataRepository.saveEvent(event).subscribe();

                    OpenEventApp.postEventOnUIThread(new EventDownloadEvent(true));
                    break;
                } case ConstantStrings.TRACKS: {
                    List<Track> tracks = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Track.class));

                    realmDataRepository.saveTracks(tracks).subscribe();

                    OpenEventApp.postEventOnUIThread(new TracksDownloadEvent(true));
                    break;
                } case ConstantStrings.SESSIONS: {
                    List<Session> sessions = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Session.class));

                    for (Session current : sessions) {
                        current.setStartDate(current.getStartsAt().split("T")[0]);
=======

        Completable.fromAction(() -> {
            final Gson gson = new Gson();

            // Need separate instance for background thread
            Realm realm = Realm.getDefaultInstance();

            RealmDataRepository realmDataRepository = RealmDataRepository
                    .getInstance(realm);

            switch (name) {
                case ConstantStrings.EVENT: {
                    Event event = gson.fromJson(json, Event.class);

                    saveEventDates(event);
                    realmDataRepository.saveEvent(event).subscribe();

                    realmDataRepository.saveEvent(event).subscribe();

                    OpenEventApp.postEventOnUIThread(new EventDownloadEvent(true));
                    break;
                } case ConstantStrings.TRACKS: {
                    Type listType = new TypeToken<List<Track>>() {}.getType();
                    List<Track> tracks = gson.fromJson(json, listType);

                    realmDataRepository.saveTracks(tracks).subscribe();

                    OpenEventApp.postEventOnUIThread(new TracksDownloadEvent(true));
                    break;
                } case ConstantStrings.SESSIONS: {
                    Type listType = new TypeToken<List<Session>>() {}.getType();
                    List<Session> sessions = gson.fromJson(json, listType);

                    for (Session current : sessions) {
                        current.setStartDate(current.getStartTime().split("T")[0]);
>>>>>>> text_align
                    }

                    realmDataRepository.saveSessions(sessions).subscribe();

                    OpenEventApp.postEventOnUIThread(new SessionDownloadEvent(true));
                    break;
                } case ConstantStrings.SPEAKERS: {
<<<<<<< HEAD
                    List<Speaker> speakers = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Speaker.class));
=======
                    Type listType = new TypeToken<List<Speaker>>() {}.getType();
                    List<Speaker> speakers = gson.fromJson(json, listType);
>>>>>>> text_align

                    realmRepo.saveSpeakers(speakers).subscribe();

                    OpenEventApp.postEventOnUIThread(new SpeakerDownloadEvent(true));
                    break;
                } case ConstantStrings.SPONSORS: {
<<<<<<< HEAD
                    List<Sponsor> sponsors = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Sponsor.class));
=======
                    Type listType = new TypeToken<List<Sponsor>>() {}.getType();
                    List<Sponsor> sponsors = gson.fromJson(json, listType);
>>>>>>> text_align

                    realmRepo.saveSponsors(sponsors).subscribe();

                    OpenEventApp.postEventOnUIThread(new SponsorDownloadEvent(true));
                    break;
                } case ConstantStrings.MICROLOCATIONS: {
<<<<<<< HEAD
                    List<Microlocation> microlocations = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Microlocation.class));
=======
                    Type listType = new TypeToken<List<Microlocation>>() {}.getType();
                    List<Microlocation> microlocations = gson.fromJson(json, listType);
>>>>>>> text_align

                    realmRepo.saveLocations(microlocations).subscribe();

                    OpenEventApp.postEventOnUIThread(new MicrolocationDownloadEvent(true));
                    break;
<<<<<<< HEAD
                } case ConstantStrings.SESSION_TYPES: {
                    List<SessionType> sessionTypes = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, SessionType.class));

                    realmRepo.saveSessionTypes(sessionTypes).subscribe();

                    OpenEventApp.postEventOnUIThread(new SessionTypesDownloadEvent(true));
                    break;
                } default:
                    //do nothing
            }
=======
                } default:
                    //do nothing
            }

>>>>>>> text_align
            realm.close();
        }).observeOn(Schedulers.computation()).subscribe(() -> Timber.d("Saved event from JSON"), throwable -> {
            throwable.printStackTrace();
            Timber.e(throwable);
            OpenEventApp.postEventOnUIThread(new RetrofitError(throwable));
        });
    }

    @Subscribe
    public void errorHandlerEvent(RetrofitError error) {
        String errorType;
        String errorDesc;
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = connMgr.getActiveNetworkInfo();
        if (!(netinfo != null && netinfo.isConnected())) {
            OpenEventApp.postEventOnUIThread(new ShowNetworkDialogEvent());
        } else {
            if (error.getThrowable() instanceof IOException) {
                errorType = "Timeout";
                errorDesc = String.valueOf(error.getThrowable().getCause());
            } else if (error.getThrowable() instanceof IllegalStateException) {
                errorType = "ConversionError";
                errorDesc = String.valueOf(error.getThrowable().getCause());
            } else {
                errorType = "Other Error";
                errorDesc = String.valueOf(error.getThrowable().getLocalizedMessage());
            }
            Timber.tag(errorType).e(errorDesc);
            showErrorSnackbar(errorType, errorDesc);
        }
    }

    public void downloadFromAssets() {
        fromServer = false;
        if (!SharedPreferencesUtil.getBoolean(ConstantStrings.DATABASE_RECORDS_EXIST, false)) {
            //TODO: Add and Take counter value from to config.json
<<<<<<< HEAD
            SharedPreferencesUtil.putBoolean(ConstantStrings.DATABASE_RECORDS_EXIST, true);
=======
            sharedPreferences.edit().putBoolean(ConstantStrings.DATABASE_RECORDS_EXIST, true).apply();
>>>>>>> text_align

            startDownloadListener();
            Timber.d("JSON parsing started");

<<<<<<< HEAD
            OpenEventApp.postEventOnUIThread(new CounterEvent(7)); // Bump if increased
=======
            OpenEventApp.postEventOnUIThread(new CounterEvent(6)); // Bump if increased
>>>>>>> text_align

            readJsonAsset(Urls.EVENT);
            readJsonAsset(Urls.SESSIONS);
            readJsonAsset(Urls.SPEAKERS);
            readJsonAsset(Urls.TRACKS);
            readJsonAsset(Urls.SPONSORS);
            readJsonAsset(Urls.MICROLOCATIONS);
            readJsonAsset(Urls.SESSION_TYPES);
        } else {
            completeHandler.hide();
        }
    }

    public void readJsonAsset(final String name) {
        CommonTaskLoop.getInstance().post(new Runnable() {
            String json = null;

            @Override
            public void run() {
                try {
                    InputStream inputStream = getAssets().open(name);
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    if (inputStream.read(buffer) == -1)
                        Timber.d("Empty Stream");
                    inputStream.close();
                    json = new String(buffer, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                OpenEventApp.postEventOnUIThread(new JsonReadEvent(name, json));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(customTabsServiceConnection);
<<<<<<< HEAD
=======
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
>>>>>>> text_align
        if(disposable != null && !disposable.isDisposed())
            disposable.dispose();
        if(event != null)
            event.removeAllChangeListeners();
        if(completeHandler != null)
            completeHandler.stopListening();
<<<<<<< HEAD
        ((OpenEventApp) getApplicationContext()).detachMainActivity();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onMethodCallback(List<CommentItem> commentItems) {
        CommentsDialogFragment newFragment = new CommentsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(ConstantStrings.FACEBOOK_COMMENTS, new ArrayList<>(commentItems));
        newFragment.setArguments(bundle);
        newFragment.show(fragmentManager, "Comments");
    }
}
=======
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
>>>>>>> text_align
