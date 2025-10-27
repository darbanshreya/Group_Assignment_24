/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    ArrayList<Person> personlist;

    public PersonDirectory() {

        personlist = new ArrayList();

    }

    public Person newPerson(String id) {

        Person p = new Person(id);
        personlist.add(p);
        return p;
    }

    public Person newPerson(String id, String name, String email) {

        Person p = new Person(id, name, email);

        personlist.add(p);
        return p;
    }

    public boolean isNotDuplicatePerson(Person p) {

       return (findPersonByEmailId(p.getEmailId())==null) && 
               (findPerson( p.getPersonId())==null);
    }

    public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatchByUniversityId(id)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }

    public Person findPersonByEmailId(String emailId) {

        for (Person p : personlist) {

            if (p.isMatchByEmailId(emailId)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }

}
