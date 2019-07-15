package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exceptions.FakeTicketException;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertSame;

public class StandardParkingBoyTest {
    @Test
    public void park_car_with_standard_parking_boy() throws Exception, FakeTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot2);
        ParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLots);
        //when
        standardParkingBoy.park(car1);
        standardParkingBoy.park(car2);
        standardParkingBoy.park(car3);
        standardParkingBoy.park(car4);
        standardParkingBoy.park(car5);
        Ticket ticket = standardParkingBoy.park(car6);
        //then
        Car fetchedCar = standardParkingBoy.fetch(ticket);
        //then
        assertSame(car6, fetchedCar);
    }
}
