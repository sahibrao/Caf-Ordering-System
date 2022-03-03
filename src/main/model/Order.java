package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Order {

    private ArrayList<Drink> orderList;
    private double totalPrice;

    public Order() {
        orderList = new ArrayList<>();
        totalPrice = 0;
    }

    public void orderSmoothie(String size) {
        Smoothie smoothie = new Smoothie(size);
        orderList.add(smoothie);
    }

    public void orderLatte(String size) {
        Latte latte = new Latte(size);
        orderList.add(latte);
    }

    public void orderCoffeeFrap(String size) {
        CoffeeFrap coffeeFrap = new CoffeeFrap(size);
        orderList.add(coffeeFrap);
    }

    public void orderAmericano(String size) {
        Americano americano = new Americano(size);
        orderList.add(americano);
    }

    public void toppings(int drinkNumber, String whip, String cinnamon, String drizzle) {
        Drink d = orderList.get(drinkNumber - 1);
        d.changeToppings(whip, cinnamon, drizzle);
    }

    public void milk(int drinkNumber, String milk) {
        Drink d = orderList.get(drinkNumber - 1);
        d.addMilk(milk);
    }

    public void sugar(int drinkNumber, int sugarNo) {
        Drink d = orderList.get(drinkNumber - 1);
        d.addSugar(sugarNo);
    }

    public void remove(int drinkNumber) {
        orderList.remove(drinkNumber - 1);
    }

    public ArrayList<Drink> getList() {
        return orderList;
    }

    public double getPrice() {
        double allPrice = 0.0;
        for (Drink d : orderList) {
            allPrice += d.getPrice();
        }
        return allPrice;
    }

   // @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Order", "Starbucks");
        json.put("Drink", drinksToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray drinksToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Drink d : orderList) {
            jsonArray.put(d.toJson());
        }
        return jsonArray;
    }
}
