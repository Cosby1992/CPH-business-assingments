package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.KeyImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Key
 */
public abstract class Key implements Comparable<Key>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(4);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Key from the terminal
     */
    public static Key fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new KeyImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Key from the string representation
     */
    public static Key fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new KeyImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Key read from the stream
     */
    public static Key fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new KeyImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Key read from the stream
     */
    public static Key fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new KeyImpl(res);
    }

    /**
     * Call this method to create a new Key value. 
     * @param value  The value of the Key to be created.
     * @return       The newly created Key value
     */
    public static Key create(String value) throws InvalidValueException
    {
        KeyImpl.edma_validate(value);
        return new KeyImpl(KeyImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid Key
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid Key
     */
    public static boolean isValidKey(String value)
    {
        try
        {
            KeyImpl.edma_validate(value);
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
     * returns the String value that is stored in this Key
     * @return  The String value stored in this Key
     */
    public abstract String value();
}
