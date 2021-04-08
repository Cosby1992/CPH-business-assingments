package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.PosIntImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: PosInt
 */
public abstract class PosInt implements Comparable<PosInt>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(18);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The PosInt from the terminal
     */
    public static PosInt fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new PosIntImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The PosInt from the string representation
     */
    public static PosInt fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new PosIntImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The PosInt read from the stream
     */
    public static PosInt fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new PosIntImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The PosInt read from the stream
     */
    public static PosInt fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new PosIntImpl(res);
    }

    /**
     * Call this method to create a new PosInt value. 
     * @param value  The value of the PosInt to be created.
     * @return       The newly created PosInt value
     */
    public static PosInt create(Integer value) throws InvalidValueException
    {
        PosIntImpl.edma_validate(value);
        return new PosIntImpl(PosIntImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid PosInt
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid PosInt
     */
    public static boolean isValidPosInt(Integer value)
    {
        try
        {
            PosIntImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this PosInt
     * @return  The Integer value stored in this PosInt
     */
    public abstract Integer value();
}
