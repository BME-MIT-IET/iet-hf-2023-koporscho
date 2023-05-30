package koporscho;

public class BearVisitor implements IVis {

    /** Referencia a mezőre, amin az interakció történik*/
    private final Field targetField;

    /**
     * A BearVisitor egy paraméteres konstruktora.
     * @param v Megfertőzött virológus.
     */
    public BearVisitor(Virologist v) {
        targetField=v.GetField();
    }
    /** Nem csinál semmit, majd visszatér.*/
    public void InteractCity(){}

    /** Nem csinál semmit, majd visszatér.*/
     public void InteractShelter(){}

    /** Nem csinál semmit, majd visszatér.*/
    public void InteractLab(){}

    /**Nullára állítja a mező nyersanyagkészletét.*/
    public void InteractStorage(){
        ((Storage)targetField).SetSupply(new Materials(0,0));
    }

}
