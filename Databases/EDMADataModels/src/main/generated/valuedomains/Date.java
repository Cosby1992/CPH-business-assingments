package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.DayOfMonth;
import main.generated.valuedomains.Month;
import main.generated.valuedomains.Year;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.DateBuilderImpl;
import main.generated.valuedomains.impl.DateImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Date
 */
public abstract class Date implements Comparable<Date>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(3);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Date from the terminal
     */
    public static Date fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new DateImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Date from the string representation
     */
    public static Date fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new DateImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Date read from the stream
     */
    public static Date fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new DateImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Date read from the stream
     */
    public static Date fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new DateImpl(res);
    }

    /**
     * Starts creation of a new Date
     * @return  Builder interface to set the year field
     */
    public static DateBuilderYear create()
    {
        return new DateBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field year
     * @return  The value of the field year
     */
    public abstract Year year();

    /**
     * returns the value of the field month
     * @return  The value of the field month
     */
    public abstract Month month();

    /**
     * returns the value of the field day
     * @return  The value of the field day
     */
    public abstract DayOfMonth day();


    /**
     * Builder interface for setting the year field of Date
     */
    public interface DateBuilderYear
    {

        /**
         * sets the year field.
         * @param year  The value to assign to the year field
         * @return      Builder interface for setting the month field
         */
        public DateBuilderMonth year(Year year);

        /**
         * sets the year field.
         * @param year  The value to assign to the year field
         * @return      Builder interface for setting the month field
         */
        public DateBuilderMonth year(Integer year) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the month field of Date
     */
    public interface DateBuilderMonth
    {

        /**
         * sets the month field.
         * @param month  The value to assign to the month field
         * @return       Builder interface for setting the day field
         */
        public DateBuilderDay month(Month month);

        /**
         * sets the month field.
         * @param month  The value to assign to the month field
         * @return       Builder interface for setting the day field
         */
        public DateBuilderDay month(Integer month) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the day field of Date
     */
    public interface DateBuilderDay
    {

        /**
         * sets the day field.
         * @param day  The value to assign to the day field
         * @return     The created Date value
         */
        public Date day(DayOfMonth day) throws InvalidValueException;

        /**
         * sets the day field.
         * @param day  The value to assign to the day field
         * @return     The created Date value
         */
        public Date day(Integer day) throws InvalidValueException;

    }

}
