package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.Hour;
import main.generated.valuedomains.Millisecond;
import main.generated.valuedomains.Minute;
import main.generated.valuedomains.Second;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.TimeBuilderImpl;
import main.generated.valuedomains.impl.TimeImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Time
 */
public abstract class Time implements Comparable<Time>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(8);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Time from the terminal
     */
    public static Time fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new TimeImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Time from the string representation
     */
    public static Time fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new TimeImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Time read from the stream
     */
    public static Time fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new TimeImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Time read from the stream
     */
    public static Time fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new TimeImpl(res);
    }

    /**
     * Starts creation of a new Time
     * @return  Builder interface to set the hour field
     */
    public static TimeBuilderHour create()
    {
        return new TimeBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field hour
     * @return  The value of the field hour
     */
    public abstract Hour hour();

    /**
     * returns the value of the field min
     * @return  The value of the field min
     */
    public abstract Minute min();

    /**
     * returns the value of the field second
     * @return  The value of the field second
     */
    public abstract Second second();

    /**
     * returns the value of the field milliseconds
     * @return  The value of the field milliseconds
     */
    public abstract Millisecond milliseconds();


    /**
     * Builder interface for setting the hour field of Time
     */
    public interface TimeBuilderHour
    {

        /**
         * sets the hour field.
         * @param hour  The value to assign to the hour field
         * @return      Builder interface for setting the min field
         */
        public TimeBuilderMin hour(Hour hour);

        /**
         * sets the hour field.
         * @param hour  The value to assign to the hour field
         * @return      Builder interface for setting the min field
         */
        public TimeBuilderMin hour(Integer hour) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the min field of Time
     */
    public interface TimeBuilderMin
    {

        /**
         * sets the min field.
         * @param min  The value to assign to the min field
         * @return     Builder interface for setting the second field
         */
        public TimeBuilderSecond min(Minute min);

        /**
         * sets the min field.
         * @param min  The value to assign to the min field
         * @return     Builder interface for setting the second field
         */
        public TimeBuilderSecond min(Integer min) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the second field of Time
     */
    public interface TimeBuilderSecond
    {

        /**
         * sets the second field.
         * @param second  The value to assign to the second field
         * @return        Builder interface for setting the milliseconds field
         */
        public TimeBuilderMilliseconds second(Second second);

        /**
         * sets the second field.
         * @param second  The value to assign to the second field
         * @return        Builder interface for setting the milliseconds field
         */
        public TimeBuilderMilliseconds second(Integer second) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the milliseconds field of Time
     */
    public interface TimeBuilderMilliseconds
    {

        /**
         * sets the milliseconds field.
         * @param milliseconds  The value to assign to the milliseconds field
         * @return              The created Time value
         */
        public Time milliseconds(Millisecond milliseconds);

        /**
         * sets the milliseconds field.
         * @param milliseconds  The value to assign to the milliseconds field
         * @return              The created Time value
         */
        public Time milliseconds(Integer milliseconds) throws InvalidValueException;

    }

}
