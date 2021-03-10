# Assignment #1 - Relational Databases 
**Subject:** Databases for Developers

## To run
1. Make sure you have [node.js and npm](https://nodejs.org/en/ "Download node") installed
2. Clone this repository
3. Navigate to root folder and run ```npm install``` in CLI
4. Start or Have access to a live postgresql server
5. Run the scripts from ```db_setup``` in a clean database (the scripts are reentrant)
5. Create a ```.env``` file and fill it as instructed in the ```example.env``` file
6. Run ```app.js``` with CLI command: ```node app``` - from root folder

**OBS:** if you don't want to download the entire repository, you can get just this folder as a zip-file from this downGit link: [Download folder as zip from DownGit](https://downgit.github.io/#/home?url=https://github.com/Cosby1992/CPH-business-assingments.git/trunk/Databases/Relational%20Database%20Assignment%20Pets "Download this folder as zip")

## Sprogvalg
Vi har valgt at benytte Javascript til at løse denne opgave. Dette valg er baseret på at det kunne være sjovt at arbejde med Javascript, semi objektorienteret. Valget er altså IKKE baseret på at vi synes Javascript egnede sig bedst til opgaven. 
Det har været sjovt, men der opstår meget unødvendig implementering når vi benytter Javascript i en objektorienteret facon. Blandt andet modtager vi responset fra databasen som et nydeligt Json objekt. Men tvinger det nu over i selv beskrevne klasser. Vi kunne nemt have arbejdet med Json objekterne som de var, og det er vidst også det mest normale i Javascript. Det har ikke sine stærke sider i OOP.

## Database relations stragegy
Herunder har vi analyseret nogle pros and cons for de tre implementeringsstrategier der er specificeret i opgaven. Derefter præsenteres et ER-diagram over vores database design.

**Joint Table Strategy:** <br>
**PROS:**
<br>Medfører god abstraktion og afspejler klassernes opbygning i koden
<br>Næsten Ingen spildplads og ingen null værdier
<br>Mulighed for at tilføje NOT NULL attribut på tvungne kolonner (sikkerhed for at dataen er til stede)

**CONS:** 
<br>Mere komplekse queries
<br>Tvang af brug af JOIN som reducere db performance
<br>Ny type vil kræve oprettelse af ny tabel

**Table-per-class Strategy:** <br>
**PROS:**
<br>Hurtig selection queries på en type (uden joins)
<br>Nemt overblik over dataen. 

**CONS:**
<br>Mere komplekse queries til at få ALLE typer (kræver joins)
<br>Samme kolonner i flere tabeller. Vil man eksempelvis opdatere age til at være et timestamp i stedet for en int. Så vil ændring skulle implementeres i flere forskellige tabeller. (Dårlig maintainability)
<br>Shared primary key increment for flere tabeller øger kompleksiteten. 

**Single-table Strategy:** <br>
**PROS:** 
<br>Hurtig selection queries (uden joins)
<br>Hurtig Insert queries og hurtige tilføjelse af nye typer nedarvet fra parent
<br>Hurtig implementering

**CONS:**
<br>Der vil forekomme spildplads (til null værdier)
<br>Ved queries kan komme mange “ikke brugbare” kolonner
<br>Det er ikke muligt at tildele NOT NULL til krævede værdier til typer
<br>Kan hurtigt blive rodet (mange objekter i samme tabel)
<br>ændring af én type vil ændre ALLE typer i tabellen

### Vores valg
Vi har tidligere i undervisningen implementeret Joint Table Strategy på netop dette domæne. 
Derfor har vi valgt Single-Table implementering. Det vi gjort med en antagelse af at der ikke vil forekomme “big data”. Vi Antager et forholdsvist småt datasæt. 
Derfor ikke så vigtigt med den spildte plads til null-værdier. 

Vi holder fokus på nem implementering og hurtige selection queries. 

Havde der været oplyst om store datamængder, så havde vi nok valgt Joint Table Strategy for at have fokus på overblik og pladsbesparelse.

## ER Diagram
![ER diagram](https://github.com/Cosby1992/CPH-business-assingments/blob/master/Databases/Relational%20Database%20Assignment%20Pets/db_setup/er-diagram.PNG "ER diagram")

## Filbeskrivelse
### **Mappestruktur:**
- classes
    - Cat.js
    - Dog.js
    - Pet.js
- db_setup
    er-diagram.PNG
    Relational Databases_postgres_create.sql
    Seed_db.sql
- app.js
- database.js
- example.env
- package-lock.json
- README.md

### **Classes**
I classes mappen findes klasserne Cat, Dog og Pet som beskrevet i opgaven. Cat og Dog nedarver fra Pet. Der er ikke gjort brug af interfaces, da Javascript ikke understøtter interfaces.

### **db_setup**
Indeholder to sql filer. 
```Relational Databases_postgres_create.sql``` kør dette script i din postgres database for at skabe en database der afspejler ER-diagrammet tidligere i denne README. 
```Seed_db.sql``` kør dette script i din postgres database for at fylde data i databasen skabt med ```Relational Databases_postgres_create.sql```

### **app.js**
Dette er "programmets" start-fil. Den indsætter fire Pets i databasen og kører en metode til at læse alle kæledyr og udskriver dem i konsollen.

### **database.js**
Denne fil laver connection til databasen og indeholder metoder til at læse og skrive til databasen.

### **example.env**
Indeholder information om hvordan .env filen der skal laves i rod-mappen skal opbygges. Det er en guide til indtastning af DB info.

### **package-lock.json**
Indeholder information om hvilke npm packages der er benyttet i projektet. Kør ```npm install``` i CLI i rod-mappen for at installere dependencies.

## Kodebeskrivelse
Kodebeskrivelse kan findes ved at klikke ind i de individuelle filer og læse kommentarerne der. Brug eventuelt afsnittet om mappestruktur som "kort" til at finde rundt ;)
