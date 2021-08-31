

public class NonAlcoholic extends Drink{

    private String flavour;
   
    public NonAlcoholic(int id, String name, Double price, String unit, String flavour){
        super(id, name, price, unit);
        this.flavour = flavour;
    }

    
    public String toString() {
        return super.toString(799) + ", flavour " + this.flavour;
    }
}
