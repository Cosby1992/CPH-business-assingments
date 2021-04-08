package main.generated.mydatamodel.kinds.course;


/**
 * Filter interface for the Course kind.
 */
public interface CourseFilter
{

    /**
     * Returns <tt>true</tt> if the entity is accepted by the filter.
     * @param course  The entity to be tested by the filter.
     * @return        <tt>true</tt> if the entity is accepted by the filter.
     */
    public boolean accept(CourseViewer course);

}
