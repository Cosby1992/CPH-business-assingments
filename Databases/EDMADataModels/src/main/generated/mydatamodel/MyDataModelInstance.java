package main.generated.mydatamodel;

import main.generated.mydatamodel.MyDataModel;

/**
 * This is the instance interface to MyDataModel instances. It can be used to
 * start and stop the instance and the API interface can be obtained
 */
public interface MyDataModelInstance
{

    /**
     * Used to start the instance, which enables the API
     */
    public void start();

    /**
     * Used to stop the instance, which disables the API
     */
    public void stop();

    /**
     * Used to test if the instance is running
     * @return  <tt>true</tt> if the instance is running otherwise
     *          <tt>false</tt>
     */
    public boolean isRunning();

    /**
     * Get access to the API for the MyDataModel instance
     * @return  The API interface for the MyDataModel instance
     */
    public MyDataModel getAPI();

}
