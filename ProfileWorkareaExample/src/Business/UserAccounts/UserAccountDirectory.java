package Business.UserAccounts;

import Business.Profiles.Profile;
import java.util.ArrayList;

/**
 * Stores and authenticates all user accounts in the system.
 * Role resolution is based on the Profile type.
 * Author: Shreya Darban
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public UserAccount newUserAccount(Profile profile, String username, String password) {
        UserAccount ua = new UserAccount(profile, username, password);
        userAccountList.add(ua);
        return ua;
    }

    public UserAccount findUserAccount(String id) {
        for (UserAccount ua : userAccountList) {
            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount AuthenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.isValidUser(username, password)) {
                return ua;
            }
        }
        return null;
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
}
