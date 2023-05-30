Biró Ferenc HR4VCG https://github.com/biroferenc075


Felállítottam a projektet, hogy használhassuk a Cucumber könyvtárat. Ehhez hozzá kellett adnom a Maven projekthez a függőségeket, és megfelelően beállítani azt. Mivel az eredeti projektünk szerkezete nem felelt meg a Java konvencióknak, ezért az egészet át kellett szerveznem.


Továbbá létrehoztam a BDD tesztek sémáját, maguknak a teszteknek a megírását a csapattársaimra bíztam.


Mivel ezelőtt sosem használtam se a Mavent, se a Cucumbert, kicsit több nehézséget okozott ez a feladat a kelleténél, viszont látva a tesztkörnyezet által kínált lehetőségeket, ki merem jelenteni, hogy a projekt javára vált.


Szabó Egon Róbert DEQGWW https://github.com/szaboegon

Megírtam a BDD feature-öket az alkalmazás legfontosabb funkcióira a Cucumber könyvtár segítségével. A Gherkin nyelvnek köszönhetően azok számára is könnyen olvasható a tesztesetek specifikációja, akik nem jártasak a programozási nyelvekben.

A feature-ök definiálása után mindegyikhez elkészítettem a step definitions fájlt, amelyekben minden függvény a specifikáció egy állítását valósítja meg. A tesztelésben hasznos volt továbbá az AssertJ könyvtár is, ez biztosítja az assertion-ök olvashatóságát és könnyű egymás után láncolását.

Igaz, hogy ideális esetben a BDD tesztek a specifikációs fázisban kerülnek megírásra, úgy érzem, mégis sikerült javítani a kód minőségén. Ha valaha nagyobb refaktorálásra, vagy új funkciók hozzáadására kerül a sor, a tesztek segítségével biztosítani lehet, hogy az eddig működő feature-ök ne romoljanak el.

Néhány részletes teszteset:

![image](https://github.com/BME-MIT-IET/iet-hf-2023-koporscho/assets/100433458/b03c89c8-94fe-4c9e-a1b5-08f87c9a4c8d)

![image](https://github.com/BME-MIT-IET/iet-hf-2023-koporscho/assets/100433458/53ba8123-6b0f-4e25-98ae-72bcc7d1a97c)
