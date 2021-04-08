package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.MinuteImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Minute
 */
public abstract class Minute implements Comparable<Minute>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(5);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Minute from the terminal
     */
    public static Minute fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new MinuteImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Minute from the string representation
     */
    public static Minute fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new MinuteImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Minute read from the stream
     */
    public static Minute fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new MinuteImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Minute read from the stream
     */
    public static Minute fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new MinuteImpl(res);
    }

    /**
     * Call this method to create a new Minute value. 
     * @param value  The value of the Minute to be created.
     * @return       The newly created Minute value
     */
    public static Minute create(Integer value) throws InvalidValueException
    {
        MinuteImpl.edma_validate(value);
        return new MinuteImpl(MinuteImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Minute
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Minute
     */
    public static boolean isValidMinute(Integer value)
    {
        try
        {
            MinuteImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this Minute
     * @return  The Integer value stored in this Minute
     */
    public abstract Integer value();
}
