package org.fossasia.openevent.data;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Type("sponsor")
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Sponsor extends RealmObject {

    @PrimaryKey
    @Id(IntegerIdHandler.class)
    private int id;
    private String name;
    private String description;
    private String level;
    private String url;
    private String type;
    private String logoUrl;
=======
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Sponsor extends RealmObject {

    @Expose
    @PrimaryKey
    private Integer id;

    @Expose
    private String description;

    @Expose
    private String level;

    @Expose
    private String url;

    @SerializedName("sponsor_type")
    @Expose
    private String sponsorType;

    @Expose
    private String logo;

    @Expose
    private String name;

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }

    public String getUrl() {
        return url;
    }

    public String getSponsorType() {
        return sponsorType;
    }

    public String getLogo() {
        return logo;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

>>>>>>> text_align
}