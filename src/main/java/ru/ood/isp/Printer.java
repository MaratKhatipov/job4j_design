package ru.ood.isp;

import static java.lang.System.out;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo i : menu) {
            int count = (i.getNumber().split("\\.").length - 1);
            out.print("----".repeat(count));
            if (count == 0) {
                out.println(i.getNumber() + i.getName());
            } else {
                out.println(" " + i.getNumber() + i.getName());
            }
        }
    }
}
