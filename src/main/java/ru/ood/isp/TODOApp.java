package ru.ood.isp;

import java.util.Scanner;
import java.util.StringJoiner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = () -> System.out.println("меню выбрано");
    private static  Scanner scanner = new Scanner(System.in);

    private static boolean init(Menu menu, String request, MenuPrinter printer) {
        boolean result = true;
        if ("1".equals(request)) {
            System.out.println("Enter a name for the new task/Введите имя новой задачи: ");
            menu.add(Menu.ROOT, scanner.nextLine(), STUB_ACTION);
        } else if ("2".equals(request)) {
            printer.print(menu);
            System.out.println("Choose a task name/Выберите имя задачи:");
            String parent = scanner.nextLine();
            System.out.println("Enter a subtask name/Введите имя подзадачи:");
            String child = scanner.nextLine();
            menu.add(parent, child, STUB_ACTION);
        } else if ("3".equals(request)) {
            printer.print(menu);
        } else if ("4".equals(request)) {
            System.out.println("GG WP");
            result = false;
        } else {
            System.out.println("Введите цифры от 1 до 4");
        }
        return result;
    }

    private static void menuCreate() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add("Выбрать действие: ");
        stringJoiner.add("1. Добавить пункт ");
        stringJoiner.add("2. Добавить подпункт");
        stringJoiner.add("3. Вывод меню на экран");
        stringJoiner.add("4. Выход");
        System.out.println(stringJoiner);
    }

    public static void main(String[] args) {
        boolean run = true;
        Menu menuEx = new SimpleMenu();
        MenuPrinter printer = new Printer();
        while (run) {
            menuCreate();
            run = init(menuEx, scanner.nextLine(), printer);
        }
    }
}
