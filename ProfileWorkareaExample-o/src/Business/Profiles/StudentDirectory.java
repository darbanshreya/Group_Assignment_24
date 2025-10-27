/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {
    
    ArrayList<StudentProfile> studentlist;
    
    public StudentDirectory() {
        
        studentlist = new ArrayList();
        
    }
    
    public ArrayList<StudentProfile> getStudentlist() {
        return studentlist;
    }
    
    public void setStudentlist(ArrayList<StudentProfile> studentlist) {
        this.studentlist = studentlist;
    }
    
    public StudentProfile newStudentProfile(Person p) {
        
        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }
    
    public StudentProfile findStudent(String id) {
        
        for (StudentProfile sp : studentlist) {
            
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }
    
    public StudentProfile findStudentByIdOrEmailIdOrName(String id) {
        
        for (StudentProfile sp : studentlist) {
            
            if (sp.isMatch(id) || sp.getPerson().isMatchByEmailId(id) 
                    ||sp.getPerson().getName().equalsIgnoreCase(id) ) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }
    
    public void deleteStudent(String id) {
        StudentProfile deleteProfile = null;
        
        for (StudentProfile sp : studentlist) {
            
            System.out.println("lets see: " + sp.getPerson());
            
            if (sp.isMatch(id)) {
                deleteProfile = sp;
            }
        }
        studentlist.remove(deleteProfile);
    }
}
