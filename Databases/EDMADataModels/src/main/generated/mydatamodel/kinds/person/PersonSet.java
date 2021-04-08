package main.generated.mydatamodel.kinds.person;

import java.util.Iterator;
import main.generated.mydatamodel.kinds.course.CourseSet;
import main.generated.mydatamodel.kinds.person.PersonViewer;
import main.generated.valuedomains.mydatamodel.PersonID;
import main.generated.valuedomains.mydatamodel.PersonList;

/**
 * This is the viewing interface for PersonSet
 */
public interface PersonSet extends Iterable<PersonViewer>
{

    /**
     * Get the size of this set.
     * @return  The size of this set.
     */
    public int size();

    /**
     * Returns <tt>true</tt> if this set contains the entity with the given id.
     * @param id  The id of the entity to test containment of
     * @return    <tt>true</tt> if this set contains the entity with the given
     *            id
     */
    public boolean contains(PersonID id);

    /**
     * Returns <tt>true</tt> if this set contains the given entity.
     * @param entity  The entity to test containment of
     * @return        <tt>true</tt> if this set contains the given entity
     */
    public boolean contains(PersonViewer entity);

    /**
     * Returns <tt>true</tt> if this set contains every entity in the given set.
     * @param personSet  The PersonSet to test containment of.
     * @return           <tt>true</tt> if this set contains every entity in the
     *                   given set
     */
    public boolean containsAll(PersonSet personSet);

    /**
     * Creates a copy of this PersonSet at this instance in time and returns it
     * as a list of values
     * @return  A copy of this PersonSet as a list of values from the value
     *          domain PersonList
     */
    public PersonList snapshot();

    /**
     * Returns the union between this set and the given set
     * @param personSet  The PersonSet to create the union with.
     * @return           The union between this PersonSet and the provided
     *                   PersonSet.
     */
    public PersonSet union(PersonSet personSet);

    /**
     * Returns the intersection between this set and the given set
     * @param personSet  The PersonSet to create the intersection with.
     * @return           The intersection between this PersonSet and the
     *                   provided PersonSet.
     */
    public PersonSet intersect(PersonSet personSet);

    /**
     * Returns the subtraction of the given set from this set. The result set
     * will contain every element from this set, that are not contained in the
     * given set.
     * @param personSet  The PersonSet to subtract from this set.
     * @return           The subtraction of the provided PersonSet from this
     *                   PersonSet. The result will contain every element from
     *                   this set, that are not contained in the provided set.
     */
    public PersonSet subtract(PersonSet personSet);

    /**
     * Returns a new set with all the entities from this set that are accepted
     * by the filter.
     * @param filter  The filter
     * @return        A new set with all the entities from this set that are
     *                accepted by the filter.
     */
    public PersonSet filter(PersonFilter filter);

    /**
     * Returns a new set with the same entries but ordered by ID.
     * @return  A new set with the same entries but ordered by ID.
     */
    public PersonSet orderByID();

    /**
     * Returns a new set with the same entries but ordered by ID.
     * @return  A new set with the same entries but ordered by ID.
     */
    public PersonSet orderByIDDesc();

    /**
     * Returns a new set with the same entries but sub ordered by ID.
     * @return  A new set with the same entries but sub ordered by ID.
     */
    public PersonSet subOrderByID();

    /**
     * Returns a new set with the same entries but sub ordered by ID.
     * @return  A new set with the same entries but sub ordered by ID.
     */
    public PersonSet subOrderByIDDesc();

    /**
     * Returns a new set with the same entries but ordered by firstName
     * @return  A new set with the same entries but ordered by firstName
     */
    public PersonSet orderByFirstName();

    /**
     * Returns a new set with the same entries but ordered by firstName
     * @return  A new set with the same entries but ordered by firstName
     */
    public PersonSet orderByFirstNameDesc();

    /**
     * Returns a new set with the same entries that is sub ordered by firstName
     * @return  A new set with the same entries that is sub ordered by firstName
     */
    public PersonSet subOrderByFirstName();

    /**
     * Returns a new set with the same entries that is sub ordered by firstName
     * @return  A new set with the same entries that is sub ordered by firstName
     */
    public PersonSet subOrderByFirstNameDesc();

    /**
     * Returns a new set with the same entries but ordered by lastName
     * @return  A new set with the same entries but ordered by lastName
     */
    public PersonSet orderByLastName();

    /**
     * Returns a new set with the same entries but ordered by lastName
     * @return  A new set with the same entries but ordered by lastName
     */
    public PersonSet orderByLastNameDesc();

    /**
     * Returns a new set with the same entries that is sub ordered by lastName
     * @return  A new set with the same entries that is sub ordered by lastName
     */
    public PersonSet subOrderByLastName();

    /**
     * Returns a new set with the same entries that is sub ordered by lastName
     * @return  A new set with the same entries that is sub ordered by lastName
     */
    public PersonSet subOrderByLastNameDesc();

    /**
     * Returns a new set with the same entries but ordered by email
     * @return  A new set with the same entries but ordered by email
     */
    public PersonSet orderByEmail();

    /**
     * Returns a new set with the same entries but ordered by email
     * @return  A new set with the same entries but ordered by email
     */
    public PersonSet orderByEmailDesc();

    /**
     * Returns a new set with the same entries that is sub ordered by email
     * @return  A new set with the same entries that is sub ordered by email
     */
    public PersonSet subOrderByEmail();

    /**
     * Returns a new set with the same entries that is sub ordered by email
     * @return  A new set with the same entries that is sub ordered by email
     */
    public PersonSet subOrderByEmailDesc();

    /**
     * This methods follows the relation CourseEnrollment
     * @return  The result of following the relation CourseEnrollment
     */
    public CourseSet asStudentSetGetCourseSet();

    /**
     * This methods follows the relation TeacherAssignment
     * @return  The result of following the relation TeacherAssignment
     */
    public CourseSet asTeacherSetGetCourseSet();

    /**
     * Returns an iterator for this set
     * @return  An iterator for this set
     */
    public Iterator<PersonViewer> iterator();

}
