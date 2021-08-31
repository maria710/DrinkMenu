import java.io.IOException;

public class Test {

    public static void main(String args[]) {
        NonAlcoholic non = new NonAlcoholic(51, "dačo", 4.9, "dcl", "jahodkova");
        NonAlcoholic non2 = new NonAlcoholic(7, "dačo", 4.9, "dcl", "jahodkovssa");
        String output = non.toString();
        System.out.println(output);
        ItemInOrder itor = new ItemInOrder(non, 20);


        DrinkMenu drMenu = new DrinkMenu();
        drMenu.addDrink(non);
        drMenu.addDrink(non2);
        try{
            drMenu.createDrinkMenu("menu2.txt");

        } catch(Exception e){
            e.printStackTrace();
        }




        System.out.println("😚😎😄🤔🥰");
        Order order = new Order();
        order.addOrderItem(itor);
        try{
            order.addOrderItem("binary.dat", drMenu );

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Zle");
        }
        try{
            order.writeOrder("final_order.txt");

        } catch(IOException e){

            e.printStackTrace();
        }
    }
}// MAIN JE VYTVORENY
