package ru.ood.isp;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        menu.select("Купить хлеб");
        MenuPrinter printer = new Printer();
        //printer.print(menu);
        System.out.println(menu.select("Сходить в магазин"));
    }
}
