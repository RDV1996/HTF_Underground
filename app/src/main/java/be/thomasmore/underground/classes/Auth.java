package be.thomasmore.underground.classes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by robyd on 30/11/2017.
 */

public class Auth {
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("ValidUntill")
    private int validUntill;
    @SerializedName("user")
    private User user;

    public Auth(String accessToken, int validUntill, User user) {
        this.accessToken = accessToken;
        this.validUntill = validUntill;
        this.user = user;

    }

    public Auth() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getValidUntill() {
        return validUntill;
    }

    public void setValidUntill(int validUntill) {
        this.validUntill = validUntill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
