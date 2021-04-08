package main.generated.valuedomains.impl;

import java.io.DataOutput;
import java.io.IOException;
import main.generated.valuedomains.AnyString;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * The implementation of AnyString
 */
public class AnyStringImpl extends AnyString implements IValueInstance
{
    private Object value;



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
     * @param value  The internal value
     */
    public AnyStringImpl(Object value)
    {
        this.value = value;
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
        if(20 != inst.edma_getDomain().getIndex()) return false;
        return edma_domain.valueEqual(value, inst.edma_getValue());
    }

    /**
     * Gets the value hash for this value instance
     * @return  The hash for this value instance
     */
    public int hashCode()
    {
        return value.hashCode();
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
     * Compare this AnyString to another AnyString
     * @param anyString  The AnyString to compare with
     * @return           A negative integer, zero, or a positive integer as
     *                   this AnyString is less than, equal to, or greater than
     *                   the specified AnyString
     */
    public int compareTo(AnyString anyString)
    {
        return edma_domain.valueCompare(value, ((AnyStringImpl) anyString).value);
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
     * returns the String value that is stored in this AnyString
     * @return  The String value stored in this AnyString
     */
    public String value()
    {
        return (String) value;
    }
}
