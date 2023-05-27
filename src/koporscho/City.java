package koporscho;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Koporscho csapat Projlab 
//  @ File Name : City.java
//  @ Date : 2022. 03. 25.
//  @ Authors : Szabó Egon, Biró Ferenc, Tóth Bólint, Ferge Mótó, Rahmi Dóniel
//
//


import java.io.IOException;

/**
 *A város mezőt valósítja meg, mellyel a karakter interakcióját követően semmilyen esemény nem történik.
 */
public class City extends Field {
	/**
	 * Meghívja a paraméterként kapott visitornak megfelelő függvényét.
	 * @param vis Visitor típusa
	 */
	public void React(IVis vis) {
		vis.InteractCity();
	}

	/**
	 * A City osztály logger fügvénye, mely az adott mező tulajdonságait írja ki a standard kimentre és fájlba.
	 * @throws IOException
	 */
	@Override
	public void log() throws IOException {
		super.log();
	}
}
