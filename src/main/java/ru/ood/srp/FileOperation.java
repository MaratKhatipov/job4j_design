package ru.ood.srp;
/*
Интерфейс рабобты с файлами.
Здесь наружение принципа SRP в том,
что имеются методы которые выполняют разный функционоал!
 */
public interface FileOperation {
    void openAndReadFile();
    void saveFile();
    void serviceMessage(String message);
}
