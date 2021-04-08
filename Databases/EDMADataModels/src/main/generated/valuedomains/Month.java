package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.MonthImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Month
 */
public abstract class Month implements Comparable<Month>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(1);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Month from the terminal
     */
    public static Month fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new MonthImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Month from the string representation
     */
    public static Month fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new MonthImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Month read from the stream
     */
    public static Month fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new MonthImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Month read from the stream
     */
    public static Month fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new MonthImpl(res);
    }

    /**
     * Call this method to create a new Month value. 
     * @param value  The value of the Month to be created.
     * @return       The newly created Month value
     */
    public static Month create(Integer value) throws InvalidValueException
    {
        MonthImpl.edma_validate(value);
        return new MonthImpl(MonthImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid Month
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid Month
     */
    public static boolean isValidMonth(Integer value)
    {
        try
        {
            MonthImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this Month
     * @return  The Integer value stored in this Month
     */
    public abstract Integer value();
}
