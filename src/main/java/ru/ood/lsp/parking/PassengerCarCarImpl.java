package ru.ood.lsp.parking;

public class PassengerCarCarImpl implements Car {

    public static final int SIZE = 1;
    public PassengerCarCarImpl() {
        int size = SIZE;
    }

    /**
     * @return возвращает размер автомобиля
     */
    @Override
    public int getCarSize() {
        return SIZE;
    }
}
