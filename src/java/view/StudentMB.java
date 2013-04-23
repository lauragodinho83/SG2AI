/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Student;

/**
 *
 * @author daniel
 */
@Named(value = "studentMB")
@RequestScoped
public class StudentMB {
    
    @EJB
    private StudentEJB studentEJB;
    
    private Student student;
    
    /**
     * Creates a new instance of StudentMB
     */
    public StudentMB() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void save( Student student ) {
        studentEJB.save( student );
    }
    
    public List<Student> getAll() {
        return studentEJB.getAll();
    }
}
