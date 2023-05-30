package koporscho;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Koporscho csapat Projlab 
//  @ File Name : VirologistVisitor.java
//  @ Date : 2022. 03. 25.
//  @ Authors : Szab� Egon, Bir� Ferenc, T�th B�lint, Ferge M�t�, Rahmi D�niel
//
//


/** */
public class VirologistVisitor implements IVis {
	/** Tárolja az elkövető Virológust*/
	private final Virologist sourceVirologist;

	/** A mezőt tárolja, amin áll az elkövető*/
	private final Field targetField;


	/**
	 * Konstruktor a VirologistVisitor létrehozásához a paraméterként kapott Virológus számára.
	 * @param virologist Virológus
	 */
	public VirologistVisitor(Virologist virologist)
	{
		sourceVirologist = virologist;
		targetField = virologist.GetField();
	}

	/** A karakter és a város közötti interakcióért felelős */
	public void InteractCity() {
		//System.out.println("This has no use in the game yet.");
	}
	
	/** A karakter és az óvóhely közötti interakcióért felelős.*/
	public void InteractStorage() {
		Materials transferAmount = new Materials();

		Materials max = sourceVirologist.GetMaxMaterials();
		Materials curr = sourceVirologist.GetCurrentMaterials();
		if(curr==null) {
			curr = new Materials(0,0);
			sourceVirologist.SetMaterials(curr);
		}
		if(max==null) {
			max = new Materials(0,0);
			sourceVirologist.SetMaxMaterials(max);
		}

		transferAmount.SetAminoAcid(Math.min(max.GetAminoAcid() - curr.GetAminoAcid(), ((Storage)targetField).GetSupply().GetAminoAcid()));
		transferAmount.SetNucleotide(Math.min(max.GetNucleotide() - curr.GetNucleotide(), ((Storage)targetField).GetSupply().GetNucleotide()));

		((Storage)targetField).SubtractMaterials(transferAmount);
		sourceVirologist.AddMaterials(transferAmount);
	}
	
	/** A karakter és a raktár közötti interakcióért felelős.*/
	public void InteractShelter() {
		Equipment temp = ((Shelter)targetField).GetEquipment();
		((Shelter)targetField).RemoveEquipment();
		int s;
		if((s = sourceVirologist.GetEquipment().size()) == 3)
		{
			((Shelter)targetField).AddEquipment(sourceVirologist.GetEquipment().get(0));
			sourceVirologist.RemoveEquipment(sourceVirologist.GetEquipment().get(0));
		}

		sourceVirologist.AddEquipment(temp);
	}
	
	/** A karakter és a laboratórium közötti interakcióért felelős.*/
	public void InteractLab() {
		sourceVirologist.LearnRecipe(((Lab)targetField).GetRecipe());
	}
}
