package org.fossasia.openevent.data;

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

@Data
@AllArgsConstructor
@Type("microlocation")
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Microlocation extends RealmObject {

    @PrimaryKey
    @Id(IntegerIdHandler.class)
=======

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


/**
 * Created by MananWason on 26-05-2015.
 */
public class Microlocation extends RealmObject {
    @PrimaryKey
>>>>>>> text_align
    private int id;
    private String name;
    private float latitude;
    private float longitude;
    private int floor;
    private String room;

    public Microlocation() {}
<<<<<<< HEAD
=======

    public Microlocation(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Microlocation(int id, String name, float latitude,
                         float longitude, int floor) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.floor = floor;

    }
>>>>>>> text_align

    public Microlocation(int id, String name) {
        this.id = id;
        this.name = name;
    }
<<<<<<< HEAD
=======

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

>>>>>>> text_align
}
