package main.generated.mydatamodel.kinds.course;

import main.generated.mydatamodel.kinds.course.CourseSet;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.mydatamodel.CourseID;

/**
 * Interface for the kind: Course
 */
public interface CourseKind
{

    /**
     * Get an entity from its id.
     * @param id  The id of the entity to get
     * @return    A viewer on the entity with the given ID or null if none
     *            exists.
     */
    public CourseViewer getFromID(CourseID id);

    /**
     * Returns an empty set of Course entities.
     * @return  An empty set of Course entities.
     */
    public CourseSet getEmptyCourseSet();

    /**
     * Returns the set of all Course entities.
     * @return  The set of all Course entities.
     */
    public CourseSet getAll();

    /**
     * Returns the unique course from the unique-index on name or <tt>null</tt>
     * if there is no course with the given name.
     * @param name  Value for name
     * @return      The unique course from the unique-index on name or
     *              <tt>null</tt> if there is no course with the given name.
     */
    public CourseViewer getFromName(Name name);

}
