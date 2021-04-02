package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyIntImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AnyInt
 */
public abstract class AnyInt implements Comparable<AnyInt>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(2);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AnyInt from the terminal
     */
    public static AnyInt fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AnyIntImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AnyInt from the string representation
     */
    public static AnyInt fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AnyIntImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AnyInt read from the stream
     */
    public static AnyInt fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AnyIntImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AnyInt read from the stream
     */
    public static AnyInt fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AnyIntImpl(res);
    }

    /**
     * Call this method to create a new AnyInt value. 
     * @param value  The value of the AnyInt to be created.
     * @return       The newly created AnyInt value
     */
    public static AnyInt create(Integer value)
    {
        return new AnyIntImpl(AnyIntImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid AnyInt
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid AnyInt
     */
    public static boolean isValidAnyInt(Integer value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Integer value that is stored in this AnyInt
     * @return  The Integer value stored in this AnyInt
     */
    public abstract Integer value();
}
