package main.generated.edmaimpl.models.mydatamodel;

import java.util.HashMap;
import java.util.Map;
import main.generated.edmaimpl.models.mydatamodel.CourseSetImpl;
import main.generated.mydatamodel.kinds.course.CourseSet;
import main.generated.mydatamodel.kinds.person.PersonUpdater;
import main.generated.mydatamodel.kinds.person.PersonViewer;
import main.generated.valuedomains.Email;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.impl.EmailImpl;
import main.generated.valuedomains.impl.NameImpl;
import main.generated.valuedomains.mydatamodel.Person;
import main.generated.valuedomains.mydatamodel.PersonID;
import main.generated.valuedomains.mydatamodel.impl.PersonIDImpl;
import main.generated.valuedomains.mydatamodel.impl.PersonImpl;
import org.abstractica.edma.runtime.intf.IDataModelUpdate;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IEntity;
import org.abstractica.edma.runtime.intf.exceptions.UniqueException;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class PersonVUImpl implements PersonUpdater, PersonViewer
{
    protected IEntity edma_entity;
    private IDataModelView edma_dmview;



    /**
     * Constructor
     * @param edma_entity  Internal entity
     * @param edma_dmview  Internal runtime interface
     */
    public PersonVUImpl(IEntity edma_entity, IDataModelView edma_dmview)
    {
        this.edma_entity = edma_entity;
        this.edma_dmview = edma_dmview;
    }

    /**
     * Create a copy of this Person at this instance in time
     * @return  A copy of this Person entity as a value  from the value domain
     *          Person
     */
    public Person snapshot()
    {
        Object[] res = new Object[4];
        Object[] internal = edma_entity.getValue();
        res[0] = internal[0];
        res[1] = internal[1];
        res[2] = internal[2];
        res[3] = internal[3];
        return new PersonImpl(res);
    }

    /**
     * Returns the ID of this Person
     * @return  The ID of this Person
     */
    public PersonID getID()
    {
        return new PersonIDImpl(edma_entity.getID());
    }

    /**
     * Returns the attribute firstName of this Person
     * @return  The value of the attribute firstName
     */
    public Name getFirstName()
    {
        return new NameImpl(edma_entity.getValue()[1]);
    }

    /**
     * Returns the attribute lastName of this Person
     * @return  The value of the attribute lastName
     */
    public Name getLastName()
    {
        return new NameImpl(edma_entity.getValue()[2]);
    }

    /**
     * Returns the attribute email of this Person
     * @return  The value of the attribute email
     */
    public Email getEmail()
    {
        return new EmailImpl(edma_entity.getValue()[3]);
    }

    /**
     * This methods follows the relation CourseEnrollment
     * @return  The result of following the relation CourseEnrollment
     */
    public CourseSet asStudentGetCourseSet()
    {
        int setID = edma_dmview.relationAsBGetASet(0, edma_entity.getID());
        return new CourseSetImpl(setID, edma_dmview);
    }

    /**
     * This methods follows the relation TeacherAssignment
     * @return  The result of following the relation TeacherAssignment
     */
    public CourseSet asTeacherGetCourseSet()
    {
        int setID = edma_dmview.relationAsBGetASet(1, edma_entity.getID());
        return new CourseSetImpl(setID, edma_dmview);
    }

    /**
     * Returns <tt>true</tt> if this entity has the same ID as the provided
     * entity
     * @param o  The object to compare with
     * @return   <tt>true</tt> if this entity has the same ID as the provided
     *           entity
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof PersonViewer)) return false;
        PersonViewer other = (PersonViewer) o;
        return getID().equals(other.getID());
    }

    /**
     * Returns the hash code of this entity
     * @return  The hash code of this entity
     */
    public int hashCode()
    {
        return getID().hashCode();
    }

    /**
     * Begin attribute updates on this Person
     * @return  An attribute update interface for chaining attribute updates
     */
    public PersonAttUpd beginUpdate()
    {
        return new PersonAttUpdImpl(edma_entity.getID(), edma_dmview.getUpdateInterface());
    }


    /**
     * 
     */
    private class PersonAttUpdImpl implements PersonAttUpd
    {
        private Long entityID;
        private IDataModelUpdate edma_dmupdate;
        private Map<Integer, Object> updateMap;



        /**
         * Constructor
         * @param entityID       ID of the entity to update
         * @param edma_dmupdate  Internal runtime interface
         */
        private PersonAttUpdImpl(Long entityID, IDataModelUpdate edma_dmupdate)
        {
            this.entityID = entityID;
            this.edma_dmupdate = edma_dmupdate;
            this.updateMap = new HashMap<Integer, Object>();
        }

        /**
         * Sets the attribute firstName on this Person
         * @param firstName  The value to set
         * @return           Interface for chaining attribute updates
         */
        public PersonAttUpd setFirstName(Name firstName)
        {
            updateMap.put(0, ((IValueInstance) firstName).edma_getValue());
            return this;
        }

        /**
         * Sets the attribute lastName on this Person
         * @param lastName  The value to set
         * @return          Interface for chaining attribute updates
         */
        public PersonAttUpd setLastName(Name lastName)
        {
            updateMap.put(1, ((IValueInstance) lastName).edma_getValue());
            return this;
        }

        /**
         * Sets the attribute email on this Person
         * @param email  The value to set
         * @return       Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setEmail(Email email)
        {
            updateMap.put(2, ((IValueInstance) email).edma_getValue());
            return new PersonAttUpdUniqueImpl(entityID, updateMap, edma_dmupdate);
        }

        /**
         * Saves the changes to the data model.
         * @return  
         */
        public boolean save()
        {
            return edma_dmupdate.entityUpdate(0, entityID, updateMap);
        }
    }



    /**
     * 
     */
    private class PersonAttUpdUniqueImpl implements PersonAttUpdUnique
    {
        private Long entityID;
        private Map<Integer, Object> updateMap;
        private IDataModelUpdate edma_dmupdate;



        /**
         * Constructor
         * @param entityID       ID of the entity to update
         * @param updateMap      Map of updates
         * @param edma_dmupdate  Internal runtime interface
         */
        private PersonAttUpdUniqueImpl(Long entityID, Map<Integer, Object> updateMap, IDataModelUpdate edma_dmupdate)
        {
            this.entityID = entityID;
            this.updateMap = updateMap;
            this.edma_dmupdate = edma_dmupdate;
        }

        /**
         * Sets the attribute firstName on this Person
         * @param firstName  The value to set
         * @return           Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setFirstName(Name firstName)
        {
            updateMap.put(0, ((IValueInstance) firstName).edma_getValue());
            return this;
        }

        /**
         * Sets the attribute lastName on this Person
         * @param lastName  The value to set
         * @return          Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setLastName(Name lastName)
        {
            updateMap.put(1, ((IValueInstance) lastName).edma_getValue());
            return this;
        }

        /**
         * Sets the attribute email on this Person
         * @param email  The value to set
         * @return       Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setEmail(Email email)
        {
            updateMap.put(2, ((IValueInstance) email).edma_getValue());
            return this;
        }

        /**
         * Saves the changes to the data model.
         * @return  
         */
        public boolean save() throws UniqueException
        {
            return edma_dmupdate.entityUpdateUnique(0, entityID, updateMap);
        }
    }

}
