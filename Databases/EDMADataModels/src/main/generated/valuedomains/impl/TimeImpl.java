package main.generated.valuedomains.impl;

import java.io.DataOutput;
import java.io.IOException;
import main.generated.valuedomains.Hour;
import main.generated.valuedomains.Millisecond;
import main.generated.valuedomains.Minute;
import main.generated.valuedomains.Second;
import main.generated.valuedomains.Time;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.HourImpl;
import main.generated.valuedomains.impl.MillisecondImpl;
import main.generated.valuedomains.impl.MinuteImpl;
import main.generated.valuedomains.impl.SecondImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * The implementation of Time
 */
public class TimeImpl extends Time implements IValueInstance
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
     * @param o  The Object that represents this struct value
     */
    public TimeImpl(Object o)
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
        if(8 != inst.edma_getDomain().getIndex()) return false;
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
     * Compare this Time to another Time
     * @param time  The Time to compare with
     * @return      A negative integer, zero, or a positive integer as this
     *              Time is less than, equal to, or greater than the specified
     *              Time
     */
    public int compareTo(Time time)
    {
        return edma_domain.valueCompare(value, ((TimeImpl) time).value);
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
     * returns the value of the field hour
     * @return  The value of the field hour
     */
    public Hour hour()
    {
        return new HourImpl(value[0]);
    }

    /**
     * returns the value of the field min
     * @return  The value of the field min
     */
    public Minute min()
    {
        return new MinuteImpl(value[1]);
    }

    /**
     * returns the value of the field second
     * @return  The value of the field second
     */
    public Second second()
    {
        return new SecondImpl(value[2]);
    }

    /**
     * returns the value of the field milliseconds
     * @return  The value of the field milliseconds
     */
    public Millisecond milliseconds()
    {
        return new MillisecondImpl(value[3]);
    }
}
