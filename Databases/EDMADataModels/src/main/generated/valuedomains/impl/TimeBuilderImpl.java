package main.generated.valuedomains.impl;

import main.generated.valuedomains.Hour;
import main.generated.valuedomains.Millisecond;
import main.generated.valuedomains.Minute;
import main.generated.valuedomains.Second;
import main.generated.valuedomains.Time;
import main.generated.valuedomains.Time.TimeBuilderHour;
import main.generated.valuedomains.Time.TimeBuilderMilliseconds;
import main.generated.valuedomains.Time.TimeBuilderMin;
import main.generated.valuedomains.Time.TimeBuilderSecond;
import main.generated.valuedomains.impl.HourImpl;
import main.generated.valuedomains.impl.MillisecondImpl;
import main.generated.valuedomains.impl.MinuteImpl;
import main.generated.valuedomains.impl.SecondImpl;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * 
 */
public class TimeBuilderImpl implements TimeBuilderHour, TimeBuilderMilliseconds, TimeBuilderMin, TimeBuilderSecond
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public TimeBuilderImpl()
    {
        edma_value = new Object[4];
    }

    /**
     * sets the hour field.
     * @param hour  The value to assign to the hour field
     * @return      Builder interface for setting the min field
     */
    public TimeBuilderMin hour(Hour hour)
    {
        if(hour == null) throw new NullPointerException("The field hour in the Time ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) hour).edma_getValue();
        return this;
    }

    /**
     * sets the hour field.
     * @param hour  The value to assign to the hour field
     * @return      Builder interface for setting the min field
     */
    public TimeBuilderMin hour(Integer hour) throws InvalidValueException
    {
        if(hour != null) HourImpl.edma_validate(hour);
        if(hour == null) throw new NullPointerException("The field hour in the Time ValueDomain may not be null");
        edma_value[0] = HourImpl.edma_create(hour);
        return this;
    }

    /**
     * sets the min field.
     * @param min  The value to assign to the min field
     * @return     Builder interface for setting the second field
     */
    public TimeBuilderSecond min(Minute min)
    {
        if(min == null) throw new NullPointerException("The field min in the Time ValueDomain may not be null");
        edma_value[1] = ((IValueInstance) min).edma_getValue();
        return this;
    }

    /**
     * sets the min field.
     * @param min  The value to assign to the min field
     * @return     Builder interface for setting the second field
     */
    public TimeBuilderSecond min(Integer min) throws InvalidValueException
    {
        if(min != null) MinuteImpl.edma_validate(min);
        if(min == null) throw new NullPointerException("The field min in the Time ValueDomain may not be null");
        edma_value[1] = MinuteImpl.edma_create(min);
        return this;
    }

    /**
     * sets the second field.
     * @param second  The value to assign to the second field
     * @return        Builder interface for setting the milliseconds field
     */
    public TimeBuilderMilliseconds second(Second second)
    {
        if(second == null) throw new NullPointerException("The field second in the Time ValueDomain may not be null");
        edma_value[2] = ((IValueInstance) second).edma_getValue();
        return this;
    }

    /**
     * sets the second field.
     * @param second  The value to assign to the second field
     * @return        Builder interface for setting the milliseconds field
     */
    public TimeBuilderMilliseconds second(Integer second) throws InvalidValueException
    {
        if(second != null) SecondImpl.edma_validate(second);
        if(second == null) throw new NullPointerException("The field second in the Time ValueDomain may not be null");
        edma_value[2] = SecondImpl.edma_create(second);
        return this;
    }

    /**
     * sets the milliseconds field.
     * @param milliseconds  The value to assign to the milliseconds field
     * @return              The created Time value
     */
    public Time milliseconds(Millisecond milliseconds)
    {
        if(milliseconds == null) throw new NullPointerException("The field milliseconds in the Time ValueDomain may not be null");
        edma_value[3] = ((IValueInstance) milliseconds).edma_getValue();
        return new TimeImpl(TimeImpl.edma_create(edma_value));
    }

    /**
     * sets the milliseconds field.
     * @param milliseconds  The value to assign to the milliseconds field
     * @return              The created Time value
     */
    public Time milliseconds(Integer milliseconds) throws InvalidValueException
    {
        if(milliseconds != null) MillisecondImpl.edma_validate(milliseconds);
        if(milliseconds == null) throw new NullPointerException("The field milliseconds in the Time ValueDomain may not be null");
        edma_value[3] = MillisecondImpl.edma_create(milliseconds);
        return new TimeImpl(TimeImpl.edma_create(edma_value));
    }
}
