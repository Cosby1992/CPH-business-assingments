MATCH (a:Location)<-[r:REPPORTED]-(b:CrimeType)
return a, Collect(b) , count (*)
order by count(*) desc