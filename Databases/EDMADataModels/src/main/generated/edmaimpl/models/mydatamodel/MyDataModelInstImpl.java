package main.generated.edmaimpl.models.mydatamodel;

import main.generated.mydatamodel.MyDataModel;
import main.generated.mydatamodel.MyDataModelInstance;
import org.abstractica.edma.runtime.intf.IDataModelInstance;

/**
 * 
 */
public class MyDataModelInstImpl implements MyDataModelInstance
{
    private MyDataModelAPIImpl api;



    /**
     * Constructor
     * @param edma_dmi  The data model instance
     */
    public MyDataModelInstImpl(IDataModelInstance edma_dmi)
    {
        this.api = new MyDataModelAPIImpl(edma_dmi);
    }

    /**
     * Used to start the instance, which enables the API
     */
    public void start()
    {
        api.edma_getDMI().start();
    }

    /**
     * Used to stop the instance, which disables the API
     */
    public void stop()
    {
        api.edma_getDMI().stop();
    }

    /**
     * Used to test if the instance is running
     * @return  <tt>true</tt> if the instance is running otherwise
     *          <tt>false</tt>
     */
    public boolean isRunning()
    {
        return api.edma_getDMI().isRunning();
    }

    /**
     * Get access to the API for the MyDataModel instance
     * @return  The API interface for the MyDataModel instance
     */
    public MyDataModel getAPI()
    {
        return api;
    }
}
