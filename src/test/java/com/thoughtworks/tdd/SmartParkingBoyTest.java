package com.thoughtworks.tdd;

import org.junit.Test;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;

import static junit.framework.TestCase.assertSame;

public class SmartParkingBoyTest {

    @Test
    public void park_car_with_smart_parking_boy() throws Exception, FakeTicketException {
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
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        smartParkingBoy.park(car1);
        //then
        assertSame(parkingLot2.getParkingSpaceCount(), 6);
    }
}
