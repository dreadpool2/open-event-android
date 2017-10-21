package org.fossasia.openevent.adapters.viewholders;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
=======
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.graphics.drawable.VectorDrawableCompat;
>>>>>>> text_align
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
=======
>>>>>>> text_align
import com.squareup.picasso.RequestCreator;

import org.fossasia.openevent.OpenEventApp;
import org.fossasia.openevent.R;
import org.fossasia.openevent.activities.SpeakerDetailsActivity;
import org.fossasia.openevent.data.Speaker;
import org.fossasia.openevent.utils.CircleTransform;
import org.fossasia.openevent.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
<<<<<<< HEAD
import timber.log.Timber;
=======
>>>>>>> text_align

public class SpeakerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.speakers_list_image)
    protected ImageView speakerImage;

    @BindView(R.id.speakers_list_name)
    protected TextView speakerName;

    @BindView(R.id.speakers_list_designation)
    protected TextView speakerDesignation;

    @BindView(R.id.speakers_list_country)
    protected TextView speakerCountry;

    private Speaker speaker;
    private Context context;

    private boolean isImageCircle = true;

    public SpeakerViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);

<<<<<<< HEAD
        this.context = context;
=======
        this.context = context.getApplicationContext();
>>>>>>> text_align

        //Attach onClickListener for ViewHolder
        itemView.setOnClickListener(view -> {
            String speakerName = speaker.getName();
            Intent intent = new Intent(this.context, SpeakerDetailsActivity.class);
            intent.putExtra(Speaker.SPEAKER, speakerName);
<<<<<<< HEAD

            try{
                if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) this.context, speakerImage, speakerImage.getTransitionName()).toBundle();
                    this.context.startActivity(intent, bundle);
                } else{
                    this.context.startActivity(intent);
                }
            }
            catch(Exception e){
                Timber.d("Speaker's transition doesnt occur");
            }

=======
            this.context.startActivity(intent);
>>>>>>> text_align
        });
    }

    public void bindSpeaker(Speaker speaker) {
        this.speaker = speaker;

<<<<<<< HEAD
        String thumbnail = Utils.parseImageUri(this.speaker.getThumbnailImageUrl());
        String name = Utils.checkStringEmpty(speaker.getName());

        if (thumbnail == null)
            thumbnail = Utils.parseImageUri(this.speaker.getPhotoUrl());

        RequestCreator requestCreator = OpenEventApp.picassoWithCache
                .load(thumbnail);

        TextDrawable drawable;
        if (isImageCircle) {
            requestCreator.transform(new CircleTransform());
            drawable = OpenEventApp.getTextDrawableBuilder().round().build(Utils.getNameLetters(name), ColorGenerator.MATERIAL.getColor(name));
        } else {
            drawable = OpenEventApp.getTextDrawableBuilder().buildRect(Utils.getNameLetters(name), ColorGenerator.MATERIAL.getColor(name));
        }

        requestCreator
                .placeholder(drawable)
                .error(drawable)
                .into(speakerImage);

        setStringField(speakerName, name);
=======
        String thumbnail = Utils.parseImageUri(this.speaker.getThumbnail());

        if (thumbnail == null)
            thumbnail = Utils.parseImageUri(this.speaker.getPhoto());

        Drawable placeholder = VectorDrawableCompat.create(context.getResources(), R.drawable.ic_account_circle_grey_24dp, null);

        if(thumbnail != null) {
            RequestCreator requestCreator = OpenEventApp.picassoWithCache
                    .load(Uri.parse(thumbnail))
                    .placeholder(placeholder);

            if (isImageCircle) {
                requestCreator.transform(new CircleTransform());
            }

            requestCreator.into(speakerImage);
        } else {
           speakerImage.setImageDrawable(placeholder);
        }

        setStringField(speakerName, speaker.getName());
>>>>>>> text_align
        setStringField(speakerDesignation, String.format("%s %s", speaker.getPosition(), speaker.getOrganisation()));
        setStringField(speakerCountry, speaker.getCountry());
    }

    private void setStringField(TextView textView, String field) {
        if (textView == null)
            return;

        if (!TextUtils.isEmpty(field.trim())) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(field);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    public void setIsImageCircle(boolean imageCircle) {
        isImageCircle = imageCircle;
    }
}
