
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DrinkMenu {

    private HashMap<Integer, Drink> drinkList;

    public DrinkMenu() {
        this.drinkList = new HashMap<>();

    }

    public void addDrink(Drink drink) {
        if (drink != null && !this.drinkList.containsValue(drink)) {
            this.drinkList.put(drink.getId(), drink);
        }

    }

    public Drink getDrink(int drinkId) {
        if (this.drinkList.containsKey(drinkId)) {
            return drinkList.get(drinkId);
        }

        return null;

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Drink menu contains: \n");

        for (Drink drink : drinkList.values()) {
            sb.append(drink.toString() + "\n");
        }
        return sb.toString();
    }

    public void createDrinkMenu(String fileName) throws IOException {

        // Create new file object
        File f = new File(fileName);
        

        // File writer to manipulate a content
        FileWriter outs = null; // creates file stream outs

        outs = new FileWriter(f, true); // opens outFile
        // if true is given as an argument wi will not overwrite

        for (Entry<Integer, Drink> entry : drinkList.entrySet()) {
            Integer key = entry.getKey();
            Drink value = entry.getValue();

            outs.write(value.toString() + "\r\n");
            // write to the file and add a new line at the end
        }
        outs.close();
    }
}