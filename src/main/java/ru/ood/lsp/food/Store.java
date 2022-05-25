package ru.ood.lsp.food;

import java.time.LocalDate;
import java.util.List;

public interface Store {
    boolean add(Food food);

    boolean accept(Food food);

    List<Food> getProducts();

    default double getCondition(Food food) {
        double dayPassedAfterCreate = LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear();
        double expirationDateDays = food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear();
        return (dayPassedAfterCreate * 100) / expirationDateDays;
    }
}
