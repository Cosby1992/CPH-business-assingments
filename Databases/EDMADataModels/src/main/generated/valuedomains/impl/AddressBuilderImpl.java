package main.generated.valuedomains.impl;

import main.generated.valuedomains.Address;
import main.generated.valuedomains.Address.AddressBuilderCity;
import main.generated.valuedomains.Address.AddressBuilderLine1;
import main.generated.valuedomains.Address.AddressBuilderLine2;
import main.generated.valuedomains.Address.AddressBuilderZipCode;
import main.generated.valuedomains.AddressLine;
import main.generated.valuedomains.City;
import main.generated.valuedomains.ZipCode;
import main.generated.valuedomains.impl.AddressLineImpl;
import main.generated.valuedomains.impl.CityImpl;
import main.generated.valuedomains.impl.ZipCodeImpl;
import org.abstractica.edma.valuedomains.IValueInstance;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;

/**
 * 
 */
public class AddressBuilderImpl implements AddressBuilderCity, AddressBuilderLine1, AddressBuilderLine2, AddressBuilderZipCode
{
    private Object[] edma_value;



    /**
     * Constructor
     */
    public AddressBuilderImpl()
    {
        edma_value = new Object[4];
    }

    /**
     * sets the line1 field.
     * @param line1  The value to assign to the line1 field
     * @return       Builder interface for setting the line2 field
     */
    public AddressBuilderLine2 line1(AddressLine line1)
    {
        if(line1 == null) throw new NullPointerException("The field line1 in the Address ValueDomain may not be null");
        edma_value[0] = ((IValueInstance) line1).edma_getValue();
        return this;
    }

    /**
     * sets the line1 field.
     * @param line1  The value to assign to the line1 field
     * @return       Builder interface for setting the line2 field
     */
    public AddressBuilderLine2 line1(String line1) throws InvalidValueException
    {
        if(line1 != null) AddressLineImpl.edma_validate(line1);
        if(line1 == null) throw new NullPointerException("The field line1 in the Address ValueDomain may not be null");
        edma_value[0] = AddressLineImpl.edma_create(line1);
        return this;
    }

    /**
     * sets the line2 field.
     * @param line2  The value to assign to the line2 field
     * @return       Builder interface for setting the city field
     */
    public AddressBuilderCity line2(AddressLine line2)
    {
        edma_value[1] = (line2 == null ? null : (((IValueInstance) line2).edma_getValue()));
        return this;
    }

    /**
     * sets the line2 field.
     * @param line2  The value to assign to the line2 field
     * @return       Builder interface for setting the city field
     */
    public AddressBuilderCity line2(String line2) throws InvalidValueException
    {
        if(line2 != null) AddressLineImpl.edma_validate(line2);
        edma_value[1] = (line2 == null ? null : (AddressLineImpl.edma_create(line2)));
        return this;
    }

    /**
     * sets the fieldline2 to null.
     * @return  Builder interface for setting the city field
     */
    public AddressBuilderCity noLine2()
    {
        edma_value[1] = null;
        return this;
    }

    /**
     * sets the city field.
     * @param city  The value to assign to the city field
     * @return      Builder interface for setting the zipCode field
     */
    public AddressBuilderZipCode city(City city)
    {
        if(city == null) throw new NullPointerException("The field city in the Address ValueDomain may not be null");
        edma_value[2] = ((IValueInstance) city).edma_getValue();
        return this;
    }

    /**
     * sets the city field.
     * @param city  The value to assign to the city field
     * @return      Builder interface for setting the zipCode field
     */
    public AddressBuilderZipCode city(String city) throws InvalidValueException
    {
        if(city != null) CityImpl.edma_validate(city);
        if(city == null) throw new NullPointerException("The field city in the Address ValueDomain may not be null");
        edma_value[2] = CityImpl.edma_create(city);
        return this;
    }

    /**
     * sets the zipCode field.
     * @param zipCode  The value to assign to the zipCode field
     * @return         The created Address value
     */
    public Address zipCode(ZipCode zipCode)
    {
        if(zipCode == null) throw new NullPointerException("The field zipCode in the Address ValueDomain may not be null");
        edma_value[3] = ((IValueInstance) zipCode).edma_getValue();
        return new AddressImpl(AddressImpl.edma_create(edma_value));
    }

    /**
     * sets the zipCode field.
     * @param zipCode  The value to assign to the zipCode field
     * @return         The created Address value
     */
    public Address zipCode(Integer zipCode) throws InvalidValueException
    {
        if(zipCode != null) ZipCodeImpl.edma_validate(zipCode);
        if(zipCode == null) throw new NullPointerException("The field zipCode in the Address ValueDomain may not be null");
        edma_value[3] = ZipCodeImpl.edma_create(zipCode);
        return new AddressImpl(AddressImpl.edma_create(edma_value));
    }
}
