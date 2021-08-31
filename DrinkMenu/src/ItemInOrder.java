
public class ItemInOrder {

    private Drink drink;
    private int amount;

    public ItemInOrder(Drink drink, int amount) {
        this.drink = drink;
        this.amount = amount;
    }

    public double getPrice() {
        return this.drink.getPrice() * this.amount;
    }

    public String toString(){
        return this.drink.toString() + ", amount=" + this.amount;
    }
}