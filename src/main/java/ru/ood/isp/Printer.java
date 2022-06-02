package ru.ood.isp;

import static java.lang.System.out;

public class Printer implements MenuPrinter {

    public static final String SEPARATOR = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo i : menu) {
            out.print(SEPARATOR.repeat(getCount(i)));
            if (getCount(i) == 0) {
                out.println(i.getNumber() + i.getName());
            } else {
                out.println(" " + i.getNumber() + i.getName());
            }
        }

    }

    private int getCount(Menu.MenuItemInfo i) {
        return (i.getNumber().split("\\.").length - 1);
    }
}
