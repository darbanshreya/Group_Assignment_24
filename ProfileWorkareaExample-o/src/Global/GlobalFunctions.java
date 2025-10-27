/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Global;

import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.Profile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import java.util.Random;

/**
 *
 * @author pawag
 */
public class GlobalFunctions {

    public static int randomNumber() {
        Random rnd = new Random();
        int result = rnd.nextInt();
        if (result < 0) {
            result = result * (-1)  ;
        }
        return result;
    }
}
