package main.generated.valuedomains.mydatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.mydatamodel.impl.CourseIDImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: CourseID
 */
public abstract class CourseID implements Comparable<CourseID>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(24);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The CourseID from the terminal
     */
    public static CourseID fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new CourseIDImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The CourseID from the string representation
     */
    public static CourseID fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new CourseIDImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The CourseID read from the stream
     */
    public static CourseID fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new CourseIDImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The CourseID read from the stream
     */
    public static CourseID fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new CourseIDImpl(res);
    }

    /**
     * Call this method to create a new CourseID value. 
     * @param value  The value of the CourseID to be created.
     * @return       The newly created CourseID value
     */
    public static CourseID create(Long value) throws InvalidValueException
    {
        CourseIDImpl.edma_validate(value);
        return new CourseIDImpl(CourseIDImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Long is a valid CourseID
     * @param value  The Long value to be tested
     * @return       true if the provided Long is a valid CourseID
     */
    public static boolean isValidCourseID(Long value)
    {
        try
        {
            CourseIDImpl.edma_validate(value);
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
     * returns the Long value that is stored in this CourseID
     * @return  The Long value stored in this CourseID
     */
    public abstract Long value();
}
