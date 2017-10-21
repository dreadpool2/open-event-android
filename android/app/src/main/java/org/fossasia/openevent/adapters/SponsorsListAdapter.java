package org.fossasia.openevent.adapters;

import android.content.Context;
<<<<<<< HEAD
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.fossasia.openevent.R;
import org.fossasia.openevent.adapters.viewholders.HeaderViewHolder;
import org.fossasia.openevent.adapters.viewholders.SponsorViewHolder;
import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.utils.Utils;
import org.fossasia.openevent.views.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.List;

=======
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.data.Sponsor;
import org.fossasia.openevent.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

>>>>>>> text_align
/**
 * User: MananWason
 * Date: 09-06-2015
 */
<<<<<<< HEAD
public class SponsorsListAdapter extends BaseRVAdapter<Sponsor, SponsorViewHolder> implements StickyRecyclerHeadersAdapter<HeaderViewHolder> {
=======
public class SponsorsListAdapter extends BaseRVAdapter<Sponsor, RecyclerView.ViewHolder> {

    private static final int SPONSOR = 0;
    private static final int CATEGORY = 1;
>>>>>>> text_align

    private Context context;

<<<<<<< HEAD
    public SponsorsListAdapter(Context context, List<Sponsor> sponsors) {
=======
    private CompositeDisposable disposable;

    public SponsorsListAdapter(Context context, List<Sponsor> sponsors, Activity activity, boolean customTabsSupported) {
>>>>>>> text_align
        super(sponsors);
        this.context = context;
    }

    @Override
<<<<<<< HEAD
    public SponsorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
=======
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        disposable = new CompositeDisposable();
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if(disposable != null && !disposable.isDisposed())
            disposable.dispose();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

>>>>>>> text_align
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sponsor, parent, false);
        return new SponsorViewHolder(view, context);
    }

    @Override
<<<<<<< HEAD
    public void onBindViewHolder(final SponsorViewHolder holder, int position) {
        holder.bindSponsor(getItem(position));
=======
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SponsorViewHolder) {

            final SponsorViewHolder sponsorViewHolder = (SponsorViewHolder) holder;
            DisplayMetrics displayMetrics = (sponsorViewHolder.sponsorImage.getContext().getResources().getDisplayMetrics());
            final int width = displayMetrics.widthPixels;
            final int height = displayMetrics.heightPixels;
            Sponsor currentSponsor = getItem(position);

            String sponserName = Utils.checkStringEmpty(currentSponsor.getName());
            String sponserType = Utils.checkStringEmpty(currentSponsor.getSponsorType());
            String logo = Utils.parseImageUri(currentSponsor.getLogo());

            sponsorViewHolder.sponsorType.setText(sponserType);
            sponsorViewHolder.sponsorName.setText(sponserName);
            if(logo != null) {
                sponsorViewHolder.sponsorImage.setVisibility(View.VISIBLE);
                OpenEventApp.picassoWithCache
                        .load(Uri.parse(logo))
                        .resize(width, (height / 6))
                        .centerInside()
                        .into(sponsorViewHolder.sponsorImage);
            } else {
                sponsorViewHolder.sponsorImage.setVisibility(View.GONE);
            }

            sponsorViewHolder.itemView.setOnClickListener(view -> {
                Sponsor sponsor = getItem(holder.getAdapterPosition());
                String sponsorUrl = sponsor.getUrl();

                if(TextUtils.isEmpty(sponsorUrl))
                    return;

                if (!sponsorUrl.startsWith("http") && !sponsorUrl.startsWith("https")) {
                    sponsorUrl = "http://" + sponsorUrl;
                }
                if (Patterns.WEB_URL.matcher(sponsorUrl).matches()) {
                    if (customTabsSupported) {
                        CustomTabsIntent.Builder customTabsBuilder = new CustomTabsIntent.Builder();

                        customTabsBuilder.setToolbarColor(ContextCompat.getColor(context, R.color.color_primary));
                        customTabsBuilder.setCloseButtonIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_arrow_back_white_cct_24dp));
                        customTabsBuilder.setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_left);
                        customTabsBuilder.setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right);

                        CustomTabsIntent customTabsIntent = customTabsBuilder.build();
                        customTabsIntent.launchUrl(activity, Uri.parse(sponsorUrl));
                    } else {
                        Intent sponsorsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(sponsorUrl));
                        context.startActivity(sponsorsIntent);
                    }
                } else {
                    Snackbar.make(view, R.string.invalid_url, Snackbar.LENGTH_LONG).show();
                    Timber.d(sponsorUrl);
                }
            });
        } else if (holder instanceof CategoryViewHolder) {
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) holder;
            categoryViewHolder.sponsorCategory.setText(getItem(position).toString());
        }
>>>>>>> text_align
    }

    @Override
    public long getHeaderId(int position) {
        String level = getItem(position).getLevel();
        return Long.valueOf(level);
    }

<<<<<<< HEAD
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_header, parent, false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder holder, int position) {
        holder.header.setGravity(Gravity.CENTER_HORIZONTAL);

        String sponsorType = getItem(position).getType();
        if (!Utils.isEmpty(sponsorType))
            holder.header.setText(sponsorType.toUpperCase());
=======
    class SponsorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sponsor_image)
        ImageView sponsorImage;

        @BindView(R.id.sponsor_type)
        TextView sponsorType;

        @BindView(R.id.sponsor_name)
        TextView sponsorName;

        SponsorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sponsor_category)
        TextView sponsorCategory;

        CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
>>>>>>> text_align
    }
}
