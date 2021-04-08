package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.ZipCodeImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: ZipCode
 */
public abstract class ZipCode implements Comparable<ZipCode>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(15);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The ZipCode from the terminal
     */
    public static ZipCode fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ZipCodeImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The ZipCode from the string representation
     */
    public static ZipCode fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ZipCodeImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The ZipCode read from the stream
     */
    public static ZipCode fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ZipCodeImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The ZipCode read from the stream
     */
    public static ZipCode fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ZipCodeImpl(res);
    }

    /**
     * Call this method to create a new ZipCode value. 
     * @param value  The value of the ZipCode to be created.
     * @return       The newly created ZipCode value
     */
    public static ZipCode create(Integer value) throws InvalidValueException
    {
        ZipCodeImpl.edma_validate(value);
        return new ZipCodeImpl(ZipCodeImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid ZipCode
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid ZipCode
     */
    public static boolean isValidZipCode(Integer value)
    {
        try
        {
            ZipCodeImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this ZipCode
     * @return  The Integer value stored in this ZipCode
     */
    public abstract Integer value();
}
