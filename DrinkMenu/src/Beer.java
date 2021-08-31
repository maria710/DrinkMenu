
public class Beer extends Drink {


private int degrees;

public Beer(int id, String name, double price, String unit, int degrees) {
    super(id, name, price, unit);
    this.degrees = degrees;
}

public String toString() {
    return super.toString(10) + " " + this.degrees + " stupnov";
    //Napoj id = 300 nazov = Zlaty bazant cena = 0,80 E 0.5 litra Pivo 10 stupnov
}

}
