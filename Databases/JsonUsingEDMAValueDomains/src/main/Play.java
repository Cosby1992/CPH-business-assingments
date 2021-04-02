package main;

import main.generated.valuedomains.AnyArray;
import main.generated.valuedomains.AnyBool;
import main.generated.valuedomains.AnyInt;
import main.generated.valuedomains.AnyString;
import main.generated.valuedomains.JsonObject;
import main.generated.valuedomains.Key;
import main.generated.valuedomains.Member;
import main.generated.valuedomains.Pair;
import main.generated.valuedomains.Value;

/**
 * This class uses the defined Value Domains in Json.edma in 'edmasrc/'
 * to create a Json Object and then print it as a valid json string 
 * to the console
 */
public class Play {

    public static void main(String[] args) {

        /*
         * Using EDMA framework Value Domains, we will try to recreate the rules of the
         * JSON syntax (JSON abstract syntax tree).
         * 
         * Using our value domains (json.edma) we will try to recreate the JSON object
         * descriped below:
         * 
         * { "student": { "name": "John", "age": 34 }, "courses" : [ { "id": 1234,
         * "name": "Seahorse riding", "ects": 15 }, { "id": 4321, "name":
         * "Squid painting", "ects": 5 } ], "active": true }
         * 
         */

        // Defining student inner pairs
        Pair student1name = Pair.create().key("name").value(Value.create(AnyString.create("John")));
        Pair student1age = Pair.create().key("age").value(Value.create(AnyInt.create(35)));

        // Connecting pairs as members
        Member studentMember = Member.create().pair(student1name).member(Member.create().pair(student1age).noMember());

        // Making member into object
        JsonObject studentObject = JsonObject.create().member(studentMember);

        // Finished student pair of key and object
        Pair studentPair = Pair.create().key("student").value(Value.create(studentObject));

        // System.out.println(studentPair);

        // Creating course one pairs
        Pair course1id = Pair.create().key("id").value(Value.create(AnyInt.create(1234)));
        Pair course1name = Pair.create().key("name").value(Value.create(AnyString.create("Seahorse riding")));
        Pair course1ects = Pair.create().key("ects").value(Value.create(AnyInt.create(15)));

        // Creating course two pairs
        Pair course2id = Pair.create().key("id").value(Value.create(AnyInt.create(4321)));
        Pair course2name = Pair.create().key("name").value(Value.create(AnyString.create("Squid painting")));
        Pair course2ects = Pair.create().key("ects").value(Value.create(AnyInt.create(5)));

        // Connecting course one pairs as members
        Member courseOneMember = Member.create().pair(course1id)
                .member(Member.create().pair(course1name).member(Member.create().pair(course1ects).noMember()));

        // Connecting course two pairs as members
        Member courseTwoMember = Member.create().pair(course2id)
                .member(Member.create().pair(course2name).member(Member.create().pair(course2ects).noMember()));

        // Creating objects containing the members
        JsonObject courseOneJsonObject = JsonObject.create().member(courseOneMember);
        JsonObject courseTwoJsonObject = JsonObject.create().member(courseTwoMember);

        // Creating an array of the json objects
        AnyArray coursesArray = AnyArray.begin().add(Value.create(courseOneJsonObject))
                .add(Value.create(courseTwoJsonObject)).end();

        // Creating the finished courses pair with value being an array of two objects
        Pair coursesPair = Pair.create().key("courses").value(Value.create(coursesArray));

        // Creating the active pair (it doesn't need further manipulation as
        // it only consists of a key and a value (a "normal pair"))
        //Pair activePair = Pair.create().key("active").value(Value.create(AnyBool.create(true)));
        Pair activePair = Pair.create().key("active").value(Value.create(AnyString.create("value")));

        // Add all previous Pairs to a member object
        Member allMembers = Member.create().pair(studentPair)
                .member(Member.create().pair(coursesPair).member(Member.create().pair(activePair).noMember()));

        // Create an object containing all members (finished object)
        JsonObject objectWithAllMembers = JsonObject.create().member(allMembers);

        // Print the object to console using EDMA generated toString method on the
        // object
        // System.out.println(objectWithAllMembers);


        // Convert the Json Object to a valid Json string and print it to the console
        String validJsonString = jsonObjectToString(objectWithAllMembers);

        System.out.println(validJsonString);


        /* TESTING WITH MULTIDIMENTIONAL ARRAYS OF VARIOUS DATA TYPES (VALUE DOMAINS)
        // Defining student inner pairs
        Pair test1name = Pair.create().key("name").value(Value.create(AnyString.create("John")));
        Pair test1age = Pair.create().key("ages").value(Value.create(AnyInt.create(30)));

        // Connecting pairs as members
        Member testMember = Member.create().pair(test1name).member(Member.create().pair(test1age).noMember());

        // Making member into object
        JsonObject testObject = JsonObject.create().member(testMember);



        AnyArray agesArrayInnerOne = AnyArray.begin().add(Value.create(testObject))
                                            .add(Value.create(testObject))
                                            .add(Value.create(testObject))
                                            .add(Value.create(testObject))
                                            .add(Value.create(testObject))
                                            .end();

        AnyArray agesArrayInnerTwo = AnyArray.begin().add(Value.create(AnyString.create("string1")))
                                            .add(Value.create(AnyString.create("string2")))
                                            .add(Value.create(AnyString.create("string3")))
                                            .add(Value.create(AnyString.create("string4")))
                                            .add(Value.create(AnyString.create("string5")))
                                            .end();

        AnyArray agesArrayOuter = AnyArray.begin().add(Value.create(agesArrayInnerOne))
                                            .add(Value.create(agesArrayInnerTwo))
                                            .end();
        */

    }

