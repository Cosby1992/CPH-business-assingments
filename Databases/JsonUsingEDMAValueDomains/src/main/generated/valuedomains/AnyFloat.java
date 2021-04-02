package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyFloatImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AnyFloat
 */
public abstract class AnyFloat implements Comparable<AnyFloat>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(3);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AnyFloat from the terminal
     */
    public static AnyFloat fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AnyFloatImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AnyFloat from the string representation
     */
    public static AnyFloat fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AnyFloatImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AnyFloat read from the stream
     */
    public static AnyFloat fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AnyFloatImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AnyFloat read from the stream
     */
    public static AnyFloat fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AnyFloatImpl(res);
    }

    /**
     * Call this method to create a new AnyFloat value. 
     * @param value  The value of the AnyFloat to be created.
     * @return       The newly created AnyFloat value
     */
    public static AnyFloat create(Float value)
    {
        return new AnyFloatImpl(AnyFloatImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Float is a valid AnyFloat
     * @param value  The Float value to be tested
     * @return       true if the provided Float is a valid AnyFloat
     */
    public static boolean isValidAnyFloat(Float value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Float value that is stored in this AnyFloat
     * @return  The Float value stored in this AnyFloat
     */
    public abstract Float value();
}
