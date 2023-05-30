package koporscho;
import proto.Prototype;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Koporscho csapat Projlab 
//  @ File Name : Shelter.java
//  @ Date : 2022. 03. 25.
//  @ Authors : Szaba Egon, Bira Ferenc, Tath Balint, Ferge Mata, Rahmi Daniel
//
//


/** A mező osztály leszármazottja, az óvóhelyeket reprezentálja. */
public class Shelter extends Field {
	private Equipment equipment;

	/** Az óvóhely implicit konstruktora.*/
	public Shelter() {
		equipment = new Equipment(new StatusEffect(), 1);
	}

	/**
	 * Óvóhely mező kontruktora, mely a paraméterként kapott felszereléssel hozza létre a mezőt.
	 * @param e Óvóhelyen található felszerelés
	 */
	public Shelter(Equipment e) {
		equipment = e;
	}

	/**
	 * Meghívja a paraméterként kapott visitornak megfelelő függvényét.
	 * @param vis Visitor típusa
	 */
	public void React(IVis vis) {
		vis.InteractShelter();
	}
	
	/** Elhelyez egy felszerelést a mezőn */
	public void AddEquipment(Equipment e) {
		equipment = e;
	}

	
	/**  Eltüntet egy felszerelést a mezőről. */
	public void RemoveEquipment() {
		equipment = null;
	}

	/** A mezőn található felszerelés implicit getter függvénye.*/
	public Equipment GetEquipment() {
		return equipment;
	}

	/**
	 * A Shelter osztály logger fügvénye, mely az adott óvóhely tulajdonságait írja ki a standard kimentre és fájlba.
	 * @throws java.io.IOException
	 */
	@Override
	public void log() throws java.io.IOException
	{
		super.log();
		System.out.print("\tequipment: ");
		System.out.println(equipment == null ?"-":Prototype.objectIDs.get(equipment));

		Prototype.writer.write("\tequipment: ");
		Prototype.writer.write(equipment == null ?"-\n":Prototype.objectIDs.get(equipment)+"\n");

	}
}
