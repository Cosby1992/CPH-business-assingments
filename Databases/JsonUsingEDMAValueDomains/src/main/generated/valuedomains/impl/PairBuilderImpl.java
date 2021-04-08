package main.generated.valuedomains.impl;

import main.generated.valuedomains.Key;
import main.generated.valuedomains.Pair;
import main.generated.valuedomains.Pair.PairBuilderKey;
import main.generated.valuedomains.Pair.PairBuilderValue;
import main.generated.valuedomains.Value;
import main.generated.valuedomains.impl.KeyImpl;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * 
 */
public class PairBuilderImpl implements PairBuilderKey, PairBuilderValue
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public PairBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the key field.
     * @param key  The value to assign to the key field
     * @return     Builder interface for setting the value field
     */
    public PairBuilderValue key(Key key)
    {
        if(key == null) throw new NullPointerException("The field key in the Pair ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) key).edma_getValue();
        return this;
    }

    /**
     * sets the key field.
     * @param key  The value to assign to the key field
     * @return     Builder interface for setting the value field
     */
    public PairBuilderValue key(String key) throws InvalidValueException
    {
        if(key != null) KeyImpl.edma_validate(key);
        if(key == null) throw new NullPointerException("The field key in the Pair ValueDomain may not be null");
        edma_value[0] = KeyImpl.edma_create(key);
        return this;
    }

    /**
     * sets the value field.
     * @param value  The value to assign to the value field
     * @return       The created Pair value
     */
    public Pair value(Value value)
    {
        if(value == null) throw new NullPointerException("The field value in the Pair ValueDomain may not be null");
        edma_value[1] = ((IValueInstance) value).edma_getValue();
        return new PairImpl(PairImpl.edma_create(edma_value));
    }
}
