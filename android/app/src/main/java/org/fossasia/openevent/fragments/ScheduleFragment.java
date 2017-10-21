package org.fossasia.openevent.fragments;

import android.app.AlertDialog;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;
import android.content.res.Resources;
>>>>>>> text_align
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.ScheduleViewPagerAdapter;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.dbutils.RealmDataRepository;
import org.fossasia.openevent.utils.ConstantStrings;
<<<<<<< HEAD
import org.fossasia.openevent.utils.DateConverter;
import org.fossasia.openevent.utils.SharedPreferencesUtil;
import org.fossasia.openevent.utils.Utils;
import org.threeten.bp.format.DateTimeParseException;

=======
import org.fossasia.openevent.utils.DateUtils;

import java.text.ParseException;
>>>>>>> text_align
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

/**
 * Created by Manan Wason on 16/06/16.
 */
public class ScheduleFragment extends BaseFragment {

    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout scheduleTabLayout;
    @BindView(R.id.schedule_fab_filter) FloatingActionButton fabFilter;
    @BindView(R.id.filter_text) TextView filtersText;
    @BindView(R.id.close_filter) ImageView closeFilterBarButton;
    @BindView(R.id.filter_bar) LinearLayout filterBar;

    private CompositeDisposable compositeDisposable;
    private int sortType;
<<<<<<< HEAD
    private ScheduleViewPagerAdapter adapter;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private List<Track> tracks = new ArrayList<>();
=======
    private SharedPreferences sharedPreferences;
    private ScheduleViewPagerAdapter adapter;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private List<Track> mTracks = new ArrayList<>();
>>>>>>> text_align
    private String tracksNames[];
    private boolean isTrackSelected[];
    private List<String> selectedTracks;

    private RealmDataRepository realmRepo = RealmDataRepository.getDefaultInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = super.onCreateView(inflater, container, savedInstanceState);

        filterBar.setVisibility(View.GONE);
        OpenEventApp.getEventBus().register(true);
        compositeDisposable = new CompositeDisposable();
<<<<<<< HEAD
        sortType = SharedPreferencesUtil.getInt(ConstantStrings.PREF_SORT_SCHEDULE, 2);
=======
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sortType = sharedPreferences.getInt(ConstantStrings.PREF_SORT, 0);
>>>>>>> text_align
        selectedTracks = new ArrayList<>();

        setupViewPager(viewPager);
        scheduleTabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_schedule;
    }

    private void setupViewPager(final ViewPager viewPager) {
        adapter = new ScheduleViewPagerAdapter(getChildFragmentManager());

        realmRepo.getEventDates()
                .addChangeListener((eventDates, orderedCollectionChangeSet) -> {
                    int eventDays = eventDates.size();
                    for (int i = 0; i < eventDays; i++) {
                        String date = eventDates.get(i).getDate();

                        try {
                            adapter.addFragment(new DayScheduleFragment(),
<<<<<<< HEAD
                                    DateConverter.formatDay(date), date);
                            adapter.notifyDataSetChanged();
                        } catch (DateTimeParseException pe) {
=======
                                    DateUtils.formatDay(date), date);
                            adapter.notifyDataSetChanged();
                        } catch (ParseException pe) {
>>>>>>> text_align
                            Timber.e(pe);
                            Timber.e("Invalid date %s in database", date);
                        }
                    }
                });

        realmRepo.getTracks().addChangeListener((tracks, orderedCollectionChangeSet) -> {
<<<<<<< HEAD
            this.tracks.clear();
            this.tracks.addAll(tracks);
            tracksNames = new String[this.tracks.size()];
            isTrackSelected = new boolean[this.tracks.size()];

            for(int i = 0; i < this.tracks.size(); i++){
                tracksNames[i] = this.tracks.get(i).getName();
=======
            mTracks.clear();
            mTracks.addAll(tracks);
            tracksNames = new String[mTracks.size()];
            isTrackSelected = new boolean[mTracks.size()];

            for(int i = 0; i < mTracks.size(); i++){
                tracksNames[i] = mTracks.get(i).getName();
>>>>>>> text_align
            }
        });

        viewPager.setAdapter(adapter);
<<<<<<< HEAD
        viewPager.setPageMargin(Math.round(Utils.dpToPx(15)));
=======
        viewPager.setPageMargin(dpToPx(15));
>>>>>>> text_align
        viewPager.setPageMarginDrawable(R.color.grey);

        onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // No action
            }

            @Override
            public void onPageSelected(int position) {
                // No action
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                notifyUpdate(-1, selectedTracks);
            }
        };

        viewPager.addOnPageChangeListener(onPageChangeListener);
    }
<<<<<<< HEAD

    private void notifyUpdate(int position, List<String> selectedTracks) {
        if(position == -1)
            position = viewPager.getCurrentItem();

=======

    private int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private void notifyUpdate(int position, List<String> selectedTracks) {
        if(position == -1)
            position = viewPager.getCurrentItem();

>>>>>>> text_align
        ((DayScheduleFragment) adapter.getItem(position)).filter(selectedTracks);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort:
                final AlertDialog.Builder dialogSort = new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.dialog_sort_title)
                        .setSingleChoiceItems(R.array.session_sort, sortType, (dialog, which) -> {
                            sortType = which;
<<<<<<< HEAD
                            SharedPreferencesUtil.putInt(ConstantStrings.PREF_SORT_SCHEDULE, which);
=======
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt(ConstantStrings.PREF_SORT, which);
                            editor.apply();
>>>>>>> text_align
                            notifyUpdate(-1, selectedTracks);
                            dialog.dismiss();
                        });

                dialogSort.show();
                break;
            default:
                //Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick (R.id.schedule_fab_filter)
    public void filterSchedule() {
        final AlertDialog.Builder dialogSort = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.dialog_filter_title)
                .setMultiChoiceItems(tracksNames, isTrackSelected, (dialog, which, isSelected) -> isTrackSelected[which] = isSelected)
                .setPositiveButton("Filter", (dialogInterface, j) -> {
                    selectedTracks.clear();
                    int count = 0;
                    String tracksFiltered = "";
                    for(int i=0 ; i<isTrackSelected.length ; i++) {
                        if (isTrackSelected[i]) {
                            selectedTracks.add(tracksNames[i]);
                            if(count == 0)
                                tracksFiltered += tracksNames[i];
                            else
                                tracksFiltered += ("," + tracksNames[i]);
                            count++;
                        }
                    }
                    notifyUpdate(-1, selectedTracks);
                    if(count!=0) {
                        filtersText.setText("Filters" + "(" + count +")" + ": " + tracksFiltered);
                        filterBar.setVisibility(View.VISIBLE);
                    } else {
                        filterBar.setVisibility(View.GONE);
                    }
                });

        dialogSort.show();
    }

    @OnClick (R.id.close_filter)
    public void closeFilterBar() {
        Arrays.fill(isTrackSelected, false);
        selectedTracks.clear();
        notifyUpdate(-1, selectedTracks);
        filterBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OpenEventApp.getEventBus().unregister(this);
        if(compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
        if(viewPager != null && onPageChangeListener != null)
            viewPager.removeOnPageChangeListener(onPageChangeListener);
    }
}

