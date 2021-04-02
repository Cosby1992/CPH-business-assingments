package main.generated.valuedomains.impl;

import java.io.DataOutput;
import java.io.IOException;
import main.generated.valuedomains.AnyArray;
import main.generated.valuedomains.AnyBool;
import main.generated.valuedomains.AnyFloat;
import main.generated.valuedomains.AnyInt;
import main.generated.valuedomains.AnyString;
import main.generated.valuedomains.JsonObject;
import main.generated.valuedomains.Value;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AnyArrayImpl;
import main.generated.valuedomains.impl.AnyBoolImpl;
import main.generated.valuedomains.impl.AnyFloatImpl;
import main.generated.valuedomains.impl.AnyIntImpl;
import main.generated.valuedomains.impl.AnyStringImpl;
import main.generated.valuedomains.impl.JsonObjectImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * The implementation of Value
 */
public class ValueImpl extends Value implements IValueInstance
{
    private int edma_hash;
    private Object[] value;



    /**
     * Check if a value is valid
     * @param value  The value to validate
     */
    public static void edma_validate(Object value) throws InvalidValueException
    {
        edma_domain.validate(value, EDMA_ExternalConstraints.instance);
    }

    /**
     * create value without checking
     * @param value  The value to check and create
     * @return       <tt>true</tt> The new created value
     */
    public static Object edma_create(Object value)
    {
        return edma_domain.newValue(value);
    }

    /**
     * Constructor
     * @param o  The Object that represents this OneOf value
     */
    public ValueImpl(Object o)
    {
        edma_hash = 0;
        value = (Object[]) o;
    }

    /**
     * Gets the value domain for this value instance
     * @return  The value domain for this value instance
     */
    public IMetaValueDomain edma_getDomain()
    {
        return edma_domain;
    }

    /**
     * Access to the general Object value
     * @return  The value as a general Object
     */
    public Object edma_getValue()
    {
        return value;
    }

    /**
     * Returns <tt>true</tt> if this value equals the given value
     * @param o  Object to test equality with
     * @return   <tt>true</tt> if this value equals the given value
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof IValueInstance)) return false;
        IValueInstance inst = (IValueInstance) o;
        if(5 != inst.edma_getDomain().getIndex()) return false;
        return edma_domain.valueEqual(value, inst.edma_getValue());
    }

    /**
     * Gets the value hash for this value instance
     * @return  The hash for this value instance
     */
    public int hashCode()
    {
        if(edma_hash == 0) edma_hash = edma_domain.valueHashCode(value);
        return edma_hash;
    }

    /**
     * Returns this value instance as a string
     * @return  this value instance as a string
     */
    public String toString()
    {
        return edma_domain.valueToString(value);
    }

    /**
     * Compare this Value to another Value
     * @param value  The Value to compare with
     * @return       A negative integer, zero, or a positive integer as this
     *               Value is less than, equal to, or greater than the specified
     *               Value
     */
    public int compareTo(Value value)
    {
        return edma_domain.valueCompare(value, ((ValueImpl) value).value);
    }

    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public void toStream(DataOutput out) throws IOException
    {
        edma_domain.writeValue(((IValueInstance) this).edma_getValue(), out);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyString
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyString
     */
    public boolean isAnyString()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 0);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyBool
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyBool
     */
    public boolean isAnyBool()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 1);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyInt
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyInt
     */
    public boolean isAnyInt()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 2);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyFloat
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyFloat
     */
    public boolean isAnyFloat()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 3);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * AnyArray
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          AnyArray
     */
    public boolean isAnyArray()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 4);
    }

    /**
     * Returns <tt>true</tt> if this value is a value from the value domain
     * JsonObject
     * @return  <tt>true</tt> if this value is a value from the value domain
     *          JsonObject
     */
    public boolean isJsonObject()
    {
        Integer index = (Integer) value[0];
        return (index.intValue() == 5);
    }

    /**
     * Returns this value as a value from the value domain AnyString or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyString
     * @return  This value as a value from the value domain AnyString
     */
    public AnyString asAnyString()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 0) throw new UnsupportedOperationException();
        return new AnyStringImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain AnyBool or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * AnyBool
     * @return  This value as a value from the value domain AnyBool
     */
    public AnyBool asAnyBool()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 1) throw new UnsupportedOperationException();
        return new AnyBoolImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain AnyInt or throws an
     * UnsupportedOperationException if this value is not from the value domain
     * AnyInt
     * @return  This value as a value from the value domain AnyInt
     */
    public AnyInt asAnyInt()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 2) throw new UnsupportedOperationException();
        return new AnyIntImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain AnyFloat or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyFloat
     * @return  This value as a value from the value domain AnyFloat
     */
    public AnyFloat asAnyFloat()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 3) throw new UnsupportedOperationException();
        return new AnyFloatImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain AnyArray or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain AnyArray
     * @return  This value as a value from the value domain AnyArray
     */
    public AnyArray asAnyArray()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 4) throw new UnsupportedOperationException();
        return new AnyArrayImpl(value[1]);
    }

    /**
     * Returns this value as a value from the value domain JsonObject or throws
     * an UnsupportedOperationException if this value is not from the value
     * domain JsonObject
     * @return  This value as a value from the value domain JsonObject
     */
    public JsonObject asJsonObject()
    {
        Integer index = (Integer) value[0];
        if(index.intValue() != 5) throw new UnsupportedOperationException();
        return new JsonObjectImpl(value[1]);
    }
}
