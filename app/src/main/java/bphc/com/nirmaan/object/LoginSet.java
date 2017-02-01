package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tejeshwar on 1/2/17.
 */

public class LoginSet {

    @SerializedName("success")
    @Expose
    private long success;
    @SerializedName("privilege")
    @Expose
    private long privilege;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginSet() {
    }

    /**
     *
     * @param privilege
     * @param success
     */
    public LoginSet(long success, long privilege) {
        super();
        this.success = success;
        this.privilege = privilege;
    }

    public long getSuccess() {
        return success;
    }

    public void setSuccess(long success) {
        this.success = success;
    }

    public long getPrivilege() {
        return privilege;
    }

    public void setPrivilege(long privilege) {
        this.privilege = privilege;
    }

}
