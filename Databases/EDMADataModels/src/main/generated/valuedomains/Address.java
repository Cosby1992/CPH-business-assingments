package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.AddressLine;
import main.generated.valuedomains.City;
import main.generated.valuedomains.ZipCode;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.AddressBuilderImpl;
import main.generated.valuedomains.impl.AddressImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Address
 */
public abstract class Address implements Comparable<Address>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(16);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Address from the terminal
     */
    public static Address fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new AddressImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Address from the string representation
     */
    public static Address fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new AddressImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Address read from the stream
     */
    public static Address fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new AddressImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Address read from the stream
     */
    public static Address fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new AddressImpl(res);
    }

    /**
     * Starts creation of a new Address
     * @return  Builder interface to set the line1 field
     */
    public static AddressBuilderLine1 create()
    {
        return new AddressBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field line1
     * @return  The value of the field line1
     */
    public abstract AddressLine line1();

    /**
     * returns the value of the field line2
     * @return  The value of the field line2
     */
    public abstract AddressLine line2();

    /**
     * returns the value of the field city
     * @return  The value of the field city
     */
    public abstract City city();

    /**
     * returns the value of the field zipCode
     * @return  The value of the field zipCode
     */
    public abstract ZipCode zipCode();


    /**
     * Builder interface for setting the line1 field of Address
     */
    public interface AddressBuilderLine1
    {

        /**
         * sets the line1 field.
         * @param line1  The value to assign to the line1 field
         * @return       Builder interface for setting the line2 field
         */
        public AddressBuilderLine2 line1(AddressLine line1);

        /**
         * sets the line1 field.
         * @param line1  The value to assign to the line1 field
         * @return       Builder interface for setting the line2 field
         */
        public AddressBuilderLine2 line1(String line1) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the line2 field of Address
     */
    public interface AddressBuilderLine2
    {

        /**
         * sets the line2 field.
         * @param line2  The value to assign to the line2 field
         * @return       Builder interface for setting the city field
         */
        public AddressBuilderCity line2(AddressLine line2);

        /**
         * sets the line2 field.
         * @param line2  The value to assign to the line2 field
         * @return       Builder interface for setting the city field
         */
        public AddressBuilderCity line2(String line2) throws InvalidValueException;

        /**
         * sets the fieldline2 to null.
         * @return  Builder interface for setting the city field
         */
        public AddressBuilderCity noLine2();

    }



    /**
     * Builder interface for setting the city field of Address
     */
    public interface AddressBuilderCity
    {

        /**
         * sets the city field.
         * @param city  The value to assign to the city field
         * @return      Builder interface for setting the zipCode field
         */
        public AddressBuilderZipCode city(City city);

        /**
         * sets the city field.
         * @param city  The value to assign to the city field
         * @return      Builder interface for setting the zipCode field
         */
        public AddressBuilderZipCode city(String city) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the zipCode field of Address
     */
    public interface AddressBuilderZipCode
    {

        /**
         * sets the zipCode field.
         * @param zipCode  The value to assign to the zipCode field
         * @return         The created Address value
         */
        public Address zipCode(ZipCode zipCode);

        /**
         * sets the zipCode field.
         * @param zipCode  The value to assign to the zipCode field
         * @return         The created Address value
         */
        public Address zipCode(Integer zipCode) throws InvalidValueException;

    }

}
