package main.generated.edmaimpl.models.mydatamodel.actions;

import main.generated.edmaimpl.models.mydatamodel.MyDataModelVUImpl;
import main.usercode.models.mydatamodel.actions.AssignStudentToCourseUserImpl;
import org.abstractica.edma.runtime.implementations.common.AAction;
import org.abstractica.edma.runtime.intf.IAction;
import org.abstractica.edma.runtime.intf.IDataModelUpdate;

/**
 * 
 */
public class EDMA_AssignStudentToCourse extends AAction implements IAction
{
    private AssignStudentToCourseUserImpl edma_userMethod;



    /**
     * Constructor
     * @param edma_userMethod  User provided method implementation
     */
    public EDMA_AssignStudentToCourse(AssignStudentToCourseUserImpl edma_userMethod)
    {
        super("assignStudentToCourse");
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
                edma_userMethod.setErrorCode(1, "Student ID does not exist");
                break;
            case 2:
                edma_userMethod.setErrorCode(2, "Course ID does not exist");
                break;
            case 3:
                edma_userMethod.setErrorCode(3, "Student is already enrolled in course");
                break;
            default:
                throw new RuntimeException("Error in assignStudentToCourse: Invalid error code: " + e);
        }
        return (e == 0);
    }

    /**
     * Returns the user method
     * @return  The user method
     */
    public AssignStudentToCourseUserImpl getUserMethod()
    {
        return edma_userMethod;
    }
}
