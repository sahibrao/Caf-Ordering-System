package model;

import org.json.JSONObject;

// a class representing an Latte that is extending espresso's methods that are implemented in Drink
public class Latte extends Espresso {

    private double lattePrice;
    private String nameToCall;
    private String size;

    // REQUIRES: a string size of "small", "medium" or "large"
    // EFFECTS:  based on the size, lattePrice will be the correct price of the latte,
    //           and the nameToCall will contain the right size of the latte
    //           and set size accordingly
    public Latte(String size) {
        if (size.equals("small")) {
            setSize("small");
            lattePrice = 3.00;
            nameToCall = "The small latte";
        } else if (size.equals("medium")) {
            setSize("medium");
            lattePrice = 4.00;
            nameToCall = "The medium latte";
        } else {
            setSize("large");
            lattePrice = 5.00;
            nameToCall = "The large latte";
        }
    }

    // REQUIRES: Strings of whipCream, cinnamon and caramel to be either "yes" or "no"
    // MODIFIES: this
    // EFFECTS:  adds 0.10 to lattePrice for each "yes" of toppings and makes the correct
    //           adjustments to nameToCall
    public void changeToppings(String whipCream, String cinnamon, String caramel) {
        if (whipCream.equals("yes")) {
            nameToCall += " with whip cream";
            lattePrice += 0.10;
        } else {
            nameToCall += " without whip cream";
        }
        if (cinnamon.equals("yes")) {
            nameToCall += ", with cinnamon powder";
            lattePrice += 0.10;
        } else {
            nameToCall += ", without cinnamon powder";
        }
        if (caramel.equals("yes")) {
            nameToCall += " and with caramel drizzle";
            lattePrice += 0.10;
        } else {
            nameToCall += " and without caramel drizzle";
        }
    }

    // REQUIRES: Strings of milk to be a type of milk, such as "oat" or "almond"
    // MODIFIES: this
    // EFFECTS:  adds 0.30 to lattePrice for milk added and makes the correct
    //           adjustments to nameToCall
    public void addMilk(String milk) {
        lattePrice += 0.3;
        nameToCall += ", made with " + milk + " milk";
        EventLog.getInstance().logEvent(new Event("Added " + milk + " milk to the " + size + " latte"));

    }

    // REQUIRES: sugar >= 0
    // MODIFIES: this
    // EFFECTS:  makes the correct adjustments to nameToCall depending on number of sugars
    //           if 0, no change, if above one, packets with an s is added to nameToCall instead of no s if sugar==1
    public void addSugar(int sugar) {
        if (sugar > 1) {
            nameToCall += " and " + sugar + " packets of sugar";
        } else if (sugar == 1) {
            nameToCall += " and " + 1 + " packet of sugar";
        }
    }

    //getter method for lattePrice
    public double getPrice() {
        return lattePrice;
    }

    //getter method for nameToCall
    public String getNameDrink() {
        return nameToCall;
    }

    // setter for name to call
    public void setNameToCall(String nameToCall) {
        this.nameToCall = nameToCall;
    }

    // getter for size
    public String getSize() {
        return size;
    }

    // setter method for size
    public void setSize(String size) {
        this.size = size;
    }


    // taken from JsonSerializationDemo
    // EFFECTS: returns an americano as a JSON v
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("price", lattePrice);
        json.put("name", "Latte");
        json.put("size", getSize());
        json.put("call", getNameDrink());
        return json;
    }

}
