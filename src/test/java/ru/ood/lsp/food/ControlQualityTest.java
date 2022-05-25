package ru.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {
    LocalDate expiryDateMilk = LocalDate.of(2022, Month.MAY, 29);
    LocalDate createDateMilk = LocalDate.of(2022, Month.APRIL, 18);
    Food milk = new Milk("Prostokvashino", expiryDateMilk, createDateMilk, 86.4, 0.5);

    LocalDate expiryDatePasta = LocalDate.of(2022, Month.JUNE, 24);
    LocalDate createDatePasta = LocalDate.of(2022, Month.MAY, 24);
    Food pasta = new Pasta("Barilla", expiryDatePasta, createDatePasta, 150, 0.2);

    LocalDate expiryDateBread = LocalDate.of(2022, Month.MAY, 25);
    LocalDate createDateBread = LocalDate.of(2022, Month.MAY, 22);
    Food baton = new Bread("Podmoskownyi", expiryDateBread, createDateBread, 46, 0.1);

    Store warehouse = new Warehouse();
    Store trash = new Trash();
    Store shop = new Shop();
    List<Store> storeList = List.of(warehouse, trash, shop);
    ControlQuality controlQuality = new ControlQuality(storeList);

    @Test
    public void whenProductSentToShopAndGetDiscount() {
        controlQuality.addStore(List.of(milk));
        assertThat(milk.getPrice(), is(43.2));
        assertThat(milk, is(shop.getProducts().get(0)));
        assertTrue(warehouse.getProducts().isEmpty());
        assertTrue(trash.getProducts().isEmpty());
    }

    @Test
    public void whenProductSentToWarehouse() {
        controlQuality.addStore(List.of(pasta));
        assertThat(pasta, is(warehouse.getProducts().get(0)));
        assertTrue(shop.getProducts().isEmpty());
        assertTrue(trash.getProducts().isEmpty());
    }

    @Test
    public void whenProductSentToTrash() {
        controlQuality.addStore(List.of(baton));
        assertThat(baton, is(trash.getProducts().get(0)));
        assertTrue(warehouse.getProducts().isEmpty());
        assertTrue(shop.getProducts().isEmpty());
    }

    @Test
    public void whenProductSentToTrashAndWareAndShop() {
        controlQuality.addStore(List.of(milk, pasta, baton));
        assertThat(milk, is(shop.getProducts().get(0)));
        assertThat(pasta, is(warehouse.getProducts().get(0)));
        assertThat(baton, is(trash.getProducts().get(0)));
        storeList.forEach(System.out::println);
    }
}