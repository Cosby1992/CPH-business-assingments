package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.NameImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Name
 */
public abstract class Name implements Comparable<Name>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(10);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Name from the terminal
     */
    public static Name fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new NameImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Name from the string representation
     */
    public static Name fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new NameImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Name read from the stream
     */
    public static Name fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new NameImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Name read from the stream
     */
    public static Name fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new NameImpl(res);
    }

    /**
     * Call this method to create a new Name value. 
     * @param value  The value of the Name to be created.
     * @return       The newly created Name value
     */
    public static Name create(String value) throws InvalidValueException
    {
        NameImpl.edma_validate(value);
        return new NameImpl(NameImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid Name
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid Name
     */
    public static boolean isValidName(String value)
    {
        try
        {
            NameImpl.edma_validate(value);
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
     * returns the String value that is stored in this Name
     * @return  The String value stored in this Name
     */
    public abstract String value();
}
