package main.generated.valuedomains.mydatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.EDMADataModels;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.mydatamodel.impl.CourseListBuilderImpl;
import main.generated.valuedomains.mydatamodel.impl.CourseListImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: CourseList
 */
public abstract class CourseList implements Comparable<CourseList>, Iterable<Course>
{
    protected static final IMetaValueDomain edma_domain = EDMADataModels.environment.getValueDomainDefinitions().getValueDomain(25);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The CourseList from the terminal
     */
    public static CourseList fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new CourseListImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The CourseList from the string representation
     */
    public static CourseList fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new CourseListImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The CourseList read from the stream
     */
    public static CourseList fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new CourseListImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The CourseList read from the stream
     */
    public static CourseList fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new CourseListImpl(res);
    }

    /**
     * Starts creation of a new CourseList
     * @return  Builder interface to build the list
     */
    public static CourseListBuilder begin()
    {
        return new CourseListBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * Returns the size of this list
     * @return  the size of this list
     */
    public abstract int size();

    /**
     * Returns the element on a given index in this list
     * @param index  The index of the element to be returned
     * @return       the element on the given index in this list
     */
    public abstract Course get(int index);


    /**
     * Interface to create a list
     */
    public interface CourseListBuilder
    {

        /**
         * Adds an element to the list
         * @param course  The element to be added to the list
         * @return        An interface to the builder for chaining method calls
         */
        public CourseListBuilder add(Course course);

        /**
         * Builds the list with the added elements
         * @return  The builded list
         */
        public CourseList end();

    }

}
