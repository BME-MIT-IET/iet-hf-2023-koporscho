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

**Leírás:** Négyféle mező van, város, labor, raktár és menedékhely. A háttér mindig azt reprezentálja, amin a játékos áll.

**Lépések:**

1. Első virológus menedékhelyre lép
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