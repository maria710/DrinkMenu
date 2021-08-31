
class Drink {

    private int id;
    private String name;
    private Double price;
    private String unit;

    public Drink(int id, String name, Double price, String unit){
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;

    }
    public int getId(){
        return id;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String toString(int amount){
        return "Drink id = " + this.id + " Name = " + this.name + " Price = " + this.price + " E " + amount + " " + this.unit;
    }

}


