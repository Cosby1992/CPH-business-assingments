package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyStringImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AnyString
 */
public abstract class AnyString implements Comparable<AnyString>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(0);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AnyString from the terminal
     */
    public static AnyString fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AnyStringImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AnyString from the string representation
     */
    public static AnyString fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AnyStringImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AnyString read from the stream
     */
    public static AnyString fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AnyStringImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AnyString read from the stream
     */
    public static AnyString fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AnyStringImpl(res);
    }

    /**
     * Call this method to create a new AnyString value. 
     * @param value  The value of the AnyString to be created.
     * @return       The newly created AnyString value
     */
    public static AnyString create(String value)
    {
        return new AnyStringImpl(AnyStringImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid AnyString
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid AnyString
     */
    public static boolean isValidAnyString(String value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the String value that is stored in this AnyString
     * @return  The String value stored in this AnyString
     */
    public abstract String value();
}
