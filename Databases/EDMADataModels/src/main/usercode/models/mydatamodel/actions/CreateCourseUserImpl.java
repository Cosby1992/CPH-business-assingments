package main.usercode.models.mydatamodel.actions;

import main.generated.mydatamodel.MyDataModelUpdater;
import main.generated.mydatamodel.actions.CreateCourseResult;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.mydatamodel.CourseID;
import org.abstractica.edma.runtime.implementations.common.Result;
import org.abstractica.edma.runtime.intf.exceptions.UniqueException;

/**
 * 
 */
public class CreateCourseUserImpl extends Result implements CreateCourseResult
{
    private static final int OK = 0;
    private static final int NAME_ALREADY_EXISTS = 1;
    private final Name in_name;
    private CourseID out_id;



    /**
     * Constructor
     * @param in_name  Input parameter 1
     */
    public CreateCourseUserImpl(Name in_name)
    {
        this.in_name = in_name;
        out_id = null;
    }

    /**
     * Execution of the action
     * @param upd  Update interface
     * @return     Return 0 to commit or one of the error codes to roll back
     */
    public int execute(MyDataModelUpdater upd)
    {
        // Implementation of createCourse
        // Return one of the following error codes:
        // OK
        // NAME_ALREADY_EXISTS
        
        // If an error needs extra explanation, use: setErrorDescription("Extra info");
        
        // WARNING : Any code outside the following begin and end tags
        // will be lost when re-generation occurs.
        
        // EDMA_non-generated_code_begin

        // CUSTOM CODE HERE!!
        try {
            CourseViewer newCourse = upd.newCourse().name(in_name);
            out_id = newCourse.getID();
            return OK;
        } catch (UniqueException e) {
            return NAME_ALREADY_EXISTS;
        }
        
        // EDMA_non-generated_code_end
    }

    /**
     * Returns the output id:CourseID
     * @return  The output id:CourseID
     */
    public CourseID getId()
    {
        if(errorCode() != 0) return null;
        return out_id;
    }
}
