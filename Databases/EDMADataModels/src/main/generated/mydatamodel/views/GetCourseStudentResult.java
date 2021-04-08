package main.generated.mydatamodel.views;

import main.generated.valuedomains.mydatamodel.PersonList;
import org.abstractica.edma.runtime.intf.IResult;

/**
 * Access to the result of the method: getCourseStudent
 */
public interface GetCourseStudentResult extends IResult
{

    /**
     * Returns the output studentList:PersonList
     * @return  The output studentList:PersonList
     */
    public PersonList getStudentList();

}
