/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import Departments.Department;
import Departments.DepartmentDictonary;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

        
        Department computer = new Department("COMPUTER");
        Department infoSys = new Department("INFORMATION SYSTEM");
        Department compEng = new Department("COMPUTER Engineering");
        
      DepartmentDictonary departmentDictonary =  business.getDepartmentDictonary();
      departmentDictonary.addDepartment(computer);
      departmentDictonary.addDepartment(infoSys);
      departmentDictonary.addDepartment(compEng);
// Create Persons
      PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person person001 = persondirectory.newPerson("809809","John Smith","FDADS@gmail.xsm");
        Person person003 = persondirectory.newPerson("26372","Adam Rollen","sienv@hxmel.com");

// Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        studentprofile0.setDepartment(computer);
        System.out.println("check it out first" + studentprofile0.getPerson());


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); /// order products for one of the customers and performed by a sales person

        return business;

    }

}
