package main.generated.mydatamodel.remote;

import main.generated.mydatamodel.views.GetCourseStudentResult;
import main.generated.valuedomains.mydatamodel.PersonList;

/**
 * 
 */
public class RemoteGetCourseStudentResult implements GetCourseStudentResult
{
    private int edma_errorCode;
    private String edma_errorMsg;
    private String edma_errorDesc;
    private PersonList studentList;



    /**
     * Constructor
     * @param edma_errorCode  Error code
     * @param edma_errorMsg   Error message
     * @param edma_errorDesc  Error description
     * @param studentList     output parameter studentList
     */
    public RemoteGetCourseStudentResult(int edma_errorCode, String edma_errorMsg, String edma_errorDesc, PersonList studentList)
    {
        this.edma_errorCode = edma_errorCode;
        this.edma_errorMsg = edma_errorMsg;
        this.edma_errorDesc = edma_errorDesc;
        this.studentList = studentList;
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
     * get output parameter studentList
     * @return  The output parameter studentList
     */
    public PersonList getStudentList()
    {
        return studentList;
    }
}
