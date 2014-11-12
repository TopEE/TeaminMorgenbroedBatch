TeaminMorgenbroedBatch
======================
Backend-delen af en morgenbrødsapplikation.
Forudsætninger for at kunne afvikle koden:
1) At der er lavet en DB2-tabel vha. følgende:
  CREATE TABLE MORGENBROED("USER_ID" CHAR(3) not null primary key, 
                            "BESTILT" INTEGER not null,
                            "BETALT" INTEGER not null)
2) At der er lavet følgende folder-struktur i fil-systemet:
    C:\Temp\testFiler\arkiv
3) At der er lavet en komma-separeret fil med data svarende til tabellen MORGENBROED.
   Denne fil kunne f.eks. hedde morgenBroed.csv.
4) Der arbejdes på, at projektet skal benytte en hMailServer.

Batch-applikationen består af flere dele:
a) Chunk-processing af input-filen, morgenBroed.csv - og opdatering af MORGENBROED-tabellen.
b) En saldoBatchlet, som skriver saldobeløb ud for abonnenterne på morgenbrød.
c) Kopiering af .csv-filen til en arkiv-mappe (og tilføjelse af uge-postfix).
d) Mailflow, hvor der først sendes en info-mail ud. Dernæst en decider-klasse, som afgør, om
   abonnenternes gæld er stor nok til, at der skal sendes en inkasso-mail ud.

Bemærk, at der findes genstarts-faciliteter, hvis et job går ned.
Hvis f.eks. record-nummer 5 indeholder ugyldige data, så vil der blive lavet 3 opdateringer i databasen.
Det skyldes, at vi opererer med en chunk-size på 3. Dvs. record-nummer 4 vil ikke blive skrevet i databasen,
selvom det først er record-nummer 5, der er ugyldig.
Ved genstart vil record-nummer 4 samt de følgende records blive skrevet i databasen.
