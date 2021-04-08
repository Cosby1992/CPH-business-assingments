package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.MobileImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Mobile
 */
public abstract class Mobile implements Comparable<Mobile>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(12);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Mobile from the terminal
     */
    public static Mobile fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new MobileImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Mobile from the string representation
     */
    public static Mobile fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new MobileImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Mobile read from the stream
     */
    public static Mobile fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new MobileImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Mobile read from the stream
     */
    public static Mobile fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new MobileImpl(res);
    }

    /**
     * Call this method to create a new Mobile value. 
     * @param value  The value of the Mobile to be created.
     * @return       The newly created Mobile value
     */
    public static Mobile create(String value) throws InvalidValueException
    {
        MobileImpl.edma_validate(value);
        return new MobileImpl(MobileImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid Mobile
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid Mobile
     */
    public static boolean isValidMobile(String value)
    {
        try
        {
            MobileImpl.edma_validate(value);
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
     * returns the String value that is stored in this Mobile
     * @return  The String value stored in this Mobile
     */
    public abstract String value();
}
