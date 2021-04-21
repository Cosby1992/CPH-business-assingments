MATCH (b:CrimeType)-[r:REPPORTED]->(a:Location)
return b.type , collect(a),  count(*)
order by count(*) desc