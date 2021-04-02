package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyArrayBuilderImpl;
import main.generated.valuedomains.impl.AnyArrayImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: AnyArray
 */
public abstract class AnyArray implements Comparable<AnyArray>, Iterable<Value>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(7);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The AnyArray from the terminal
     */
    public static AnyArray fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AnyArrayImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The AnyArray from the string representation
     */
    public static AnyArray fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AnyArrayImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The AnyArray read from the stream
     */
    public static AnyArray fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AnyArrayImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The AnyArray read from the stream
     */
    public static AnyArray fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AnyArrayImpl(res);
    }

    /**
     * Starts creation of a new AnyArray
     * @return  Builder interface to build the list
     */
    public static AnyArrayBuilder begin()
    {
        return new AnyArrayBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns the size of this list
     * @return  the size of this list
     */
    public abstract int size();

    /**
     * Returns the element on a given index in this list
     * @param index  The index of the element to be returned
     * @return       the element on the given index in this list
     */
    public abstract Value get(int index);


    /**
     * Interface to create a list
     */
    public interface AnyArrayBuilder
    {

        /**
         * Adds an element to the list
         * @param value  The element to be added to the list
         * @return       An interface to the builder for chaining method calls
         */
        public AnyArrayBuilder add(Value value);

        /**
         * Builds the list with the added elements
         * @return  The builded list
         */
        public AnyArray end();

    }

}
