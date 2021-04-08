package main.generated.mydatamodel;

import main.generated.mydatamodel.kinds.course.CourseKind;
import main.generated.mydatamodel.kinds.person.PersonKind;

/**
 * This is the viewing interface for the MyDataModel data model.
 */
public interface MyDataModelViewer
{

    /**
     * Returns the interface to the kind Person
     * @return  The interface to the kind Person
     */
    public PersonKind getPersonKind();

    /**
     * Returns the interface to the kind Course
     * @return  The interface to the kind Course
     */
    public CourseKind getCourseKind();

}
