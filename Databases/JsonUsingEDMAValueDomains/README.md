# Assignment 3 
## Task 1 
Model the JSON abstract syntax tree using ValueDomains (hint: can be done using around 8 
ValueDomains).
## Task 2
Create a toString method for printing an instance of your JSON abstract syntax tree as valid Json

## Solution
The solution is well descriped in the comments of the ```Play.java``` class. The Json we are replicating in this example is defined as in the image below: 

![Image of the Json being replicated](https://github.com/Cosby1992/CPH-business-assingments/blob/master/Databases/JsonUsingEDMAValueDomains/assignment_and_assets/json.PNG)

We could not find any way to override to toString method generated by the EDMA framework, therefore we have placed the methods to handle this in the ```Play.java``` class as static methods

## To run
1. Clone this repo or download only this folder by following this link: https://minhaskamal.github.io/DownGit/#/home?url=https://github.com/Cosby1992/CPH-business-assingments/tree/master/Databases/JsonUsingEDMAValueDomains

2. Run the Play class in the src/main folder

3. Expected output: {"student":{"name": "John","age": 35},"courses":[{"id": 1234,"name": "Seahorse riding","ects": 15},{"id": 4321,"name": "Squid painting","ects": 5}],"active": "value"}

4. You can test if it is a valid Json format using this online platform: https://jsonlint.com/

## Enviroment
Key | Value
------------ | -------------
Language | Java
Java version | compiled with java 15
Frameworks | EDMA: https://github.com/tgrundtvig/EDMA

## Roadmap
1. In ```/edmasrc``` you find ```json.edma``` witch contains the code descriping the Value Domains (EDMA)
2. ```/lib``` contains the external libraries as jar files
3. ```/src/main``` contains the EDMA generated files as well as ```Make.java``` and ```Play.java```
4. ```Make.java``` contains the code to make EDMA generate the Value Domain classes and constraints
5. ```Play.java``` contains the code to build a Json object using the value domains and then print it in the console

## Troubleshooting
1. This project was made in VS Code, if you are using another IDE, you maybe have to add the external libraries to the project manually in your IDE, read your IDE's documentation to find out how to do this in your IDE. 

2. Also you might have to define the root folder in your IDE, again read your IDE's documentation to find out how to do this.


