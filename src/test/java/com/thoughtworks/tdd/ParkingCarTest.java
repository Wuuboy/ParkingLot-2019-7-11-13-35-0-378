package com.thoughtworks.tdd;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static junit.framework.TestCase.assertSame;
import static org.fest.assertions.api.Assertions.assertThat;
public class ParkingCarTest {
    @Test
    public void should_return_car_when_park_car_to_parking_lot_then_get_it_back() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertSame(car, fetchedCar);
    }
    @Test
    public void should_mutiple_cars_when_park_to_parking_lot_then_get_them_back() throws Exception {
        //give
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket firstTicket = parkingBoy.park(firstCar);
        Car fetchedFirstCar = parkingBoy.fetch(firstTicket);
        Ticket secondTicket = parkingBoy.park(secondCar);
        Car fetchedSecondCar = parkingBoy.fetch(secondTicket);
        //then
        assertSame(firstCar, fetchedFirstCar);
        assertSame(secondCar, fetchedSecondCar);
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_wrong() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket fakeTicket = new Ticket();
        //when
        parkingBoy.park(car);
        //then
        Assertions.assertThrows(Exception.class, ()->parkingBoy.fetch(fakeTicket));
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_used() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //then
        Assertions.assertThrows(Exception.class, ()->parkingBoy.fetch(ticket));
    }
//    @Test
//    public void should_not_return_ticket_when_parkingLot_is_not_position() throws Exception {
//        //given
//        Car firstCar = new Car();
//        Car secondCar = new Car();
//        Car thirdCar = new Car();
//        Car fourthCar = new Car();
//        Car fifthCar = new Car();
//        Car sixthCar = new Car();
//        Car seventhCar = new Car();
//        Car eighthCar = new Car();
//        Car ninthCar = new Car();
//        Car tenthCar = new Car();
//        Car elevenCar = new Car();
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        //when
//        parkingBoy.park(firstCar);
//        parkingBoy.park(secondCar);
//        parkingBoy.park(thirdCar);
//        parkingBoy.park(fourthCar);
//        parkingBoy.park(fifthCar);
//        parkingBoy.park(sixthCar);
//        parkingBoy.park(seventhCar);
//        parkingBoy.park(eighthCar);
//        parkingBoy.park(ninthCar);
//        parkingBoy.park(tenthCar);
//        //then
//        Assertions.assertThrows(ParkingLotNotPositionException.class, ()->parkingBoy.park(elevenCar));
//    }
//    @Test
//    public void should_not_park_car_when_car_is_parked() throws Exception {
//        //given
//        Car car = new Car();
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        //when
//        parkingBoy.park(car);
//        //then
//        Assertions.assertThrows(CarHasBeenPardedException.class, ()->parkingBoy.park(car));
//    }
//    @Test
//    public void should_not_park_car_when_car_is_null() throws Exception {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
//        //when
//        //then
//        Assertions.assertThrows(CarIsNullException.class, ()->parkingBoy.park(null));
//    }
}
