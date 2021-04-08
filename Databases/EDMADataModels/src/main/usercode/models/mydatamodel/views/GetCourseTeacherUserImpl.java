package main.usercode.models.mydatamodel.views;

import main.generated.mydatamodel.MyDataModelViewer;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.mydatamodel.kinds.person.PersonViewer;
import main.generated.mydatamodel.views.GetCourseTeacherResult;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.Person;
import main.generated.valuedomains.mydatamodel.PersonID;
import org.abstractica.edma.runtime.implementations.common.Result;

/**
 * 
 */
public class GetCourseTeacherUserImpl extends Result implements GetCourseTeacherResult
{
    private static final int OK = 0;
    private static final int COURSE_ID_DOES_NOT_EXIST = 1;
    private final CourseID in_courseID;
    private Person out_teacher;



    /**
     * Constructor
     * @param in_courseID  Input parameter 1
     */
    public GetCourseTeacherUserImpl(CourseID in_courseID)
    {
        this.in_courseID = in_courseID;
        out_teacher = null;
    }

    /**
     * Execution of the view
     * @param view  View interface
     * @return      Return 0 if succesful or one of the error codes if not
     */
    public int execute(MyDataModelViewer view)
    {
        // Implementation of getCourseTeacher
        // Return one of the following error codes:
        // OK
        // COURSE_ID_DOES_NOT_EXIST
        
        // If an error needs extra explanation, use: setErrorDescription("Extra info");
        
        // WARNING : Any code outside the following begin and end tags
        // will be lost when re-generation occurs.
        
        // EDMA_non-generated_code_begin
        
        CourseViewer courseViewer = view.getCourseKind().getFromID(in_courseID);

        if(courseViewer == null){
            return COURSE_ID_DOES_NOT_EXIST;
        }

        PersonViewer teacher = courseViewer.getTeacher();

        if(teacher != null) {

            out_teacher = teacher.snapshot();

        }

        return OK;

        

        
        // EDMA_non-generated_code_end
    }

    /**
     * Returns the output teacher:Person
     * @return  The output teacher:Person
     */
    public Person getTeacher()
    {
        if(errorCode() != 0) return null;
        return out_teacher;
    }
}
