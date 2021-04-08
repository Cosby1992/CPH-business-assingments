package main.generated.mydatamodel.remote;

import main.generated.mydatamodel.views.GetAllPersonsResult;
import main.generated.valuedomains.mydatamodel.PersonList;

/**
 * 
 */
public class RemoteGetAllPersonsResult implements GetAllPersonsResult
{
    private int edma_errorCode;
    private String edma_errorMsg;
    private String edma_errorDesc;
    private PersonList personList;



    /**
     * Constructor
     * @param edma_errorCode  Error code
     * @param edma_errorMsg   Error message
     * @param edma_errorDesc  Error description
     * @param personList      output parameter personList
     */
    public RemoteGetAllPersonsResult(int edma_errorCode, String edma_errorMsg, String edma_errorDesc, PersonList personList)
    {
        this.edma_errorCode = edma_errorCode;
        this.edma_errorMsg = edma_errorMsg;
        this.edma_errorDesc = edma_errorDesc;
        this.personList = personList;
    }

    /**
     * Get the error code
     * @return  
     */
    public int errorCode()
    {
        return edma_errorCode;
    }

    /**
     * Get the error message
     * @return  
     */
    public String errorMessage()
    {
        return edma_errorMsg;
    }

    /**
     * Get the error description
     * @return  
     */
    public String errorDescription()
    {
        return edma_errorDesc;
    }

    /**
     * get output parameter personList
     * @return  The output parameter personList
     */
    public PersonList getPersonList()
    {
        return personList;
    }
}
