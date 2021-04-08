package main.generated.edmaimpl.models.mydatamodel;

import java.util.ArrayList;
import java.util.Iterator;
import main.generated.edmaimpl.models.mydatamodel.PersonSetImpl;
import main.generated.mydatamodel.kinds.course.CourseFilter;
import main.generated.mydatamodel.kinds.course.CourseSet;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.mydatamodel.kinds.person.PersonSet;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.CourseList;
import main.generated.valuedomains.mydatamodel.impl.CourseListImpl;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IEntity;

/**
 * 
 */
public class CourseSetImpl implements CourseSet
{
    private int setID;
    private IDataModelView edma_dmview;



    /**
     * Constructor
     * @param setID        The id of this set
     * @param edma_dmview  The internal runtime interface
     */
    public CourseSetImpl(int setID, IDataModelView edma_dmview)
    {
        this.setID = setID;
        this.edma_dmview = edma_dmview;
    }

    /**
     * Get the size of this set.
     * @return  The size of this set.
     */
    public int size()
    {
        return edma_dmview.setGetSize(setID);
    }

    /**
     * Returns <tt>true</tt> if this set contains the entity with the given id.
     * @param id  The id of the entity to test containment of
     * @return    <tt>true</tt> if this set contains the entity with the given
     *            id
     */
    public boolean contains(CourseID id)
    {
        return edma_dmview.setContains(setID, id.value());
    }

    /**
     * Returns <tt>true</tt> if this set contains the given entity.
     * @param entity  The entity to test containment of
     * @return        <tt>true</tt> if this set contains the given entity
     */
    public boolean contains(CourseViewer entity)
    {
        return edma_dmview.setContains(setID, entity.getID().value());
    }

    /**
     * Returns <tt>true</tt> if this set contains every entity in the given set.
     * @param courseSet  The CourseSet to test containment of.
     * @return           <tt>true</tt> if this set contains every entity in the
     *                   given set
     */
    public boolean containsAll(CourseSet courseSet)
    {
        return edma_dmview.setContainsAll(setID, ((CourseSetImpl) courseSet).setID);
    }

    /**
     * Creates a copy of this CourseSet at this instance in time and returns it
     * as a list of values
     * @return  A copy of this CourseSet as a list of values from the value
     *          domain CourseList
     */
    public CourseList snapshot()
    {
        int size = edma_dmview.setGetSize(setID);
        Iterator<IEntity> it = edma_dmview.setGetIterator(setID);
        Object[] res = new Object[size];
        int i = 0;
        while(it.hasNext())
        {
            Object[] entObj = new Object[2];
            Object[] value = it.next().getValue();
            entObj[0] = value[0];
            entObj[1] = value[1];
            res[i++] = entObj;
        }
        return new CourseListImpl(res);
    }

