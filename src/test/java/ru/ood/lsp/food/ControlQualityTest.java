package ru.ood.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {
    private final LocalDate expiryDateMilk = LocalDate.now().plusDays(4);
    private final LocalDate createDateMilk = LocalDate.now().minusDays(37);
    private final Food milk = new Milk("Prostokvashino", expiryDateMilk, createDateMilk, 86.4, 0.5);

    private final LocalDate expiryDatePasta = LocalDate.now().plusDays(30);
    private final LocalDate createDatePasta = LocalDate.now().minusDays(1);
    private final Food pasta = new Pasta("Barilla", expiryDatePasta, createDatePasta, 150, 0.2);

    private final LocalDate expiryDateBread = LocalDate.now();
    private final LocalDate createDateBread = LocalDate.now().minusDays(2);
    private final Food baton = new Bread("Podmoskownyi", expiryDateBread, createDateBread, 46, 0.1);

    private final Store warehouse = new Warehouse();
    private final Store trash = new Trash();
    private final Store shop = new Shop();
    private final List<Store> storeList = List.of(warehouse, trash, shop);
    private final ControlQuality controlQuality = new ControlQuality(storeList);

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