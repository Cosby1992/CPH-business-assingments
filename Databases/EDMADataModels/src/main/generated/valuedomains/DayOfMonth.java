package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.DayOfMonthImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: DayOfMonth
 */
public abstract class DayOfMonth implements Comparable<DayOfMonth>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(2);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The DayOfMonth from the terminal
     */
    public static DayOfMonth fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new DayOfMonthImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The DayOfMonth from the string representation
     */
    public static DayOfMonth fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new DayOfMonthImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The DayOfMonth read from the stream
     */
    public static DayOfMonth fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new DayOfMonthImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The DayOfMonth read from the stream
     */
    public static DayOfMonth fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new DayOfMonthImpl(res);
    }

    /**
     * Call this method to create a new DayOfMonth value. 
     * @param value  The value of the DayOfMonth to be created.
     * @return       The newly created DayOfMonth value
     */
    public static DayOfMonth create(Integer value) throws InvalidValueException
    {
        DayOfMonthImpl.edma_validate(value);
        return new DayOfMonthImpl(DayOfMonthImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid DayOfMonth
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid DayOfMonth
     */
    public static boolean isValidDayOfMonth(Integer value)
    {
        try
        {
            DayOfMonthImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this DayOfMonth
     * @return  The Integer value stored in this DayOfMonth
     */
    public abstract Integer value();
}
