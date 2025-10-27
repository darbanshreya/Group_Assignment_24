/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;
import Departments.Department;

/**
 *
 * @author kal bugrara
 */
public abstract class Profile {
    Person person;
    Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
     public Profile(Person p){
         this.person = new Person(p.getPersonId(), p.getName(), p.getEmailId());
    }
    
     public abstract String getRole();
    
    public Person getPerson(){
        return person;
    }
     

        public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

}
