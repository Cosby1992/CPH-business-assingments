package main.generated.mydatamodel.remote;

import main.generated.mydatamodel.actions.CreateCourseResult;
import main.generated.valuedomains.mydatamodel.CourseID;

/**
 * 
 */
public class RemoteCreateCourseResult implements CreateCourseResult
{
    private int edma_errorCode;
    private String edma_errorMsg;
    private String edma_errorDesc;
    private CourseID id;



    /**
     * Constructor
     * @param edma_errorCode  Error code
     * @param edma_errorMsg   Error message
     * @param edma_errorDesc  Error description
     * @param id              output parameter id
     */
    public RemoteCreateCourseResult(int edma_errorCode, String edma_errorMsg, String edma_errorDesc, CourseID id)
    {
        this.edma_errorCode = edma_errorCode;
        this.edma_errorMsg = edma_errorMsg;
        this.edma_errorDesc = edma_errorDesc;
        this.id = id;
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
     * get output parameter id
     * @return  The output parameter id
     */
    public CourseID getId()
    {
        return id;
    }
}
