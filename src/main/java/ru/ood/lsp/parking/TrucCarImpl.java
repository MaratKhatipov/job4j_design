package ru.ood.lsp.parking;

public class TrucCarImpl implements Car {
    private final int size;

    public TrucCarImpl(int size) {
        this.size = size;
    }

    /**
     * @return возвращает размер автомобиля
     */
    @Override
    public int getCarSize() {
        return 0;
    }
}
