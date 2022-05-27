package ru.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarAndTruckParkingImpl implements Parking {

    private int freeSpacePassCar;
    private int freeSpaceTruck;
    private int occupiedSpace;
    private int totalSpace;
    List<Car> carStorage = new ArrayList<>();

    public CarAndTruckParkingImpl(int freeSpacePassCar, int freeSpaceTruck) {
        this.freeSpacePassCar = freeSpacePassCar;
        this.freeSpaceTruck = freeSpaceTruck;
        this.totalSpace = freeSpacePassCar + freeSpaceTruck;
    }

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль смог припарковаться
     */
    @Override
    public boolean carSuccessfullyParked(Car car) {
        return false;
    }

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль успешно удалился с парковки
     */
    @Override
    public boolean carFinishParked(Car car) {
        return false;
    }

    /**
     * метод подсчитывает общее колличество свободных мест
     *
     * @return возвращает общее колличество свободных мест
     */
    @Override
    public int countFreeSpace() {
        return 0;
    }

    /**
     * меод проверяет есть ли свободные места
     *
     * @return - true, если есть свободные места
     */
    @Override
    public boolean checkFreeSpace() {
        return false;
    }
}
