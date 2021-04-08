package main.generated.edmaimpl.models.mydatamodel;

import java.io.IOException;
import main.generated.edmaimpl.models.mydatamodel.MyDataModelInstImpl;
import main.generated.mydatamodel.MyDataModelFactory;
import main.generated.mydatamodel.MyDataModelInstance;
import org.abstractica.edma.runtime.intf.IDataModelInstanceFactory;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class MyDataModelFactoryImpl implements MyDataModelFactory
{
    private IDataModelInstanceFactory edma_instanceFactory;



    /**
     * Constructor
     * @param edma_instanceFactory  Internal storage interface
     */
    public MyDataModelFactoryImpl(IDataModelInstanceFactory edma_instanceFactory)
    {
        this.edma_instanceFactory = edma_instanceFactory;
    }

    /**
     * Test the existence of an instance
     * @param name  The name of the instance to test the existence of
     * @return      
     */
    public boolean exists(String name) throws IOException
    {
        return edma_instanceFactory.exists(name);
    }

    /**
     * Create a new instance
     * @param edma_name  The name of the instance to create
     * @return           
     */
    public MyDataModelInstance newInstance(String edma_name) throws IOException
    {
        Object[] edma_initValues = new Object[0];
        return new MyDataModelInstImpl(edma_instanceFactory.newModelInstance(edma_name, edma_initValues));
    }

    /**
     * Get an instance from its name
     * @param name  The name of the instance to get
     * @return      
     */
    public MyDataModelInstance getInstance(String name) throws IOException
    {
        return new MyDataModelInstImpl(edma_instanceFactory.getModelInstance(name));
    }

    /**
     * Delete an instance
     * @param name  The name of the instance to delete
     * @return      <tt>true</tt> if the instance was deleted
     */
    public boolean deleteInstance(String name) throws IOException
    {
        return edma_instanceFactory.deleteModelInstance(name);
    }
}
