package ru.ood.lsp.parking;

public interface Parking {
    /**
     *
     * @param car - тип автомобиля
     * @return - true, если автомобиль смог припарковаться
     */
    boolean carSuccessfullyParked(Car car);

    /**
     * @param car - тип автомобиля
     * @return - true, если автомобиль успешно удалился с парковки
     */
    boolean carFinishParked(Car car);

    /**
     * метод подсчитывает общее колличество свободных мест
     * @return возвращает общее колличество свободных мест
     */
    int countFreeSpace();

    /**меод проверяет есть ли свободные места
     * @return - true, если есть свободные места
     */
    boolean checkFreeSpace();
}
