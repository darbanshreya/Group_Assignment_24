/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import java.util.Objects;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    Person person;
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentProfile other = (StudentProfile) obj;
        return Objects.equals(this.person, other.person);
    }

    public StudentProfile(Person p) {
        super(p);
        System.out.println("value of person" + p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return  this.getPerson().getPersonId().equals(id);
    }

}
