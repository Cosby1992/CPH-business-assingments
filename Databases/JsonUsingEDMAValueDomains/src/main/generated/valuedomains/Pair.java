package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.Key;
import main.generated.valuedomains.Value;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.PairBuilderImpl;
import main.generated.valuedomains.impl.PairImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Pair
 */
public abstract class Pair implements Comparable<Pair>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(8);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Pair from the terminal
     */
    public static Pair fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new PairImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Pair from the string representation
     */
    public static Pair fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new PairImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Pair read from the stream
     */
    public static Pair fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new PairImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Pair read from the stream
     */
    public static Pair fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new PairImpl(res);
    }

    /**
     * Starts creation of a new Pair
     * @return  Builder interface to set the key field
     */
    public static PairBuilderKey create()
    {
        return new PairBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field key
     * @return  The value of the field key
     */
    public abstract Key key();

    /**
     * returns the value of the field value
     * @return  The value of the field value
     */
    public abstract Value value();


    /**
     * Builder interface for setting the key field of Pair
     */
    public interface PairBuilderKey
    {

        /**
         * sets the key field.
         * @param key  The value to assign to the key field
         * @return     Builder interface for setting the value field
         */
        public PairBuilderValue key(Key key);

        /**
         * sets the key field.
         * @param key  The value to assign to the key field
         * @return     Builder interface for setting the value field
         */
        public PairBuilderValue key(String key) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the value field of Pair
     */
    public interface PairBuilderValue
    {

        /**
         * sets the value field.
         * @param value  The value to assign to the value field
         * @return       The created Pair value
         */
        public Pair value(Value value);

    }

}
