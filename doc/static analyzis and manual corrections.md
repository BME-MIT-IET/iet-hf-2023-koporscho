Ebben a jegyben a SonarCloud statikus kódanalízisét próbáltam ki és manuálisan kijavítottam.

Elsősorban konfiguráltam SonarCloudod a repositoryn, itt lefuttattam az analízist, majd
utána manuálisan ki is javítottam a bugokat és a major, critical és pár minor code smellt amiket talált.

Bugok:
"Use try-with-resources or close this "Scanner" in a "finally" clause." in GameController.java
"Save and re-use this "Random"". in StatusEffect.java
"Use try-with-resources or close this "BufferedReader" in a "finally" clause." in Prototype.java

Major code smellek:
GUI.java
Add the "@Override" annotation above this method signature. A leszármazott osztálynak overrideolnia kell a bizonyos függvényt.
Remove this useless assignment to local variable "c". Felesleges változó, egy hívással megoldható dolgok
Change this instance-reference to a static reference.
Iterate over the "entrySet" instead of the "keySet". Ott ahol szügség van a key, meg valuera is entrysetet alkalmazzunk, ne keysetet és getterrel kapjuk meg a valuet.
This block of commented-out lines of code should be removed. Felesleges, kikommentelt kód vagy esetleg hasznos kommentelt kód.
--
SaveLoader.java
Add a private constructor to hide the implicit public one. Ez egy utility osztály csupa statikus változókkal és függvényekkel, kell egy konstruktor ami illegalstate hibát dob azzal az üzenettel, hogy ez egy utility class.
--
Agent.java
Extract the assignment out of this expression. Olvashatóbb a kód, ha előtte elvégezzük az adott változón a változtatásokat, majd utána értékelünk vele ki dolgokat.
--
BearVisitor.java
Remove this unused "sourceVirologist" private field. A sourceVirologist változó semmit sem csinált, kitöröltem.
Rename "fields" which hides the field declared at line 22. Egy változót kétszer deklaráltunk, csökkentettem egyszre a számát.
--

Critical codesmellek:
Make "gcView" transient or serializable. -> Serializable osztályokban a változóknak is serializálhatónak vagy transiensnek kell lennie független attól, hogy az szerializálva lesz-e valaha.
Use static access with "javax.swing.WindowConstants" for "EXIT_ON_CLOSE". Az ősosztály implementációját hívjuk meg, ha létezik rá.
Add a default case to this switch. Default állapotot kellett adnom switchhez.
Refactor this method to reduce its Cognitive Complexity from 25 to the 15 allowed. Túl nagy a kognitíc komplexitása egy függvénynek, szét kellett darabolni.
Define a constant instead of duplicating this literal "0. Cancel" 6 times. Constanst kellett létrehozni, egy többször felhasznált sztring helyett.
Merge the previous cases into this one using comma-separated label. Ugyanazokat a kimenetelű eseteket egybe írtam vesszővel elválasztva.

False positive code smellek:
Replace this use of System.out or System.err by a logger. Túl nagy változtatás lenne a programkódban ahhoz, hogy ezt megváltoztatjuk.
Make the enclosing method "static" or remove this set. Ezeket a változókat mindenhol be kell állítani.

Számomra tanulságos volt a Sonarral való feladat, de volt pár szabály amit túlságosan is szigorúnak találtam. Összességében jó vele dolgozni.
