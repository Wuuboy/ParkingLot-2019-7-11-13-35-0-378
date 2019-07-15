package com.thoughtworks.tdd;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import static junit.framework.TestCase.assertSame;
public class ParkingBoyTest {
    @Test
    public void should_return_car_when_park_car_to_parking_lot_then_get_it_back() throws FakeTicketException, UsedTicketException, NoPositionException, CarHasBeenParkedException, NullCarException, NoTicketException {
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
    public void should_mutiple_cars_when_park_to_parking_lot_then_get_them_back() throws FakeTicketException, UsedTicketException, NoPositionException, CarHasBeenParkedException, NullCarException, NoTicketException {
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
    public void should_not_fetch_car_when_ticket_is_fake() throws Exception, FakeTicketException {
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

    @Test
    public void should_not_fetch_car_when_no_ticket() throws Exception, FakeTicketException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        Assertions.assertThrows(NoTicketException.class, ()->parkingBoy.fetch(null));
    }
    @Test
    public void park_car_when_parkingboy_have_two_parkinglots() throws Exception, FakeTicketException {
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.moreParkLots(car1);
        parkingBoy.moreParkLots(car2);
        parkingBoy.moreParkLots(car3);
        parkingBoy.moreParkLots(car4);
        parkingBoy.moreParkLots(car5);
        Ticket ticket = parkingBoy.moreParkLots(car6);
        //then
        Car fetchedCar = parkingBoy.fetchWithMoreParkingplots(ticket);
        //then
        assertSame(car6, fetchedCar);
    }



    @Test
    public void park_car_with_super_parking_boy() throws Exception, FakeTicketException {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        //set the bigger parking spaces
        //here exist problem
        parkingLot2.setParkingSpaceCount(7);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        parkingBoy.superPark(car1);
        ParkingLot parkingLotMax = parkingBoy.superPark(car2);
        //then
        assertSame(parkingLot2, parkingLotMax);
    }
    @Test
    public void should_return_parkingboys_when_manager_add_parkingboy(){
        //given
        Manager manager = new Manager();
        ParkingBoy parkingBoy =new ParkingBoy();
        //when
        //manager.addParkingboys(parkingBoy)
        //then
        assertSame(manager.getParkingBoys(),manager.addParkingboys(parkingBoy));
    }

    @Test
    public void should_park_car_and_manage_mutiple_parkinglots() throws CarHasBeenParkedException, NullCarException, NoPositionException, FakeTicketException, UsedTicketException, NoTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        ArrayList<ParkingLot>parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot1);
        ParkingBoy manager = new Manager(parkingLots);

        Car car = new Car();
        //when
        Ticket ticket = manager.moreParkLots(car);
        Car fetchedCar = manager.fetchWithMoreParkingplots(ticket);
        //then
        assertSame(((Manager) manager).getParkingLots(),((Manager) manager).addParkinglot(parkingLot2));
        assertSame(car,fetchedCar);
    }

    @Test
    public void should_return_worong_message_when_parkingboy_failed_parking_car() throws CarHasBeenParkedException, NullCarException, NoPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingSpaceCount(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Manager manager = new Manager();
        Car car = new Car();
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ArrayList<ParkingBoy> parkingBoys = manager.addParkingboys(parkingBoy);
        parkingBoys.get(parkingBoys.size()-1).park(car);
        parkingBoys.get(parkingBoys.size()-1).park(car1);
        //then
        //exist confusing problems
        Assertions.assertThrows(Exception.class,()->parkingBoys.get(parkingBoys.size()-1).park(car2));
    }
}