    /**
     * Returns the union between this set and the given set
     * @param courseSet  The CourseSet to create the union with.
     * @return           The union between this CourseSet and the provided
     *                   CourseSet.
     */
    public CourseSet union(CourseSet courseSet)
    {
        int otherSetID = ((CourseSetImpl) courseSet).setID;
        int newSetID = edma_dmview.setUnion(setID, otherSetID);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns the intersection between this set and the given set
     * @param courseSet  The CourseSet to create the intersection with.
     * @return           The intersection between this CourseSet and the
     *                   provided CourseSet.
     */
    public CourseSet intersect(CourseSet courseSet)
    {
        int otherSetID = ((CourseSetImpl) courseSet).setID;
        int newSetID = edma_dmview.setIntersect(setID, otherSetID);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns the subtraction of the given set from this set. The result set
     * will contain every element from this set, that are not contained in the
     * given set.
     * @param courseSet  The CourseSet to subtract from this set.
     * @return           The subtraction of the provided CourseSet from this
     *                   CourseSet. The result will contain every element from
     *                   this set, that are not contained in the provided set.
     */
    public CourseSet subtract(CourseSet courseSet)
    {
        int otherSetID = ((CourseSetImpl) courseSet).setID;
        int newSetID = edma_dmview.setSubtract(setID, otherSetID);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with all the entities from this set that are accepted
     * by the filter.
     * @param filter  The filter
     * @return        A new set with all the entities from this set that are
     *                accepted by the filter.
     */
    public CourseSet filter(CourseFilter filter)
    {
        ArrayList<Long> res = new ArrayList<Long>();
        for(CourseViewer course : this)
        {
            if(filter.accept(course))
            {
                res.add(course.getID().value());
            }
        }
        int newSetID = edma_dmview.setFromIDs(1, res);
        return new main.generated.edmaimpl.models.mydatamodel.CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but ordered by ID.
     * @return  A new set with the same entries but ordered by ID.
     */
    public CourseSet orderByID()
    {
        int newSetID = edma_dmview.setOrderByID(setID, false);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but ordered by ID.
     * @return  A new set with the same entries but ordered by ID.
     */
    public CourseSet orderByIDDesc()
    {
        int newSetID = edma_dmview.setOrderByID(setID, true);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but sub ordered by ID.
     * @return  A new set with the same entries but sub ordered by ID.
     */
    public CourseSet subOrderByID()
    {
        int newSetID = edma_dmview.setSubOrderByID(setID, false);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but sub ordered by ID.
     * @return  A new set with the same entries but sub ordered by ID.
     */
    public CourseSet subOrderByIDDesc()
    {
        int newSetID = edma_dmview.setSubOrderByID(setID, true);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but ordered by name
     * @return  A new set with the same entries but ordered by name
     */
    public CourseSet orderByName()
    {
        int newSetID = edma_dmview.setOrderBy(setID, 0, false);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries but ordered by name
     * @return  A new set with the same entries but ordered by name
     */
    public CourseSet orderByNameDesc()
    {
        int newSetID = edma_dmview.setOrderBy(setID, 0, true);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries that is sub ordered by name
     * @return  A new set with the same entries that is sub ordered by name
     */
    public CourseSet subOrderByName()
    {
        int newSetID = edma_dmview.setSubOrderBy(setID, 0, false);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns a new set with the same entries that is sub ordered by name
     * @return  A new set with the same entries that is sub ordered by name
     */
    public CourseSet subOrderByNameDesc()
    {
        int newSetID = edma_dmview.setSubOrderBy(setID, 0, true);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * This methods follows the relation CourseEnrollment
     * @return  The result of following the relation CourseEnrollment
     */
    public PersonSet asCourseSetGetStudentSet()
    {
        int newSetID = edma_dmview.relationAsASetGetBSet(0, setID);
        return new PersonSetImpl(newSetID, edma_dmview);
    }

    /**
     * This methods follows the relation TeacherAssignment
     * @return  The result of following the relation TeacherAssignment
     */
    public PersonSet asCourseSetGetTeacherSet()
    {
        int newSetID = edma_dmview.relationAsASetGetBSet(1, setID);
        return new PersonSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns an iterator for this set
     * @return  An iterator for this set
     */
    public Iterator<CourseViewer> iterator()
    {
        return new CourseIterator(edma_dmview.setGetIterator(setID));
    }


    /**
     * Inner class that defines the iterator
     */
    public class CourseIterator implements Iterator<CourseViewer>
    {
        private Iterator<IEntity> edma_iterator;



        /**
         * Constructor
         * @param edma_iterator  The internal iterator
         */
        public CourseIterator(Iterator<IEntity> edma_iterator)
        {
            this.edma_iterator = edma_iterator;
        }

        /**
         * Returns <tt>true</tt> if this iterator has more elements
         * @return  <tt>true</tt> if this iterator has more elements
         */
        public boolean hasNext()
        {
            return edma_iterator.hasNext();
        }

        /**
         * Returns the next element from this iterator
         * @return  the next element from this iterator
         */
        public CourseViewer next()
        {
            IEntity entity = edma_iterator.next();
            return new CourseVUImpl(entity, edma_dmview);
        }

        /**
         * Not supported as this is a read-only iterator
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

}
