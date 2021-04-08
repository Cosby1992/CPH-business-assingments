package main.generated.valuedomains.mydatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.mydatamodel.impl.PersonListBuilderImpl;
import main.generated.valuedomains.mydatamodel.impl.PersonListImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: PersonList
 */
public abstract class PersonList implements Comparable<PersonList>, Iterable<Person>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(22);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The PersonList from the terminal
     */
    public static PersonList fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new PersonListImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The PersonList from the string representation
     */
    public static PersonList fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new PersonListImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The PersonList read from the stream
     */
    public static PersonList fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new PersonListImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The PersonList read from the stream
     */
    public static PersonList fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new PersonListImpl(res);
    }

    /**
     * Starts creation of a new PersonList
     * @return  Builder interface to build the list
     */
    public static PersonListBuilder begin()
    {
        return new PersonListBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns the size of this list
     * @return  the size of this list
     */
    public abstract int size();

    /**
     * Returns the element on a given index in this list
     * @param index  The index of the element to be returned
     * @return       the element on the given index in this list
     */
    public abstract Person get(int index);


    /**
     * Interface to create a list
     */
    public interface PersonListBuilder
    {

        /**
         * Adds an element to the list
         * @param person  The element to be added to the list
         * @return        An interface to the builder for chaining method calls
         */
        public PersonListBuilder add(Person person);

        /**
         * Builds the list with the added elements
         * @return  The builded list
         */
        public PersonList end();

    }

}
