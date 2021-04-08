package main.usercode.models.mydatamodel.views;

import main.generated.mydatamodel.MyDataModelViewer;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.mydatamodel.views.GetCourseStudentResult;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.PersonList;
import org.abstractica.edma.runtime.implementations.common.Result;

/**
 * 
 */
public class GetCourseStudentUserImpl extends Result implements GetCourseStudentResult
{
    private static final int OK = 0;
    private static final int COURSE_ID_DOES_NOT_EXIST = 1;
    private final CourseID in_courseID;
    private PersonList out_studentList;



    /**
     * Constructor
     * @param in_courseID  Input parameter 1
     */
    public GetCourseStudentUserImpl(CourseID in_courseID)
    {
        this.in_courseID = in_courseID;
        out_studentList = null;
    }

    /**
     * Execution of the view
     * @param view  View interface
     * @return      Return 0 if succesful or one of the error codes if not
     */
    public int execute(MyDataModelViewer view)
    {
        // Implementation of getCourseStudent
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

        out_studentList = courseViewer.getStudentSet().snapshot();

        return OK;
        
        // EDMA_non-generated_code_end
    }

    /**
     * Returns the output studentList:PersonList
     * @return  The output studentList:PersonList
     */
    public PersonList getStudentList()
    {
        if(errorCode() != 0) return null;
        return out_studentList;
    }
}
