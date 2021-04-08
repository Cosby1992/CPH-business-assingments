package main.generated.mydatamodel.kinds.person;

import main.generated.valuedomains.Email;
import main.generated.valuedomains.Name;
import org.abstractica.edma.runtime.intf.exceptions.UniqueException;

/**
 * This is the update interface for Person
 */
public interface PersonUpdater extends PersonViewer
{

    /**
     * Begin attribute updates on this Person
     * @return  An attribute update interface for chaining attribute updates
     */
    public PersonAttUpd beginUpdate();

    /**
     * Interface for updating attributes on an entity of kind: Person
     */
    public interface PersonAttUpd
    {

        /**
         * Sets the attribute firstName on this Person
         * @param firstName  The value to set
         * @return           Interface for chaining attribute updates
         */
        public PersonAttUpd setFirstName(Name firstName);

        /**
         * Sets the attribute lastName on this Person
         * @param lastName  The value to set
         * @return          Interface for chaining attribute updates
         */
        public PersonAttUpd setLastName(Name lastName);

        /**
         * Sets the attribute email on this Person
         * @param email  The value to set
         * @return       Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setEmail(Email email);

        /**
         * Saves the changes to the data model.
         * @return  
         */
        public boolean save();

    }

    /**
     * Interface for updating attributes on an entity of kind: Person
     */
    public interface PersonAttUpdUnique
    {

        /**
         * Sets the attribute firstName on this Person
         * @param firstName  The value to set
         * @return           Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setFirstName(Name firstName);

        /**
         * Sets the attribute lastName on this Person
         * @param lastName  The value to set
         * @return          Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setLastName(Name lastName);

        /**
         * Sets the attribute email on this Person
         * @param email  The value to set
         * @return       Interface for chaining attribute updates
         */
        public PersonAttUpdUnique setEmail(Email email);

        /**
         * Saves the changes to the data model.
         * @return  
         */
        public boolean save() throws UniqueException;

    }

}
