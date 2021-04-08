package main.generated.edmaimpl.models.mydatamodel;

import java.io.IOException;
import main.generated.edmaimpl.models.mydatamodel.actions.EDMA_AssignStudentToCourse;
import main.generated.edmaimpl.models.mydatamodel.actions.EDMA_AssignTeacherToCourse;
import main.generated.edmaimpl.models.mydatamodel.actions.EDMA_CreateCourse;
import main.generated.edmaimpl.models.mydatamodel.actions.EDMA_CreatePerson;
import main.generated.edmaimpl.models.mydatamodel.views.EDMA_GetAllPersons;
import main.generated.edmaimpl.models.mydatamodel.views.EDMA_GetCourseStudent;
import main.generated.edmaimpl.models.mydatamodel.views.EDMA_GetCourseTeacher;
import main.generated.mydatamodel.MyDataModel;
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
import main.usercode.models.mydatamodel.actions.AssignStudentToCourseUserImpl;
import main.usercode.models.mydatamodel.actions.AssignTeacherToCourseUserImpl;
import main.usercode.models.mydatamodel.actions.CreateCourseUserImpl;
import main.usercode.models.mydatamodel.actions.CreatePersonUserImpl;
import main.usercode.models.mydatamodel.views.GetAllPersonsUserImpl;
import main.usercode.models.mydatamodel.views.GetCourseStudentUserImpl;
import main.usercode.models.mydatamodel.views.GetCourseTeacherUserImpl;
import org.abstractica.edma.runtime.intf.IDataModelInstance;

/**
 * 
 */
public class MyDataModelAPIImpl implements MyDataModel
{
    private IDataModelInstance edma_dmi;



    /**
     * Constructor
     * @param edma_dmi  Data model instance runtime interface
     */
    public MyDataModelAPIImpl(IDataModelInstance edma_dmi)
    {
        this.edma_dmi = edma_dmi;
    }

    /**
     * Access to the internal data model instance
     * @return  The internal data model instance
     */
    public IDataModelInstance edma_getDMI()
    {
        return edma_dmi;
    }

    /**
     * Get all Students from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseStudentResult getCourseStudent(CourseID courseID) throws IOException
    {
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        GetCourseStudentUserImpl edma_userMethod = new GetCourseStudentUserImpl(courseID);
        EDMA_GetCourseStudent edma_method = new EDMA_GetCourseStudent(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Get Teacher from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseTeacherResult getCourseTeacher(CourseID courseID) throws IOException
    {
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        GetCourseTeacherUserImpl edma_userMethod = new GetCourseTeacherUserImpl(courseID);
        EDMA_GetCourseTeacher edma_method = new EDMA_GetCourseTeacher(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Get all Persons
     * @return  
     */
    public GetAllPersonsResult getAllPersons() throws IOException
    {
        GetAllPersonsUserImpl edma_userMethod = new GetAllPersonsUserImpl();
        EDMA_GetAllPersons edma_method = new EDMA_GetAllPersons(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Creates a new Person
     * @param firstName  Input parameter firstName
     * @param lastName   Input parameter lastName
     * @param email      Input parameter email
     * @return           
     */
    public CreatePersonResult createPerson(Name firstName, Name lastName, Email email) throws IOException
    {
        if(firstName == null)
        {
            throw new NullPointerException("firstName may not be null");
        }
        if(lastName == null)
        {
            throw new NullPointerException("lastName may not be null");
        }
        if(email == null)
        {
            throw new NullPointerException("email may not be null");
        }
        CreatePersonUserImpl edma_userMethod = new CreatePersonUserImpl(firstName, lastName, email);
        EDMA_CreatePerson edma_method = new EDMA_CreatePerson(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Creates a new Course
     * @param name  Input parameter name
     * @return      
     */
    public CreateCourseResult createCourse(Name name) throws IOException
    {
        if(name == null)
        {
            throw new NullPointerException("name may not be null");
        }
        CreateCourseUserImpl edma_userMethod = new CreateCourseUserImpl(name);
        EDMA_CreateCourse edma_method = new EDMA_CreateCourse(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Assign a Student to a Course
     * @param studentID  Input parameter studentID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignStudentToCourseResult assignStudentToCourse(PersonID studentID, CourseID courseID) throws IOException
    {
        if(studentID == null)
        {
            throw new NullPointerException("studentID may not be null");
        }
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        AssignStudentToCourseUserImpl edma_userMethod = new AssignStudentToCourseUserImpl(studentID, courseID);
        EDMA_AssignStudentToCourse edma_method = new EDMA_AssignStudentToCourse(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }

    /**
     * Assign a Teacher to a Course
     * @param teacherID  Input parameter teacherID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignTeacherToCourseResult assignTeacherToCourse(PersonID teacherID, CourseID courseID) throws IOException
    {
        if(teacherID == null)
        {
            throw new NullPointerException("teacherID may not be null");
        }
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        AssignTeacherToCourseUserImpl edma_userMethod = new AssignTeacherToCourseUserImpl(teacherID, courseID);
        EDMA_AssignTeacherToCourse edma_method = new EDMA_AssignTeacherToCourse(edma_userMethod);
        edma_dmi.execute(edma_method);
        return edma_method.getUserMethod();
    }
}
