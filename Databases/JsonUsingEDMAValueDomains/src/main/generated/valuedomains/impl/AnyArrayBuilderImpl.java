package main.generated.valuedomains.impl;

import java.util.ArrayList;
import main.generated.valuedomains.AnyArray;
import main.generated.valuedomains.AnyArray.AnyArrayBuilder;
import main.generated.valuedomains.Value;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class AnyArrayBuilderImpl implements AnyArrayBuilder
{
    private ArrayList<Object> valueList;



    /**
     * Constructor
     */
    public AnyArrayBuilderImpl()
    {
        valueList = new ArrayList<Object>();
    }

    /**
     * Adds an element to the list
     * @param value  The element to be added to the list
     * @return       An interface to the builder for chaining method calls
     */
    public AnyArrayBuilder add(Value value)
    {
        if(value == null) throw new NullPointerException();
        valueList.add(((IValueInstance) value).edma_getValue());
        return this;
    }

    /**
     * Builds the list with the added elements
     * @return  The builded list
     */
    public AnyArray end()
    {
        Object[] res = new Object[valueList.size()];
        int pos = 0;
        for(Object o : valueList)
        {
            res[pos++] = o;
        }
        return new AnyArrayImpl(AnyArrayImpl.edma_create(res));
    }
}
