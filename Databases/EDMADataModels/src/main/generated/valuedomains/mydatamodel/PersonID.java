package main.generated.valuedomains.mydatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.mydatamodel.impl.PersonIDImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: PersonID
 */
public abstract class PersonID implements Comparable<PersonID>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(21);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The PersonID from the terminal
     */
    public static PersonID fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new PersonIDImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The PersonID from the string representation
     */
    public static PersonID fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new PersonIDImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The PersonID read from the stream
     */
    public static PersonID fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new PersonIDImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The PersonID read from the stream
     */
    public static PersonID fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new PersonIDImpl(res);
    }

    /**
     * Call this method to create a new PersonID value. 
     * @param value  The value of the PersonID to be created.
     * @return       The newly created PersonID value
     */
    public static PersonID create(Long value) throws InvalidValueException
    {
        PersonIDImpl.edma_validate(value);
        return new PersonIDImpl(PersonIDImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Long is a valid PersonID
     * @param value  The Long value to be tested
     * @return       true if the provided Long is a valid PersonID
     */
    public static boolean isValidPersonID(Long value)
    {
        try
        {
            PersonIDImpl.edma_validate(value);
        }
        catch(InvalidValueException e)
        {
            return false;
        }
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Long value that is stored in this PersonID
     * @return  The Long value stored in this PersonID
     */
    public abstract Long value();
}
