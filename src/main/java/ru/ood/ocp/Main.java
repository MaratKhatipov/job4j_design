package ru.ood.ocp;

import java.util.ArrayList;

public class Main {

    /*
    Здесь нарушение в том, что класс Toyota нерасширяем.
    Здесь лучше использовать интерфейс
     */
    class Toyota {
        void doSomething() {
            System.out.println("Do Something");
        }
    }

    class Celica extends Toyota {
        @Override
        void doSomething() {
            System.out.println("Another action");
        }
    }

    /*
    Для птицы и самолета лучше использовать общий интерфейс
     */
    class Bird {
        void fly() {
            System.out.println("bird flying");
        }
    }

    class Airplane {
        void fly() {
            System.out.println("Airplane flying");
        }
    }

    /*
    Возвращается конкретная реализация ArrayList.
    Для гибкости лучше воспользоваться интерфейсом List
     */
    class ArList {
        public ArrayList<Integer> doSomething() {
            ArrayList<Integer> array = new ArrayList<>();
            array.add(1);
            array.add(2);
            array.add(3);
            return array;
        }
    }
}