    /**
     * This method takes a JsonObject (Value Domain defined in Json.edma)
     * and returns it as valid json string.
     * It used calls itself recursively if the object contains other objects
     * @param object JsonObject to print
     * @return A Json string representing the object as valid json
     */
    private static String jsonObjectToString(JsonObject object) {

        // Gets the member first in the object
        Member member = object.member();

        // Stringbuilder to hold the json string
        StringBuilder builder = new StringBuilder();

        // As we know an object is provided it always starts with a {
        builder.append('{');

        // While the "next" member is not null
        while (member != null) {

            // Append the key from the key value pair with a : after
            builder.append(member.pair().key() + ":");

            // If the value is an object
            if (member.pair().value().isJsonObject()) {

                // Recursively call this method with the nested json object
                String objectToInsertRecursive = jsonObjectToString(member.pair().value().asJsonObject());

                // put a , after the object
                builder.append(objectToInsertRecursive + ",");
                
            } else if (member.pair().value().isAnyArray()) { // If the value is an array

                // Handle array using private method (recursive if it is a multidimentional array)
                ifIsAnyArray(member.pair().value().asAnyArray(), builder);
                
            } else { // value is simple datatype (float, bool, int, string)

                // Get string from Value Domain
                String valueString = member.pair().value().toString();

                // Remove  start and trailing parenthesis from the string
                valueString = valueString.substring(1, valueString.length() - 1);

                // Split the Data type from the value
                String[] stringArray = valueString.split(",");

                // append the value to the complete string
                builder.append(stringArray[1]);

                // Append a comma unless it is the last value
                if(member.member() != null) builder.append(",");
            }

            // Go to next member in object
            member = member.member();
        }

        // When the loop is done, append the last }
        builder.append('}');

        // Return the valid json string
        return builder.toString();
    }

    /**
     * This method takes an AnyArray (Value Domain defined in Json.edma)
     * and appends a valid json string to an existing stringbuilder. 
     * @param array The array to convert to valid json string
     * @param builder Stringbuilder to append the json string
     */
    private static void ifIsAnyArray(AnyArray array, StringBuilder builder) {

        // An array starts with [
        builder.append("[");

        // iterate through the array
        for(int i = 0; i < array.size(); i++){

            // If the array is an object
            if(array.get(i).isJsonObject()) {
                
                // Call jsonObjectToString to convert nested json to a string 
                String objectToInsertRecursive = jsonObjectToString(array.get(i).asJsonObject());

                // Append the object string
                builder.append(objectToInsertRecursive);

            } else if (array.get(i).isAnyArray()){ // If it's a multi dimentional array

                // Call this method recursively to append the 
                // inner array to the string builder
                ifIsAnyArray(array.get(i).asAnyArray(), builder);

            } else { // value is simple datatype (float, bool, int, string)

                // Get the value as a Value Domain string
                String valueString = array.get(i).toString();

                // Get the value from the string
                valueString = valueString.substring(1, valueString.length() - 1);
                String[] stringArray = valueString.split(", ");

                // Append the value to the string
                builder.append(stringArray[1]);
            }

            // Check if trailing comma is nessesary
            if(i != array.size()-1) builder.append(",");
        }

        // Check if the first index of the array is an object
        // then append accordingly either ] or ],
        if(array.get(0).isJsonObject()) {
            builder.append("],");
        } else builder.append("]");

    }

}
