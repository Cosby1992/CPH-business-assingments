package main.generated.valuedomains.impl;

import main.generated.valuedomains.Date;
import main.generated.valuedomains.DateAndTime;
import main.generated.valuedomains.DateAndTime.DateAndTimeBuilderDate;
import main.generated.valuedomains.DateAndTime.DateAndTimeBuilderTime;
import main.generated.valuedomains.Time;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class DateAndTimeBuilderImpl implements DateAndTimeBuilderDate, DateAndTimeBuilderTime
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public DateAndTimeBuilderImpl()
    {
        edma_value = new Object[2];
    }

    /**
     * sets the date field.
     * @param date  The value to assign to the date field
     * @return      Builder interface for setting the time field
     */
    public DateAndTimeBuilderTime date(Date date)
    {
        if(date == null) throw new NullPointerException("The field date in the DateAndTime ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) date).edma_getValue();
        return this;
    }

    /**
     * sets the time field.
     * @param time  The value to assign to the time field
     * @return      The created DateAndTime value
     */
    public DateAndTime time(Time time)
    {
        if(time == null) throw new NullPointerException("The field time in the DateAndTime ValueDomain may not be null");
        edma_value[1] = ((IValueInstance) time).edma_getValue();
        return new DateAndTimeImpl(DateAndTimeImpl.edma_create(edma_value));
    }
}
