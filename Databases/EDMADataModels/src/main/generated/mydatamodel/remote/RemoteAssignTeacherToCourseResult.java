package main.generated.mydatamodel.remote;

import main.generated.mydatamodel.actions.AssignTeacherToCourseResult;

/**
 * 
 */
public class RemoteAssignTeacherToCourseResult implements AssignTeacherToCourseResult
{
    private int edma_errorCode;
    private String edma_errorMsg;
    private String edma_errorDesc;



    /**
     * Constructor
     * @param edma_errorCode  Error code
     * @param edma_errorMsg   Error message
     * @param edma_errorDesc  Error description
     */
    public RemoteAssignTeacherToCourseResult(int edma_errorCode, String edma_errorMsg, String edma_errorDesc)
    {
        this.edma_errorCode = edma_errorCode;
        this.edma_errorMsg = edma_errorMsg;
        this.edma_errorDesc = edma_errorDesc;
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
}
