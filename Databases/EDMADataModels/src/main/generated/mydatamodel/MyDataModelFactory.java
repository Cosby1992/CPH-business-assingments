package main.generated.mydatamodel;

import java.io.IOException;
import main.generated.mydatamodel.MyDataModelInstance;

/**
 * Instance factory for MyDataModel
 */
public interface MyDataModelFactory
{

    /**
     * Test the existence of an instance
     * @param name  The name of the instance to test the existence of
     * @return      
     */
    public boolean exists(String name) throws IOException;

    /**
     * Create a new instance
     * @param edma_name  The name of the instance to create
     * @return           
     */
    public MyDataModelInstance newInstance(String edma_name) throws IOException;

    /**
     * Get an instance from its name
     * @param name  The name of the instance to get
     * @return      
     */
    public MyDataModelInstance getInstance(String name) throws IOException;

    /**
     * Delete an instance
     * @param name  The name of the instance to delete
     * @return      <tt>true</tt> if the instance was deleted
     */
    public boolean deleteInstance(String name) throws IOException;

}
