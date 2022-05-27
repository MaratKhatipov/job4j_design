package ru.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

import static ru.ood.lsp.parking.Car.SIZE;

public class CarAndTruckParkingImpl implements Parking {

    private int freeSpacePassCar;
    private int freeSpaceTruck;
    private final List<Car> carStorage = new ArrayList<>();

    public CarAndTruckParkingImpl(int freeSpacePassCar, int freeSpaceTruck) {
        this.freeSpacePassCar = freeSpacePassCar;
        this.freeSpaceTruck = freeSpaceTruck;
    }

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль смог припарковаться
     */
    @Override
    public boolean carSuccessfullyParked(Car car) {
        boolean res = false;
        if (car.getCarSize() == SIZE && freeSpacePassCar >= 1) {
            freeSpacePassCar--;
            res = carStorage.add(car);
        } else if (car.getCarSize() > SIZE && freeSpaceTruck >= 1) {
            freeSpaceTruck--;
            res = carStorage.add(car);
        } else if (car.getCarSize() <= freeSpacePassCar) {
            freeSpacePassCar -= car.getCarSize();
            res = carStorage.add(car);
        }
        return res;
    }

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль успешно удалился с парковки
     */
    @Override
    public boolean carFinishParked(Car car) {
        boolean finished = false;
        if (carStorage.remove(car)) {
            if (car.getCarSize() == SIZE) {
                freeSpacePassCar++;
            } else if (car.getCarSize() > SIZE) {
                freeSpaceTruck++;
            }
        }
        return finished;
    }

    /**
     * метод подсчитывает общее колличество свободных мест
     * @return возвращает общее колличество свободных мест
     */
    @Override
    public int countFreeSpace() {
        System.out.println("freeSpacePassCar = " + freeSpacePassCar
                + "; freeSpaceTruck = " + freeSpaceTruck);
        return freeSpacePassCar + freeSpaceTruck;
    }

    /**
     * меод проверяет есть ли свободные места
     * @return - true, если есть свободные места
     */
    @Override
    public boolean checkFreeSpace() {
        return (freeSpacePassCar + freeSpaceTruck) > 0;
    }
}
