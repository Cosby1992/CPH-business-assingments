package main.generated.valuedomains;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import main.generated.JsonUsingEDMAValueDomains;
import main.generated.valuedomains.Member;
import main.generated.valuedomains.Pair;
import main.generated.valuedomains.external.EDMA_ExternalConstraints;
import main.generated.valuedomains.impl.MemberBuilderImpl;
import main.generated.valuedomains.impl.MemberImpl;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: Member
 */
public abstract class Member implements Comparable<Member>
{
    protected static final IMetaValueDomain edma_domain = JsonUsingEDMAValueDomains.environment.getValueDomainDefinitions().getValueDomain(6);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The Member from the terminal
     */
    public static Member fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new MemberImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The Member from the string representation
     */
    public static Member fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new MemberImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The Member read from the stream
     */
    public static Member fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new MemberImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The Member read from the stream
     */
    public static Member fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new MemberImpl(res);
    }

    /**
     * Starts creation of a new Member
     * @return  Builder interface to set the pair field
     */
    public static MemberBuilderPair create()
    {
        return new MemberBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field pair
     * @return  The value of the field pair
     */
    public abstract Pair pair();

    /**
     * returns the value of the field member
     * @return  The value of the field member
     */
    public abstract Member member();


    /**
     * Builder interface for setting the pair field of Member
     */
    public interface MemberBuilderPair
    {

        /**
         * sets the pair field.
         * @param pair  The value to assign to the pair field
         * @return      Builder interface for setting the member field
         */
        public MemberBuilderMember pair(Pair pair);

    }



    /**
     * Builder interface for setting the member field of Member
     */
    public interface MemberBuilderMember
    {

        /**
         * sets the member field.
         * @param member  The value to assign to the member field
         * @return        The created Member value
         */
        public Member member(Member member);

        /**
         * sets the fieldmember to null.
         * @return  The created Member value
         */
        public Member noMember();

    }

}
