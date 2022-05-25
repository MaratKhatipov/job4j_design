package ru.ood.lsp.food;


import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private static final int FROM = 25;
    private static final int TO = 75;
    private static final int CONDITION_FOR_DISCOUNT = 100;
    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean result = accept(food);
        double percents =  getCondition(food);
        if (result) {
            if (percents > TO && percents < CONDITION_FOR_DISCOUNT) {
                food.setPrice(food.getPrice() * food.getDiscount());
            }
            foods.add(food);
        }
        return result;
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double percents = getCondition(food);
        if (percents >= FROM && percents < CONDITION_FOR_DISCOUNT) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> getProducts() {
        return new ArrayList<>(foods);
    }

    @Override
    public String toString() {
        return "Shop{"
                + "foods=" + foods
                + '}';
    }
}
