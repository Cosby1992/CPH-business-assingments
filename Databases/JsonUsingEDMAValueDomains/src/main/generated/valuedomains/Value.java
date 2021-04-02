package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.AnyArray;
import main.generated.valuedomains.AnyBool;
import main.generated.valuedomains.AnyFloat;
import main.generated.valuedomains.AnyInt;
import main.generated.valuedomains.AnyString;
import main.generated.valuedomains.JsonObject;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.ValueImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Value
 */
public abstract class Value implements Comparable<Value>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(5);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Value from the terminal
     */
    public static Value fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ValueImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Value from the string representation
     */
    public static Value fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ValueImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Value read from the stream
     */
    public static Value fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ValueImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Value read from the stream
     */
    public static Value fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ValueImpl(res);
    }

    /**
     * Creates a new Value with the internal value domain AnyString
     * @param anyString  The internal value that this Value will get
     * @return           The created value
     */
    public static Value create(AnyString anyString)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 0;
        edma_pair[1] = ((IValueInstance) anyString).edma_getValue();
        return new ValueImpl(edma_pair);
    }

    /**
     * Creates a new Value with the internal value domain AnyBool
     * @param anyBool  The internal value that this Value will get
     * @return         The created value
     */
    public static Value create(AnyBool anyBool)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 1;
        edma_pair[1] = ((IValueInstance) anyBool).edma_getValue();
        return new ValueImpl(edma_pair);
    }

    /**
     * Creates a new Value with the internal value domain AnyInt
     * @param anyInt  The internal value that this Value will get
     * @return        The created value
     */
    public static Value create(AnyInt anyInt)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 2;
        edma_pair[1] = ((IValueInstance) anyInt).edma_getValue();
        return new ValueImpl(edma_pair);
    }

    /**
     * Creates a new Value with the internal value domain AnyFloat
     * @param anyFloat  The internal value that this Value will get
     * @return          The created value
     */
    public static Value create(AnyFloat anyFloat)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 3;
        edma_pair[1] = ((IValueInstance) anyFloat).edma_getValue();
        return new ValueImpl(edma_pair);
    }

    /**
     * Creates a new Value with the internal value domain AnyArray
     * @param anyArray  The internal value that this Value will get
     * @return          The created value
     */
    public static Value create(AnyArray anyArray)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 4;
        edma_pair[1] = ((IValueInstance) anyArray).edma_getValue();
        return new ValueImpl(edma_pair);
    }

    /**
     * Creates a new Value with the internal value domain JsonObject
     * @param jsonObject  The internal value that this Value will get
     * @return            The created value
     */
    public static Value create(JsonObject jsonObject)
    {
        Object[] edma_pair = new Object[2];
        edma_pair[0] = 5;
        edma_pair[1] = ((IValueInstance) jsonObject).edma_getValue();
        return new ValueImpl(edma_pair);
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyString
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyString
     */
    public abstract boolean isAnyString();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyBool
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyBool
     */
    public abstract boolean isAnyBool();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyInt
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyInt
     */
    public abstract boolean isAnyInt();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyFloat
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyFloat
     */
    public abstract boolean isAnyFloat();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyArray
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyArray
     */
    public abstract boolean isAnyArray();

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JsonObject
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JsonObject
     */
    public abstract boolean isJsonObject();

    /**
     * Returns this value as a value from the value domain AnyString or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyString
     * @return  This value as a value from the value domain AnyString
     */
    public abstract AnyString asAnyString();

    /**
     * Returns this value as a value from the value domain AnyBool or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * AnyBool
     * @return  This value as a value from the value domain AnyBool
     */
    public abstract AnyBool asAnyBool();

    /**
     * Returns this value as a value from the value domain AnyInt or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * AnyInt
     * @return  This value as a value from the value domain AnyInt
     */
    public abstract AnyInt asAnyInt();

    /**
     * Returns this value as a value from the value domain AnyFloat or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyFloat
     * @return  This value as a value from the value domain AnyFloat
     */
    public abstract AnyFloat asAnyFloat();

    /**
     * Returns this value as a value from the value domain AnyArray or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyArray
     * @return  This value as a value from the value domain AnyArray
     */
    public abstract AnyArray asAnyArray();

    /**
     * Returns this value as a value from the value domain JsonObject or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JsonObject
     * @return  This value as a value from the value domain JsonObject
     */
    public abstract JsonObject asJsonObject();
}
