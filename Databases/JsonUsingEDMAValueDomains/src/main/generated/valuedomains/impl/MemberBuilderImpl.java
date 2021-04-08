package main.generated.valuedomains.impl;

import main.generated.valuedomains.Member;
import main.generated.valuedomains.Member.MemberBuilderMember;
import main.generated.valuedomains.Member.MemberBuilderPair;
import main.generated.valuedomains.Pair;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class MemberBuilderImpl implements MemberBuilderMember, MemberBuilderPair
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public MemberBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the pair field.
     * @param pair  The value to assign to the pair field
     * @return      Builder interface for setting the member field
     */
    public MemberBuilderMember pair(Pair pair)
    {
        if(pair == null) throw new NullPointerException("The field pair in the Member ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) pair).edma_getValue();
        return this;
    }

    /**
     * sets the member field.
     * @param member  The value to assign to the member field
     * @return        The created Member value
     */
    public Member member(Member member)
    {
        edma_value[1] = (member == null ? null : (((IValueInstance) member).edma_getValue()));
        return new MemberImpl(MemberImpl.edma_create(edma_value));
    }

    /**
     * sets the fieldmember to null.
     * @return  The created Member value
     */
    public Member noMember()
    {
        edma_value[1] = null;
        return new MemberImpl(MemberImpl.edma_create(edma_value));
    }
}
