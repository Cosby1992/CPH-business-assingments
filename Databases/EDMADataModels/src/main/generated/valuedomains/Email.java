package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.EmailImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Email
 */
public abstract class Email implements Comparable<Email>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(11);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Email from the terminal
     */
    public static Email fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new EmailImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Email from the string representation
     */
    public static Email fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new EmailImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Email read from the stream
     */
    public static Email fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new EmailImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Email read from the stream
     */
    public static Email fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new EmailImpl(res);
    }

    /**
     * Call this method to create a new Email value. 
     * @param value  The value of the Email to be created.
     * @return       The newly created Email value
     */
    public static Email create(String value) throws InvalidValueException
    {
        EmailImpl.edma_validate(value);
        return new EmailImpl(EmailImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid Email
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid Email
     */
    public static boolean isValidEmail(String value)
    {
        try
        {
            EmailImpl.edma_validate(value);
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
     * returns the String value that is stored in this Email
     * @return  The String value stored in this Email
     */
    public abstract String value();
}
