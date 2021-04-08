package main;

import main.generated.EDMADataModels;
import main.generated.mydatamodel.MyDataModel;
import main.generated.mydatamodel.MyDataModelFactory;
import main.generated.mydatamodel.MyDataModelInstance;
import main.generated.mydatamodel.test.MyDataModelTest;

import java.io.IOException;

import org.abstractica.edma.runtime.implementations.common.collectionfactory.java.JavaCollectionFactory;
import org.abstractica.edma.runtime.implementations.mem.RuntimeFactory;
import org.abstractica.edma.valuedomains.userinput.SimpleTerminal;

/**
 * This class uses the defined Value Domains in Json.edma in 'edmasrc/'
 * to create a Json Object and then print it as a valid json string 
 * to the console
 */
public class Play {

    public static void main(String[] args) throws IOException {

        EDMADataModels edma_runtime = new EDMADataModels(new RuntimeFactory("C:/code/cphbusiness/Databases/EDMADataModels/edma_out", new JavaCollectionFactory()));

        MyDataModelFactory mdmf = edma_runtime.getMyDataModelFactory();
        MyDataModelInstance instance = null;

        if(mdmf.exists("MyInstance")) {
            System.out.println("Getting existing instance...");
            instance = mdmf.getInstance("MyInstance");
        } else {
            System.out.println("Creating instance...");
            instance = mdmf.newInstance("MyInstance");
        }

        instance.start();
        
        MyDataModelTest test = new MyDataModelTest(instance.getAPI(), new SimpleTerminal());
        test.start();
        instance.stop();


    }

}
