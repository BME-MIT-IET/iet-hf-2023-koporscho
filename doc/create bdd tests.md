Szabó Egon Róbert DEQGWW https://github.com/szaboegon

Megírtam a BDD feature-öket az alkalmazás legfontosabb funkcióira a Cucumber könyvtár segítségével. A Gherkin nyelvnek köszönhetően azok számára is könnyen olvasható a tesztesetek specifikációja, akik nem jártasak a programozási nyelvekben.

A feature-ök definiálása után mindegyikhez elkészítettem a step definitions fájlt, amelyekben minden függvény a specifikáció egy állítását valósítja meg. A tesztelésben hasznos volt továbbá az AssertJ könyvtár is, ez biztosítja az assertion-ök olvashatóságát és könnyű egymás után láncolását.

Igaz, hogy ideális esetben a BDD tesztek a specifikációs fázisban kerülnek megírásra, úgy érzem, mégis sikerült javítani a kód minőségén. Ha valaha nagyobb refaktorálásra, vagy új funkciók hozzáadására kerül a sor, a tesztek segítségével biztosítani lehet, hogy az eddig működő feature-ök ne romoljanak el.
