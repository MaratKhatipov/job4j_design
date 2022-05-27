package ru.ood.lsp.parking;

public class PassengerCarCarImpl implements Car {

    private final int size;

    public PassengerCarCarImpl() {
        this.size = 1;
    }

    /**
     * @return возвращает размер автомобиля
     */
    @Override
    public int getCarSize() {
        return 0;
    }
}
