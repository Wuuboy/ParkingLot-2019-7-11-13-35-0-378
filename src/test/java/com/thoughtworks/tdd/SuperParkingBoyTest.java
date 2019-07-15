package com.thoughtworks.tdd;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void park_car_with_super_parking_boy() throws Exception, FakeTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        //set the bigger parking spaces
        parkingLot2.setParkingSpaceCount(7);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.superPark(car1);
        parkingBoy.superPark(car2);
        //then
        assertSame(parkingLot2.getParkingSpaceCount(), 6);
    }
}
