package main.generated.mydatamodel;

import java.io.IOException;
import main.generated.mydatamodel.actions.AssignStudentToCourseResult;
import main.generated.mydatamodel.actions.AssignTeacherToCourseResult;
import main.generated.mydatamodel.actions.CreateCourseResult;
import main.generated.mydatamodel.actions.CreatePersonResult;
import main.generated.mydatamodel.views.GetAllPersonsResult;
import main.generated.mydatamodel.views.GetCourseStudentResult;
import main.generated.mydatamodel.views.GetCourseTeacherResult;
import main.generated.valuedomains.Email;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.PersonID;

/**
 * The external interface for the model: MyDataModel
 */
public interface MyDataModel
{

    /**
     * Get all Students from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseStudentResult getCourseStudent(CourseID courseID) throws IOException;

    /**
     * Get Teacher from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseTeacherResult getCourseTeacher(CourseID courseID) throws IOException;

    /**
     * Get all Persons
     * @return  
     */
    public GetAllPersonsResult getAllPersons() throws IOException;

    /**
     * Creates a new Person
     * @param firstName  Input parameter firstName
     * @param lastName   Input parameter lastName
     * @param email      Input parameter email
     * @return           
     */
    public CreatePersonResult createPerson(Name firstName, Name lastName, Email email) throws IOException;

    /**
     * Creates a new Course
     * @param name  Input parameter name
     * @return      
     */
    public CreateCourseResult createCourse(Name name) throws IOException;

    /**
     * Assign a Student to a Course
     * @param studentID  Input parameter studentID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignStudentToCourseResult assignStudentToCourse(PersonID studentID, CourseID courseID) throws IOException;

    /**
     * Assign a Teacher to a Course
     * @param teacherID  Input parameter teacherID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignTeacherToCourseResult assignTeacherToCourse(PersonID teacherID, CourseID courseID) throws IOException;

}
