package main.generated.mydatamodel.views;

import main.generated.valuedomains.mydatamodel.Person;
import org.abstractica.edma.runtime.intf.IResult;

/**
 * Access to the result of the method: getCourseTeacher
 */
public interface GetCourseTeacherResult extends IResult
{

    /**
     * Returns the output teacher:Person
     * @return  The output teacher:Person
     */
    public Person getTeacher();

}
