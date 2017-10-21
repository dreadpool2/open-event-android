package org.fossasia.openevent.data.extras;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Type("social-link")
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class SocialLink extends RealmObject {

    @PrimaryKey
    @Id(IntegerIdHandler.class)
    private int id;
    private String name;
    private String link;
=======
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SocialLink extends RealmObject {

    @SerializedName("link")
    private String link;
    @PrimaryKey
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public SocialLink() {}

    /**
     * @param id
     * @param name
     * @param link
     */
    public SocialLink(String link, String id, String name) {
        super();
        this.link = link;
        this.id = id;
        this.name = name;
    }

    @SerializedName("link")
    public String getLink() {
        return link;
    }

    @SerializedName("link")
    public void setLink(String link) {
        this.link = link;
    }

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

>>>>>>> text_align
}
