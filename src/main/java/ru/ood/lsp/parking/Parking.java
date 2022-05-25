package ru.ood.lsp.parking;

public interface Parking {

    boolean carSuccessfullyParked(Car car);

    boolean carFinishParked(Car car);

    int countFreeSpace();

    boolean checkFreeSpace();
}
