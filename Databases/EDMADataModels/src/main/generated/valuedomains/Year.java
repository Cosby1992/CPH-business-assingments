package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.YearImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Year
 */
public abstract class Year implements Comparable<Year>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(0);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Year from the terminal
     */
    public static Year fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new YearImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Year from the string representation
     */
    public static Year fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new YearImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Year read from the stream
     */
    public static Year fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new YearImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Year read from the stream
     */
    public static Year fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new YearImpl(res);
    }

    /**
     * Call this method to create a new Year value. 
     * @param value  The value of the Year to be created.
     * @return       The newly created Year value
     */
    public static Year create(Integer value) throws InvalidValueException
    {
        YearImpl.edma_validate(value);
        return new YearImpl(YearImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Year
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Year
     */
    public static boolean isValidYear(Integer value)
    {
        try
        {
            YearImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this Year
     * @return  The Integer value stored in this Year
     */
    public abstract Integer value();
}
