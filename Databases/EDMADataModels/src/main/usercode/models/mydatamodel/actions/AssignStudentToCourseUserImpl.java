package main.usercode.models.mydatamodel.actions;

import main.generated.mydatamodel.MyDataModelUpdater;
import main.generated.mydatamodel.actions.AssignStudentToCourseResult;
import main.generated.mydatamodel.kinds.course.CourseUpdater;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.mydatamodel.kinds.person.PersonUpdater;
import main.generated.mydatamodel.kinds.person.PersonViewer;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.PersonID;
import org.abstractica.edma.runtime.implementations.common.Result;

/**
 * 
 */
public class AssignStudentToCourseUserImpl extends Result implements AssignStudentToCourseResult
{
    private static final int OK = 0;
    private static final int STUDENT_ID_DOES_NOT_EXIST = 1;
    private static final int COURSE_ID_DOES_NOT_EXIST = 2;
    private static final int STUDENT_IS_ALREADY_ENROLLED_IN_COURSE = 3;
    private final PersonID in_studentID;
    private final CourseID in_courseID;



    /**
     * Constructor
     * @param in_studentID  Input parameter 1
     * @param in_courseID   Input parameter 2
     */
    public AssignStudentToCourseUserImpl(PersonID in_studentID, CourseID in_courseID)
    {
        this.in_studentID = in_studentID;
        this.in_courseID = in_courseID;
    }

    /**
     * Execution of the action
     * @param upd  Update interface
     * @return     Return 0 to commit or one of the error codes to roll back
     */
    public int execute(MyDataModelUpdater upd)
    {
        // Implementation of assignStudentToCourse
        // Return one of the following error codes:
        // OK
        // STUDENT_ID_DOES_NOT_EXIST
        // COURSE_ID_DOES_NOT_EXIST
        // STUDENT_IS_ALREADY_ENROLLED_IN_COURSE
        
        // If an error needs extra explanation, use: setErrorDescription("Extra info");
        
        // WARNING : Any code outside the following begin and end tags
        // will be lost when re-generation occurs.
        
        // EDMA_non-generated_code_begin
        PersonViewer student = upd.getPersonKind().getFromID(in_studentID);
        if(student == null){
            return STUDENT_ID_DOES_NOT_EXIST;
        }

        CourseViewer course = upd.getCourseKind().getFromID(in_courseID);
        if(course == null){
            return COURSE_ID_DOES_NOT_EXIST;
        }

        CourseUpdater courseUpdater = upd.update(course);
        if(courseUpdater.addStudent(student)){
            return OK;
        } else {
            return STUDENT_IS_ALREADY_ENROLLED_IN_COURSE;
        }
        
        // EDMA_non-generated_code_end
    }
}
