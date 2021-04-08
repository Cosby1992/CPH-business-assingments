package main.generated.valuedomains.mydatamodel.impl;

import java.util.ArrayList;
import main.generated.valuedomains.mydatamodel.Person;
import main.generated.valuedomains.mydatamodel.PersonList;
import main.generated.valuedomains.mydatamodel.PersonList.PersonListBuilder;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class PersonListBuilderImpl implements PersonListBuilder
{
    private ArrayList<Object> valueList;



    /**
     * Constructor
     */
    public PersonListBuilderImpl()
    {
        valueList = new ArrayList<Object>();
    }

    /**
     * Adds an element to the list
     * @param person  The element to be added to the list
     * @return        An interface to the builder for chaining method calls
     */
    public PersonListBuilder add(Person person)
    {
        if(person == null) throw new NullPointerException();
        valueList.add(((IValueInstance) person).edma_getValue());
        return this;
    }

    /**
     * Builds the list with the added elements
     * @return  The builded list
     */
    public PersonList end()
    {
        Object[] res = new Object[valueList.size()];
        int pos = 0;
        for(Object o : valueList)
        {
            res[pos++] = o;
        }
        return new PersonListImpl(PersonListImpl.edma_create(res));
    }
}
