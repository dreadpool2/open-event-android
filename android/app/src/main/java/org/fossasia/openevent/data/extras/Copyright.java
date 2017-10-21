package org.fossasia.openevent.data.extras;

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
@Type("event-copyright")
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Copyright extends RealmObject {

    @PrimaryKey
    @Id(IntegerIdHandler.class)
    private int id;
    private String licenceUrl;
    private String holderUrl;
    private String licence;
    private int year;
    private String logoUrl;
    private String holder;
=======
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Copyright extends RealmObject {

    @SerializedName("licence_url")
    @Expose
    private String licenceUrl;

    @SerializedName("holder_url")
    @Expose
    private String holderUrl;

    @Expose
    @PrimaryKey
    private String licence;

    @Expose
    private int year;

    @Expose
    private String logo;

    @Expose
    private String holder;

    public String getLicenceUrl() {
        return licenceUrl;
    }

    public String getHolderUrl() {
        return holderUrl;
    }

    public String getLicence() {
        return licence;
    }

    public Integer getYear() {
        return year;
    }

    public String getLogo() {
        return logo;
    }

    public String getHolder() {
        return holder;
    }

>>>>>>> text_align
}
