# Assignment A2 - Street Crimes Project 
**Subject:** Databases for Developers

## NEO4J - Our progression
1. We created 8 different location nodes based on the ```2021-02-hampshire-street.csv``` labeled "Location"
2. We created 6 different crime type nodes based on the ```2021-02-hampshire-street.csv``` labeled "CrimeType"
3. To create a relationsship between nodes we used the cypher in ```ConnectingNodes.cypher```
**Note:** same crime can happen in the same location

## All nodes
![Nodes](https://github.com/Cosby1992/CPH-business-assingments/tree/master/Databases/StreetCrime/fig/figure.PNG "Nodes")

## Common place for crimes
In order to find which location has the most crimes we used the cypher in ```LocationVMostCrimes.cypher```.
 
This resulted in "Supermarked" being the most common place for crimes with 3 counts of shoplifting and 1 case of Anti-social behaviour.

## Favorite crimes
When searching for the most common crime we used the cypher in ```MostCommonCrime.cypher```

The end result was "Anti-Social behaviour" being the most common amongst the crimes we had.
With occurences at 4 different locations.

