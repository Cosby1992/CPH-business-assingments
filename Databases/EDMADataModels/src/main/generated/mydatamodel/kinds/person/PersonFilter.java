package main.generated.mydatamodel.kinds.person;


/**
 * Filter interface for the Person kind.
 */
public interface PersonFilter
{

    /**
     * Returns <tt>true</tt> if the entity is accepted by the filter.
     * @param person  The entity to be tested by the filter.
     * @return        <tt>true</tt> if the entity is accepted by the filter.
     */
    public boolean accept(PersonViewer person);

}
