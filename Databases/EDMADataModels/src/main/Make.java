package main;

import org.abstractica.edma.generator.EdmaGenerator;

public class Make {

    public static void main(String[] args) {
        String projectDir = "C:/code/cphbusiness/Databases/EDMADataModels";

        EdmaGenerator generator = new EdmaGenerator("EDMADataModels", projectDir + "/edmasrc", projectDir + "/src", "main");
        generator.make();
    }

}