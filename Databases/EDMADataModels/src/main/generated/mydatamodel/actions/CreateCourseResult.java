package main.generated.mydatamodel.actions;

import main.generated.valuedomains.mydatamodel.CourseID;
import org.abstractica.edma.runtime.intf.IResult;

/**
 * Access to the result of the method: createCourse
 */
public interface CreateCourseResult extends IResult
{

    /**
     * Returns the output id:CourseID
     * @return  The output id:CourseID
     */
    public CourseID getId();

}
