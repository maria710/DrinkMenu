import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.*;

public class Order {
    private ArrayList<ItemInOrder> order;
    private double finalPrice;

    public Order() {
        this.order = new ArrayList<>();
        this.finalPrice = 0.0;
    }

    public void addOrderItem(String fileName, DrinkMenu menu) {
        File f = new File(fileName);
        FileInputStream stream = null;
        String drinkString = "";
        try {
            stream = new FileInputStream(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataInputStream reader = new DataInputStream(stream);
        try {
            drinkString = reader.readLine();
        } catch (EOFException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String s = drinkString;
        String str = "";
        for (int i = 0; i < s.length() / 8; i++) {
            int a = Integer.parseInt(s.substring(8 * i, (i + 1) * 8), 2);
            // i = 0 .... 0 - 8 -1
            // i = 1 .... 8 - 16 -1
            // i = 2 .... 16 - 24 -1
            str += (char) (a);
        }
        String newString = str.substring(str.indexOf('=') + 1, str.indexOf('N'));
        int x = Integer.parseInt(newString.trim());
        if (menu.getDrink(x) == null) {
            throw new IllegalArgumentException("An error has occurred... 😥");
        }
        System.out.println(str + "  " + x);

        System.out.println(s);
        String[] stringPole = str.split(" ");
        
        ItemInOrder item = new ItemInOrder(new Drink(x, stringPole[6], Double.parseDouble(stringPole[9]), stringPole[12]), 10);
        addOrderItem(item);

    }

    public void addOrderItem(ItemInOrder item) {
        if (item != null) {
            order.add(item);
            finalPrice += item.getPrice();
        }
    }

    public String toString() {
        return "";
    }

    
    public void writeOrder(String fileName) throws IOException {
        File f = new File(fileName);
        FileWriter fw = null;

        fw = new FileWriter(f);

        for (ItemInOrder itemInOrder : order) {
            fw.write(itemInOrder.toString() + "\r\n");
        }
        fw.write("Total price " + this.finalPrice);

        fw.close();
    }
}