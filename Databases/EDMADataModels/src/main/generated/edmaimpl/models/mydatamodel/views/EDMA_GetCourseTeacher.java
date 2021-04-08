package main.generated.edmaimpl.models.mydatamodel.views;

import main.generated.edmaimpl.models.mydatamodel.MyDataModelVUImpl;
import main.usercode.models.mydatamodel.views.GetCourseTeacherUserImpl;
import org.abstractica.edma.runtime.implementations.common.AView;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IView;

/**
 * 
 */
public class EDMA_GetCourseTeacher extends AView implements IView
{
    private GetCourseTeacherUserImpl edma_userMethod;



    /**
     * Constructor
     * @param edma_userMethod  User provided method implementation
     */
    public EDMA_GetCourseTeacher(GetCourseTeacherUserImpl edma_userMethod)
    {
        super("getCourseTeacher");
        this.edma_userMethod = edma_userMethod;
    }

    /**
     * Execution of the view
     * @param edma_dm  Data model view interface
     */
    public void execute(IDataModelView edma_dm)
    {
        int e = edma_userMethod.execute(new MyDataModelVUImpl(edma_dm));
        switch(e)
        {
            case 0:
                edma_userMethod.setErrorCode(0, "OK");
                break;
            case 1:
                edma_userMethod.setErrorCode(1, "Course ID does not exist");
                break;
            default:
                throw new RuntimeException("Error in getCourseTeacher: Invalid error code: " + e);
        }
    }

    /**
     * Returns the user method
     * @return  The user method
     */
    public GetCourseTeacherUserImpl getUserMethod()
    {
        return edma_userMethod;
    }
}
