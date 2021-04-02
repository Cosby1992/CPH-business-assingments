package main;

import org.abstractica.edma.generator.EdmaGenerator;

public class Make {

    public static void main(String[] args) {
        String projectDir = "C:/code/cphbusiness/Databases/JsonUsingEDMAValueDomains";

        EdmaGenerator generator = new EdmaGenerator("JsonUsingEDMAValueDomains", projectDir + "/edmasrc", projectDir + "/src", "main");
        generator.make();
    }

}