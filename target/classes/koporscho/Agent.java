package koporscho;
import proto.Prototype;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Koporscho csapat Projlab 
//  @ File Name : Agent.java
//  @ Date : 2022. 03. 25.
//  @ Authors : Szabó Egon, Biró Ferenc, Tóth Bálint, Ferge Máté, Rahmi Dániel
//
//




/** Az ágenseket megvalósító osztály. A saját élettartamáért, elkészítési költségéért és
 az általa kifejtett hatásért felelős*/
public class Agent {
	
	/** Az ágens elkészítéséhez szükséges anyagok mennyiségét tárolja. */
	private final Materials recipe;
	
	/**Az effektet tárolja, amelyet az ágens felhelyez egy adott karakterre amikor felkenik rá.*/
	private final StatusEffect effect;

	/** : Az ágens nevét tároló attribútum */
	private final String name;

	/** Az ágens élettartama, aminek leteltével lebomlik (eltűnik karakter eszköztárából).*/
	private int lifespan;


	/**
	 * Az Agent osztály két paraméteres (StatusEffect, Matrials)kontsruktora.
	 * @param effect Az ágens által kifejtett effekt.
	 * @param recipe Az ágens elkészítéséhez szükséges alapanyagok.
	 */
	public Agent(StatusEffect effect, Materials recipe){
		this.effect = effect;
		this.recipe = recipe;
		this.lifespan = 3;
		this.name = "";
	}

	/**
	 * Az Agent osztály három paraméteres (SatusEffect, Materials, String)konstruktora.
	 * @param effect Az ágens által kifejett effekt.
	 * @param recipe Az ágens elkészítéséhez szükséges alapanyagok.
	 * @param name Az ágens neve.
	 */
	public Agent(StatusEffect effect, Materials recipe, String name){
		this.effect = effect;
		this.recipe = recipe;
		this.name = name;
		this.lifespan = 3;
	}

	/**
	 * Az ágens másoló konstruktora.
	 * @param agent A lemásolandó ágens.
	 */
	public Agent(Agent agent) {
		this.effect = new StatusEffect(agent.effect);
		this.lifespan = agent.lifespan;
		this.recipe = agent.recipe;
		this.name = agent.name;
		if(Prototype.objectIDs.containsKey(agent)) {
			String id = Prototype.objectIDs.get(agent);
			String base = id;
			for(int i = 1; i < 10; i++) {
				id = base+"_"+i;
				if(!Prototype.objectIDs.containsValue(id))
					break;
			}
			Prototype.objectIDs.put(this, id);
			Prototype.objectIDsInv.put(id, this);
			Prototype.agents.add(this);
		}
	}

	/**
	 * Az ágens elkészítéséhez szükséges anyagok mennyiségét visszaadó implicit getter.
	 * @return Az ágens elkészítéséhez szükséges anyagok mennyisége
	 */
	public Materials GetRecipe(){
		return recipe;
	}

	/**
	 * Csökkenti az ágens élettartamát az eszköztárban
	 * @return Az ágens maradék élettartama.
	 */
	public int ReduceLifespan() {
		return lifespan -= 1;
	}

	/**
	 * Az ágens által kifejtett effektet visszaadó implicit getter.
	 * @return Az ágens által kifejtett effekt
	 */
	public StatusEffect GetEffect() {
		return effect;
	}

	/**
	 * Az ágens osztály logger fügvénye, mely az adott ágens tulajdonságait írja ki a standard kimentre és fájlba.
	 * @throws java.io.IOException
	 */
	public void log() throws java.io.IOException {
		System.out.println(Prototype.objectIDs.get(this)+":");
		System.out.println("\tname: " + (name.isEmpty() ? "-" : name));
		System.out.println("\tlifespan: " + lifespan);
		System.out.println("\trecipe: ");
		System.out.println("\t\tnucleotide: " + recipe.GetNucleotide());
		System.out.println("\t\taminoacid: " + recipe.GetAminoAcid());
		System.out.println("\teffect: " + Prototype.objectIDs.get(effect));

		Prototype.writer.write(Prototype.objectIDs.get(this)+":"+"\n");
		Prototype.writer.write("\tname: " + (name.isEmpty() ? "-" : name)+"\n");
		Prototype.writer.write("\tlifespan: " + lifespan+"\n");
		Prototype.writer.write("\trecipe: "+"\n");
		Prototype.writer.write("\t\tnucleotide: " + recipe.GetNucleotide()+"\n");
		Prototype.writer.write("\t\taminoacid: " + recipe.GetAminoAcid()+"\n");
		Prototype.writer.write("\teffect: " + Prototype.objectIDs.get(effect)+"\n");
	}

	public String GetName() {
		return name;
	}
}
