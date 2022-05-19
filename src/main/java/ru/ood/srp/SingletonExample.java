package ru.ood.srp;

/*
Здесь создаётся синглтон.
Singleton — подразумевает, что помимо своих основных обязанностей
класс занимается еще и контролированием количества своих экземпляров,
чем нарушает Single Responsibility Principle
 */
public class SingletonExample {
    private static SingletonExample instance;
    private SingletonExample() {
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public void print(String message) {
        System.out.println("Hello World");
    }
}
