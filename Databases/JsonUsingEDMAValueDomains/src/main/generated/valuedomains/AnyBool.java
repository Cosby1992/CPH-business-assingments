package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyBoolImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AnyBool
 */
public abstract class AnyBool implements Comparable<AnyBool>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(1);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AnyBool from the terminal
     */
    public static AnyBool fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AnyBoolImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AnyBool from the string representation
     */
    public static AnyBool fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AnyBoolImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AnyBool read from the stream
     */
    public static AnyBool fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AnyBoolImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AnyBool read from the stream
     */
    public static AnyBool fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AnyBoolImpl(res);
    }

    /**
     * Call this method to create a new AnyBool value. 
     * @param value  The value of the AnyBool to be created.
     * @return       The newly created AnyBool value
     */
    public static AnyBool create(Boolean value)
    {
        return new AnyBoolImpl(AnyBoolImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Boolean is a valid AnyBool
     * @param value  The Boolean value to be tested
     * @return       true if the provided Boolean is a valid AnyBool
     */
    public static boolean isValidAnyBool(Boolean value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Boolean value that is stored in this AnyBool
     * @return  The Boolean value stored in this AnyBool
     */
    public abstract Boolean value();
}
