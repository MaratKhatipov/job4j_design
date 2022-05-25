package ru.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private final static int SMALLER = 25;
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        boolean res = accept(food);
        if (res) {
            foods.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        double percents = getCondition(food);
        if (percents < SMALLER) {
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
        return "Warehouse{"
                + "foods=" + foods
                + '}';
    }
}
