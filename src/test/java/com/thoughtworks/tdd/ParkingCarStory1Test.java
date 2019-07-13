package com.thoughtworks.tdd;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static junit.framework.TestCase.assertSame;
import static org.fest.assertions.api.Assertions.assertThat;
public class ParkingCarStory1Test {
    @Test
    public void should_return_car_when_park_car_to_parking_lot_then_get_it_back() throws FakeTicketException, UsedTicketException, NoPositionException, CarHasBeenParkedException, NullCarException {
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
    public void should_mutiple_cars_when_park_to_parking_lot_then_get_them_back() throws FakeTicketException, UsedTicketException, NoPositionException, CarHasBeenParkedException, NullCarException {
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
    public void should_not_fetch_car_when_ticket_is_fake() throws Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket fakeTicket = new Ticket();
        //when
        parkingBoy.park(car);
        //then
        Assertions.assertThrows(FakeTicketException.class, ()->parkingBoy.fetch(fakeTicket),"Unrecognized parking ticket.");
    }
    @Test
    public void should_not_fetch_car_when_ticket_is_used() throws FakeTicketException, Exception {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //then
        Assertions.assertThrows(UsedTicketException.class, ()->parkingBoy.fetch(ticket),"Unrecognized parking ticket.");
    }

    @Test
    public void should_not_park_car_when_parking_space_count_is_less_than_0() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        parkingBoy.park(car1);
        parkingBoy.park(car2);
        parkingBoy.park(car3);
        parkingBoy.park(car4);
        parkingBoy.park(car5);
        //then
        Assertions.assertThrows(NoPositionException.class, ()->parkingBoy.park(car6));
    }
    @Test
    public void should_not_park_car_when_car_has_been_parked() throws CarHasBeenParkedException, NoPositionException, NullCarException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        parkingBoy.park(car);
        //then
        Assertions.assertThrows(CarHasBeenParkedException.class, ()->parkingBoy.park(car));
    }
    @Test
    public void should_not_park_car_when_car_is_null() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        //then
        Assertions.assertThrows(NullCarException.class, ()->parkingBoy.park(null));
    }
}
