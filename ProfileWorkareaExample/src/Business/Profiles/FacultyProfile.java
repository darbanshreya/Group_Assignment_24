package Business.Profiles;

import Business.Person.Person;
import Model.Faculty;



public class FacultyProfile extends Profile {
    
    private Faculty faculty;
    
    public FacultyProfile(Person person, Faculty faculty) {
        super(person);
        this.faculty = faculty;
    }
    
    public Faculty getFaculty() {
        return faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    @Override
    public String getRole() {
        return "Faculty";
    }
}