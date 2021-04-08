package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.NotNegIntImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: NotNegInt
 */
public abstract class NotNegInt implements Comparable<NotNegInt>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(19);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The NotNegInt from the terminal
     */
    public static NotNegInt fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new NotNegIntImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The NotNegInt from the string representation
     */
    public static NotNegInt fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new NotNegIntImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The NotNegInt read from the stream
     */
    public static NotNegInt fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new NotNegIntImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The NotNegInt read from the stream
     */
    public static NotNegInt fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new NotNegIntImpl(res);
    }

    /**
     * Call this method to create a new NotNegInt value. 
     * @param value  The value of the NotNegInt to be created.
     * @return       The newly created NotNegInt value
     */
    public static NotNegInt create(Integer value) throws InvalidValueException
    {
        NotNegIntImpl.edma_validate(value);
        return new NotNegIntImpl(NotNegIntImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid NotNegInt
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid NotNegInt
     */
    public static boolean isValidNotNegInt(Integer value)
    {
        try
        {
            NotNegIntImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this NotNegInt
     * @return  The Integer value stored in this NotNegInt
     */
    public abstract Integer value();
}
