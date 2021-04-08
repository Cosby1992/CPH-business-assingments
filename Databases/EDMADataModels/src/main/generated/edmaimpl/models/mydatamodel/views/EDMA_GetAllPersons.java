package main.generated.edmaimpl.models.mydatamodel.views;

import main.generated.edmaimpl.models.mydatamodel.MyDataModelVUImpl;
import main.usercode.models.mydatamodel.views.GetAllPersonsUserImpl;
import org.abstractica.edma.runtime.implementations.common.AView;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IView;

/**
 * 
 */
public class EDMA_GetAllPersons extends AView implements IView
{
    private GetAllPersonsUserImpl edma_userMethod;



    /**
     * Constructor
     * @param edma_userMethod  User provided method implementation
     */
    public EDMA_GetAllPersons(GetAllPersonsUserImpl edma_userMethod)
    {
        super("getAllPersons");
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
            default:
                throw new RuntimeException("Error in getAllPersons: Invalid error code: " + e);
        }
        if(e == 0)
        {
            if(edma_userMethod.getPersonList() == null)
            {
                throw new RuntimeException("Error in getAllPersons: Output parameter personList is null");
            }
        }
    }

    /**
     * Returns the user method
     * @return  The user method
     */
    public GetAllPersonsUserImpl getUserMethod()
    {
        return edma_userMethod;
    }
}
