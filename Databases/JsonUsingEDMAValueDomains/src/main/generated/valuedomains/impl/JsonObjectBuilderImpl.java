package main.generated.valuedomains.impl;

import main.generated.valuedomains.JsonObject;
import main.generated.valuedomains.JsonObject.JsonObjectBuilderMember;
import main.generated.valuedomains.Member;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class JsonObjectBuilderImpl implements JsonObjectBuilderMember
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public JsonObjectBuilderImpl()
    {
        edma_value = new Object[1];
    }

    /**
     * sets the member field.
     * @param member  The value to assign to the member field
     * @return        The created JsonObject value
     */
    public JsonObject member(Member member)
    {
        if(member == null) throw new NullPointerException("The field member in JsonObject may not be null");
        edma_value[0] = ((IValueInstance) member).edma_getValue();
        return new JsonObjectImpl(JsonObjectImpl.edma_create(edma_value));
    }
}
