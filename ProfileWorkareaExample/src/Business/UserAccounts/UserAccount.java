package Business.UserAccounts;

import Business.Profiles.Profile;

/**
 * Represents an account that allows login for Admin, Faculty, and Student users.
 * No separate Role class — the Profile type determines access.
 * Author: Shreya Darban
 */
public class UserAccount {

    private Profile profile;
    private String username;
    private String password;

    public UserAccount(Profile profile, String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    public String getUserLoginName() {
        return username;
    }

    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

    public boolean isValidUser(String un, String pw) {
        return username.equalsIgnoreCase(un) && password.equals(pw);
    }

    public String getRole() {
        // ✅ Delegate to profile (Student, Faculty, Employee)
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return getUserLoginName();
    }
}
