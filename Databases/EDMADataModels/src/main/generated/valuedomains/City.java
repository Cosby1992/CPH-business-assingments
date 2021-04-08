package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.CityImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: City
 */
public abstract class City implements Comparable<City>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(14);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The City from the terminal
     */
    public static City fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new CityImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The City from the string representation
     */
    public static City fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new CityImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The City read from the stream
     */
    public static City fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new CityImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The City read from the stream
     */
    public static City fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new CityImpl(res);
    }

    /**
     * Call this method to create a new City value. 
     * @param value  The value of the City to be created.
     * @return       The newly created City value
     */
    public static City create(String value) throws InvalidValueException
    {
        CityImpl.edma_validate(value);
        return new CityImpl(CityImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid City
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid City
     */
    public static boolean isValidCity(String value)
    {
        try
        {
            CityImpl.edma_validate(value);
        }
        catch(InvalidValueException e)
        {
            return false;
        }
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the String value that is stored in this City
     * @return  The String value stored in this City
     */
    public abstract String value();
}
