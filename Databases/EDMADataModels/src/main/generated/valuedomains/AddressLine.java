package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AddressLineImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AddressLine
 */
public abstract class AddressLine implements Comparable<AddressLine>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(13);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AddressLine from the terminal
     */
    public static AddressLine fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AddressLineImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AddressLine from the string representation
     */
    public static AddressLine fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AddressLineImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AddressLine read from the stream
     */
    public static AddressLine fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AddressLineImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AddressLine read from the stream
     */
    public static AddressLine fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AddressLineImpl(res);
    }

    /**
     * Call this method to create a new AddressLine value. 
     * @param value  The value of the AddressLine to be created.
     * @return       The newly created AddressLine value
     */
    public static AddressLine create(String value) throws InvalidValueException
    {
        AddressLineImpl.edma_validate(value);
        return new AddressLineImpl(AddressLineImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid AddressLine
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid AddressLine
     */
    public static boolean isValidAddressLine(String value)
    {
        try
        {
            AddressLineImpl.edma_validate(value);
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
     * returns the String value that is stored in this AddressLine
     * @return  The String value stored in this AddressLine
     */
    public abstract String value();
}
