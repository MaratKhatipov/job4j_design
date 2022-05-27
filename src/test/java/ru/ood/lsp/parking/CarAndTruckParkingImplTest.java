package ru.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CarAndTruckParkingImplTest {

    @Test
    public void whenPassCarParkedThenTrue() {
        Car passCar = new PassengerCarCarImpl();
        Parking parking = new CarAndTruckParkingImpl(4, 0);
        assertTrue(parking.carSuccessfullyParked(passCar));
    }

    @Test
    public void whenTruckParkedThenTrue() {
        Car truck = new TrucCarImpl(2);
        Parking parking = new CarAndTruckParkingImpl(0, 4);
        assertTrue(parking.carSuccessfullyParked(truck));
    }

    @Test
    public void whenCarAndTruckParkingTHenTrue() {
        Car passCar = new PassengerCarCarImpl();
        Car truck = new TrucCarImpl(2);
        Parking parking = new CarAndTruckParkingImpl(2, 4);
        assertTrue(parking.carSuccessfullyParked(passCar)
                && parking.carSuccessfullyParked(truck));
    }

    @Test
    public void whenTruckParkedPassCarPlaceThenTrue() {
        Car truck = new TrucCarImpl(2);
        Parking parking = new CarAndTruckParkingImpl(4, 0);
        assertTrue(parking.carSuccessfullyParked(truck));
    }

    @Test
    public void whenNotCarPassSpaceThenFalse() {
        Car passCar = new PassengerCarCarImpl();
        Parking parking = new CarAndTruckParkingImpl(0, 1);
        assertFalse(parking.carSuccessfullyParked(passCar));
    }

    @Test
    public void whenNotTruckSpaceThenFalse() {
        Car truck = new TrucCarImpl(7);
        Parking parking = new CarAndTruckParkingImpl(4, 0);
        assertFalse(parking.carFinishParked(truck));
    }

    @Test
    public void whenCheckTotalFreeSpaceIs4() {
        Parking parking = new CarAndTruckParkingImpl(4, 4);
        parking.carSuccessfullyParked(new PassengerCarCarImpl());
        parking.carSuccessfullyParked(new PassengerCarCarImpl());
        parking.carSuccessfullyParked(new TrucCarImpl(2));
        parking.carSuccessfullyParked(new TrucCarImpl(2));
        assertThat(parking.countFreeSpace(), is(4));
    }

    @Test
    public void whenAllPlaceOccupiedThenFalse() {
        Parking parking = new CarAndTruckParkingImpl(2, 2);
        parking.carSuccessfullyParked(new PassengerCarCarImpl());
        assertTrue(parking.checkFreeSpace());
        parking.carSuccessfullyParked(new PassengerCarCarImpl());
        assertTrue(parking.checkFreeSpace());
        parking.carSuccessfullyParked(new TrucCarImpl(2));
        assertTrue(parking.checkFreeSpace());
        parking.carSuccessfullyParked(new TrucCarImpl(2));
        assertFalse(parking.carSuccessfullyParked(new TrucCarImpl(2)));
        assertFalse(parking.checkFreeSpace());

    }

    @Test
    public void whenAllPlaceOccupiedButCarHasLeftThenTrue() {
        Parking parking = new CarAndTruckParkingImpl(1, 1);
        Car oka = new PassengerCarCarImpl();
        Car kamaz = new TrucCarImpl(2);
        parking.carSuccessfullyParked(oka);
        parking.carSuccessfullyParked(kamaz);
        parking.carFinishParked(oka);
        Car matiz = new PassengerCarCarImpl();
        assertTrue(parking.carSuccessfullyParked(matiz));
    }
}