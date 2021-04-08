package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.Date;
import main.generated.valuedomains.Time;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.DateAndTimeBuilderImpl;
import main.generated.valuedomains.impl.DateAndTimeImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: DateAndTime
 */
public abstract class DateAndTime implements Comparable<DateAndTime>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(9);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The DateAndTime from the terminal
     */
    public static DateAndTime fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new DateAndTimeImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The DateAndTime from the string representation
     */
    public static DateAndTime fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new DateAndTimeImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The DateAndTime read from the stream
     */
    public static DateAndTime fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new DateAndTimeImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The DateAndTime read from the stream
     */
    public static DateAndTime fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new DateAndTimeImpl(res);
    }

    /**
     * Starts creation of a new DateAndTime
     * @return  Builder interface to set the date field
     */
    public static DateAndTimeBuilderDate create()
    {
        return new DateAndTimeBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field date
     * @return  The value of the field date
     */
    public abstract Date date();

    /**
     * returns the value of the field time
     * @return  The value of the field time
     */
    public abstract Time time();


    /**
     * Builder interface for setting the date field of DateAndTime
     */
    public interface DateAndTimeBuilderDate
    {

        /**
         * sets the date field.
         * @param date  The value to assign to the date field
         * @return      Builder interface for setting the time field
         */
        public DateAndTimeBuilderTime date(Date date);

    }



    /**
     * Builder interface for setting the time field of DateAndTime
     */
    public interface DateAndTimeBuilderTime
    {

        /**
         * sets the time field.
         * @param time  The value to assign to the time field
         * @return      The created DateAndTime value
         */
        public DateAndTime time(Time time);

    }

}
