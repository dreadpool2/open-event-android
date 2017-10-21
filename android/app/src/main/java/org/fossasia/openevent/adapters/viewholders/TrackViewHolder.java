package org.fossasia.openevent.adapters.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
<<<<<<< HEAD
import android.graphics.PorterDuff;
=======
>>>>>>> text_align
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import org.fossasia.openevent.OpenEventApp;
=======
import com.amulyakhare.textdrawable.TextDrawable;

>>>>>>> text_align
import org.fossasia.openevent.R;
import org.fossasia.openevent.activities.TrackSessionsActivity;
import org.fossasia.openevent.data.Track;
import org.fossasia.openevent.utils.ConstantStrings;
import org.fossasia.openevent.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView)
<<<<<<< HEAD
    ImageView trackImageIcon;

    @BindView(R.id.track_title)
    TextView trackTitle;

    @BindView(R.id.no_of_sessions)
    TextView noOfSessions;

    private Track track;
=======
    protected ImageView trackImageIcon;

    @BindView(R.id.track_title)
    protected TextView trackTitle;

    private Track track;
    private TextDrawable.IBuilder drawableBuilder = TextDrawable.builder().round();
>>>>>>> text_align

    public TrackViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);

<<<<<<< HEAD
=======
        Context applicationContext = context.getApplicationContext();

>>>>>>> text_align
        //Attach onClickListener for ViewHolder
        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, TrackSessionsActivity.class);
            intent.putExtra(ConstantStrings.TRACK, track.getName());
            intent.putExtra(ConstantStrings.TRACK_ID, track.getId());
<<<<<<< HEAD
            context.startActivity(intent);
=======
            applicationContext.startActivity(intent);
>>>>>>> text_align
        });
    }

    public void bindTrack(Track track) {
        this.track = track;

        int trackColor = Color.parseColor(track.getColor());
<<<<<<< HEAD
        int sessions = track.getSessions().size();
        String trackName = Utils.checkStringEmpty(track.getName());

        trackTitle.setText(trackName);
        noOfSessions.getBackground().setColorFilter(trackColor, PorterDuff.Mode.SRC_ATOP);
        noOfSessions.setText(OpenEventApp.getAppContext().getResources().getQuantityString(R.plurals.sessions,
                sessions, sessions));

        if(!Utils.isEmpty(trackName)) {
            trackImageIcon.setImageDrawable(OpenEventApp.getTextDrawableBuilder().round().build(String.valueOf(trackName.charAt(0)), trackColor));
=======
        String trackName = Utils.checkStringEmpty(track.getName());

        trackTitle.setText(trackName);
        if(!Utils.isEmpty(trackName)) {
            TextDrawable drawable = drawableBuilder.build(String.valueOf(trackName.charAt(0)), trackColor);
            trackImageIcon.setImageDrawable(drawable);
>>>>>>> text_align
            trackImageIcon.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
