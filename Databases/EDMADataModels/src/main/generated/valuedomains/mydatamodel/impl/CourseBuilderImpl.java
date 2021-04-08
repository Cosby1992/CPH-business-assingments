package main.generated.valuedomains.mydatamodel.impl;

import main.generated.valuedomains.Name;
import main.generated.valuedomains.impl.NameImpl;
import main.generated.valuedomains.mydatamodel.Course;
import main.generated.valuedomains.mydatamodel.Course.CourseBuilderID;
import main.generated.valuedomains.mydatamodel.Course.CourseBuilderName;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.impl.CourseIDImpl;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * 
 */
public class CourseBuilderImpl implements CourseBuilderID, CourseBuilderName
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public CourseBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the ID field.
     * @param ID  The value to assign to the ID field
     * @return    Builder interface for setting the name field
     */
    public CourseBuilderName ID(CourseID ID)
    {
        edma_value[0] = (ID == null ? null : (((IValueInstance) ID).edma_getValue()));
        return this;
    }

    /**
     * sets the ID field.
     * @param ID  The value to assign to the ID field
     * @return    Builder interface for setting the name field
     */
    public CourseBuilderName ID(Long ID) throws InvalidValueException
    {
        if(ID != null) CourseIDImpl.edma_validate(ID);
        edma_value[0] = (ID == null ? null : (CourseIDImpl.edma_create(ID)));
        return this;
    }

    /**
     * sets the fieldID to null.
     * @return  Builder interface for setting the name field
     */
    public CourseBuilderName noID()
    {
        edma_value[0] = null;
        return this;
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      The created Course value
     */
    public Course name(Name name)
    {
        if(name == null) throw new NullPointerException("The field name in the Course ValueDomain may not be null");
        edma_value[1] = ((IValueInstance) name).edma_getValue();
        return new CourseImpl(CourseImpl.edma_create(edma_value));
    }

    /**
     * sets the name field.
     * @param name  The value to assign to the name field
     * @return      The created Course value
     */
    public Course name(String name) throws InvalidValueException
    {
        if(name != null) NameImpl.edma_validate(name);
        if(name == null) throw new NullPointerException("The field name in the Course ValueDomain may not be null");
        edma_value[1] = NameImpl.edma_create(name);
        return new CourseImpl(CourseImpl.edma_create(edma_value));
    }
}
