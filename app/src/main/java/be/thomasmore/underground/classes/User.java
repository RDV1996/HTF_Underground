package be.thomasmore.underground.classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by robyd on 30/11/2017.
 */

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("family")
    private  String family;

    public User(String id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


}
