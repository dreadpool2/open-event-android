package org.fossasia.openevent.data;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
=======
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
>>>>>>> text_align

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
<<<<<<< HEAD
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Type("track")
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Track extends RealmObject {

    @PrimaryKey
    @Id(IntegerIdHandler.class)
    private int id;
    @Index
    private String name;
    private String description;
    private String color;
    private String fontColor;
    @Relationship("sessions")
    private RealmList<Session> sessions;
=======

public class Track extends RealmObject {

    @Expose
    private RealmList<Session> sessions;

    @Expose
    private String color;

    @SerializedName("track_image_url")
    @Expose
    private String trackImageUrl;

    @Expose
    @PrimaryKey
    private int id;

    @Expose
    @Index
    private String name;

    public RealmList<Session> getSessions() {
        return sessions;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTrackImageUrl() {
        return trackImageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setSessions(RealmList<Session> sessions) {
        this.sessions = sessions;
    }
>>>>>>> text_align
}