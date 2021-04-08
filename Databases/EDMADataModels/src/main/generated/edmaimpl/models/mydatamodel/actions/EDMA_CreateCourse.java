package main.generated.edmaimpl.models.mydatamodel.actions;

import main.generated.edmaimpl.models.mydatamodel.MyDataModelVUImpl;
import main.usercode.models.mydatamodel.actions.CreateCourseUserImpl;
import org.abstractica.edma.runtime.implementations.common.AAction;
import org.abstractica.edma.runtime.intf.IAction;
import org.abstractica.edma.runtime.intf.IDataModelUpdate;

/**
 * 
 */
public class EDMA_CreateCourse extends AAction implements IAction
{
    private CreateCourseUserImpl edma_userMethod;



    /**
     * Constructor
     * @param edma_userMethod  User provided method implementation
     */
    public EDMA_CreateCourse(CreateCourseUserImpl edma_userMethod)
    {
        super("createCourse");
        this.edma_userMethod = edma_userMethod;
    }

    /**
     * Execution of the action
     * @param edma_dm  Data model update interface
     * @return         Return <tt>true</tt> to commit or <tt>false</tt> to
     *                 rollback
     */
    public boolean execute(IDataModelUpdate edma_dm)
    {
        int e = edma_userMethod.execute(new MyDataModelVUImpl(edma_dm));
        switch(e)
        {
            case 0:
                edma_userMethod.setErrorCode(0, "OK");
                break;
            case 1:
                edma_userMethod.setErrorCode(1, "Name already exists");
                break;
            default:
                throw new RuntimeException("Error in createCourse: Invalid error code: " + e);
        }
        if(e == 0)
        {
            if(edma_userMethod.getId() == null)
            {
                throw new RuntimeException("Error in createCourse: Output parameter id is null");
            }
        }
        return (e == 0);
    }

    /**
     * Returns the user method
     * @return  The user method
     */
    public CreateCourseUserImpl getUserMethod()
    {
        return edma_userMethod;
    }
}
