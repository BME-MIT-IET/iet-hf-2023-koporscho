# Manuális tesztelés

## Teszteset 1: Játék indítása

**Leírás:** A program futtatása után a menüből kiválasztott pálya betöltése.

**Lépések:**

1. Futtatás
2. Map1 kiválasztása

**Elvárt eredmény:** Az alkalmazás elindul, a pályát kiválasztva betölti azt, készen áll a játék kezdésére.

**Siker/hiba:** Siker

**Megjegyzések:** A pálya betöltéséhez annak rendelkezésre kell állnia a **saves** mappában, a megfelelő txt formátumban.

A további teszteseteknél feltételezzük ennek helyes működését, mivel minden további teszt így kezdődik, külön nem kerül leírásra.

---

## Teszteset 2: Játékosok lépése

**Leírás:** Egy játékot hárman játszanak, mindenkinek három akciója van, ezután a következő ember jön. Ennél a tesztnél nem lényeges, hogy az akcióik közül melyiket hajtjuk végre.

**Lépések:**

1. Első virológus akciói (háromszor 2-es gomb lenyomása)
2. Második virológus akciói (elsőhöz hasonlóan)
3. Harmadik virológus akciói (első kettőhöz hasonlóan)

**Elvárt eredmény:** A játékosok sorban kövessék egymást, ha a letelt a 3 akciójuk, egy újabb gomb megnyomásával jöjjön a következő. A játékos ikonja és neve az aktuálisnak megfelelően változzon.

**Siker/hiba:** Siker

**Megjegyzések:** -

---

## Teszteset 3: Játékosok mozgatása

**Leírás:** Az akciók közül a mozgásnak a tesztelése.

**Lépések:**

1. Első virológus lép
   - move (1), storage-1 (2)
   - move (1), shelter-1 (2)
   - move (1), storage-2 (2)
2. Második virológus lép
   - move (1), storage-1 (2)
   - move (1), shelter-1 (2)
   - move (1), storage-2 (2)
3. Harmadik virológus lép
   - move (1), storage-1 (2)
   - move (1), shelter-1 (2)
   - move (1), storage-2 (2)

**Elvárt eredmény:** A virológusok a kiválasztott mezőre lépnek, a grafikus felületen nyomon követhető melyik mezőn állnak.

**Siker/hiba:** Siker

**Megjegyzések:** Az 1-es (move) és 0-ás (cancel) gomb akárhányszor megnyomható egymás után, így egy játékos tudja húzni az időt. Egy limit jó lenne erre.

---

## Teszteset 4: Háttér változása a mezőnek megfelelően

**Leírás:** Négyféle mező van, város, labor, raktár és óvóhely. A háttér mindig azt reprezentálja, amin a játékos áll.

**Lépések:**

1. Első virológus óvóhelyre lép
   - Move (1), Shelter-1 (1)
2. Első virológus városra lép
   - Move (1), City-1 (5)
3. Első virológus laborra lép
   - Move (1), Lab-3 (7)
4. Első virológus raktárra lép
   - Move (1), Storage-1 (2)

**Elvárt eredmény:** Attól függően, hogy az aktuális játékos milyen mezőn tartózkodik, a háttér ennek megfelelően változik.

**Siker/hiba:** Siker

**Megjegyzések:** -

---

## Teszteset 5: Virológus interakciója várossal

**Leírás:** Város mezőn állva interakció végrehajtása.

**Lépések:**

1. Interakció (2) választása (a játék egy város mezőn kezdődik, ezért nem kell most rá lépni)

**Elvárt eredmény:** Ne történjen semmi, hiszen a városnak nincs kitüntetett szerepe interakció esetén.

**Siker/hiba:** Siker

**Megjegyzések:** Megfontolandó lehet, hogy ilyenkor ne csökkenjen az akciók száma, hanem egy felugró ablak jelezze, hogy ennek a lépésnek nincs haszna.

---

## Teszteset 6: Virológus interakciója laborral

**Leírás:** Labor mezőn állva interakció végrehajtása, ezáltal a megismerhető genetikai kód megtanulása.

**Lépések:**

1. Lépés (1) a Lab-2 mezőre (3)
2. Interakció (2)
3. Váltás a kis képernyőn a receptekre (E)

**Elvárt eredmény:** A genetikai kód bekerül a receptek közé.

**Siker/hiba:** Siker

**Megjegyzések:** -

---

## Teszteset 7: Virológus interakciója óvóhellyel

**Leírás:** Óvóhelyen állva interakció végrehajtása, ezáltal a felvehető felszerelés megszerzése.

**Lépések:**

1. Lépés (1) a Shelter-1 mezőre (1)
2. Interakció (2)
3. Interakció (2)

**Elvárt eredmény:** A felszerelés rákerül a játékosra, mégegyszer nem vehető fel.

**Siker/hiba:** Siker

**Megjegyzések:** A harmadik felszerelésnek a helye lelóg a képernyőről.

---

## Teszteset 8: Virológus interakciója raktárral

**Leírás:** Raktár mezőn állva interakció végrehajtása, ezáltal a felvehető anyagok megszerzése

**Lépések:**

1. Lépés (1) a Storage-1 mezőre (2)
2. Interakció (2)

**Elvárt eredmény:** A képernyő bal alján megjelenik a felvett anyagok száma. Különböző raktárakban más-más mennyiség szerezhető meg.

**Siker/hiba:** Siker

**Megjegyzések:** -

---

## Teszteset X: [Teszteset neve]

**Leírás:** [Rövid leírás a tesztesetről]

**Lépések:**

1. [1. lépés]
2. [2. lépés]
3. [3. lépés]
   - [Al-lépés 1]
   - [Al-lépés 2]

**Elvárt eredmény:** [Elvárt eredmény a tesztesettől]

**Siker/hiba:** [Siker/hiba]

**Megjegyzések:** [További megjegyzések, észrevételek vagy problémák]
