package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.Member;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.JsonObjectBuilderImpl;
import main.generated.valuedomains.impl.JsonObjectImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JsonObject
 */
public abstract class JsonObject implements Comparable<JsonObject>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(9);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JsonObject from the terminal
     */
    public static JsonObject fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JsonObjectImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JsonObject from the string representation
     */
    public static JsonObject fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JsonObjectImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JsonObject read from the stream
     */
    public static JsonObject fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JsonObjectImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JsonObject read from the stream
     */
    public static JsonObject fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JsonObjectImpl(res);
    }

    /**
     * Starts creation of a new JsonObject
     * @return  Builder interface to set the member field
     */
    public static JsonObjectBuilderMember create()
    {
        return new JsonObjectBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field member
     * @return  The value of the field member
     */
    public abstract Member member();


    /**
     * Builder interface for setting the member field of JsonObject
     */
    public interface JsonObjectBuilderMember
    {

        /**
         * sets the member field.
         * @param member  The value to assign to the member field
         * @return        The created JsonObject value
         */
        public JsonObject member(Member member);

    }

}
