package main.generated.mydatamodel.views;

import main.generated.valuedomains.mydatamodel.PersonList;
import org.abstractica.edma.runtime.intf.IResult;

/**
 * Access to the result of the method: getAllPersons
 */
public interface GetAllPersonsResult extends IResult
{

    /**
     * Returns the output personList:PersonList
     * @return  The output personList:PersonList
     */
    public PersonList getPersonList();

}
