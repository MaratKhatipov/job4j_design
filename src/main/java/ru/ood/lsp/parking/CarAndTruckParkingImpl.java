package ru.ood.lsp.parking;

public class CarAndTruckParkingImpl implements Parking {
    @Override
    public boolean carSuccessfullyParked(Car car) {
        return false;
    }

    @Override
    public boolean carFinishParked(Car car) {
        return false;
    }

    @Override
    public int countFreeSpace() {
        return 0;
    }

    @Override
    public boolean checkFreeSpace() {
        return false;
    }
}
