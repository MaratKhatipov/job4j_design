package ru.ood.lsp.food;

import java.time.LocalDate;

public class Pasta extends Food {
    public Pasta(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
