package ru.ood.isp;

import java.util.Scanner;
import java.util.StringJoiner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = () -> System.out.println("меню выбрано");
    private static final Scanner SCANNER = new Scanner(System.in);

    private static boolean init(String request, Menu menu, MenuPrinter printer) {
        boolean result = true;
        switch (request) {
            case "1" -> {
                System.out.println("Enter a name for the new task/Введите имя новой задачи: ");
                menu.add(Menu.ROOT, SCANNER.nextLine(), STUB_ACTION);
            }
            case "2" -> {
                printer.print(menu);
                System.out.println("Choose a task name/Выберите имя задачи:");
                String parent = SCANNER.nextLine();
                System.out.println("Enter a subtask name/Введите имя подзадачи:");
                String child = SCANNER.nextLine();
                menu.add(parent, child, STUB_ACTION);
            }
            case "3" -> printer.print(menu);
            case "4" -> {
                System.out.println("GG WP");
                result = false;
            }
            default -> System.out.println("Введите цифры от 1 до 4");
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
            run = init(SCANNER.nextLine(), menuEx, printer);
        }
    }
}
