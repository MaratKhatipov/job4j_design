package ru.ood.lsp.food;

import java.time.LocalDate;

public class Milk extends Food {

    public Milk(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }

}
