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
        boolean res = false;
        if (car.getCarSize() == 1 && freeSpacePassCar > 0) {
            freeSpacePassCar--;
            increaseOccupiedPlaces();
            res = carStorage.add(car);
        } else if (car.getCarSize() > 1 && freeSpaceTruck > 0) {
            freeSpaceTruck--;
            increaseOccupiedPlaces();
            res = carStorage.add(car);
        } else if (car.getCarSize() <= freeSpacePassCar) {
            freeSpacePassCar -= car.getCarSize();
            increaseOccupiedPlaces();
            res = carStorage.add(car);
        }
        return res;
    }

    /**
     * внутренний метод для увеличения знятых мест
     * и уменьшения свободных
     */
    private void increaseOccupiedPlaces() {
        totalSpace--;
        occupiedSpace++;
    }

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль успешно удалился с парковки
     */
    @Override
    public boolean carFinishParked(Car car) {
        boolean finished = false;
        if (carStorage.remove(car)) {
            if (car.getCarSize() == 1) {
                increaseInVacancies();
                freeSpacePassCar++;
            } else if (car.getCarSize() > 1) {
                increaseInVacancies();
                freeSpaceTruck++;
            }
        }
        return finished;
    }

    /**
     * внутренний метод для увеличения свободных мест
     * и уменьшения занятых
     */
    private void increaseInVacancies() {
        totalSpace++;
        occupiedSpace--;
    }

    /**
     * метод подсчитывает общее колличество свободных мест
     *
     * @return возвращает общее колличество свободных мест
     */
    @Override
    public int countFreeSpace() {
        System.out.println("freeSpacePassCar = " + freeSpacePassCar
                + "; freeSpaceTruck = " + freeSpaceTruck);
        return totalSpace;
    }

    /**
     * меод проверяет есть ли свободные места
     *
     * @return - true, если есть свободные места
     */
    @Override
    public boolean checkFreeSpace() {
        return occupiedSpace < totalSpace;
    }
}
