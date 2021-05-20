# Twitter-clone

## To run
1. Download this repo. If you only want this part of the repo and not the entire repo, use this link https://minhaskamal.github.io/DownGit/#/home?url=https://github.com/Cosby1992/CPH-business-assingments/tree/master/Databases/twitter-clone.

2. Navigate to root of the project

3. Run the tests


## Task 1
Server is created by Java code (in docker container). Remember to pull redis, alpine:3.5 and testcontainers/ryuk:0.3.0 images from docker before running the code.
Client is emulated trough tests.

## Task 2
The two classes ```PostManagementImpl``` and ```UserManagementImpl``` has been implemented. They are located in ```src\main\java\dk\cphbusiness\mrv\twitterclone\impl\```. Run the test from ```src\test\java\dk\cphbusiness\mrv\twitterclone``` to see that they pass.

### Changes
1. Added dependencies to pom xml: 
    ```
    <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.6.2</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.6.2</version>
    </dependency>
    ```
        

## Task 3
We have chosen a simple redis DB setup. 

### User Storage
|Key                                |Value                 |
|-----------------------------------|----------------------|
|user:\<username\>                  |\<username\>          | 
|user:\<username\>:firstname        |\<firstname\>         | 
|user:\<username\>:lastname         |\<lastname\>          | 
|user:\<username\>:password         |\<password\>          | 
|user:\<username\>:birthday         |\<birthday\>          | 
|user:\<username\>:following        |List \<username\>     | 
|user:\<username\>:followers        |List \<username\>     | 
|user:\<username\>:numFollowing     |\<numFollowing\>      | 
|user:\<username\>:numFollowers     |\<numFollowers\>      | 

### Post Storage
|Key                                |Value                    |
|-----------------------------------|-------------------------|
|post:\<username\>:\<timestamp\>    |\<message\>              | 
|post:\<username\>:posttime         |Sorted Set \<timestamp\> |        | 
