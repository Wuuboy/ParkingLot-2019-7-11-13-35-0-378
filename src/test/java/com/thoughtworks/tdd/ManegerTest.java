package com.thoughtworks.tdd;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static junit.framework.TestCase.assertSame;

public class ManegerTest {
    @Test
    public void should_return_parkingboys_when_manager_add_parkingboys_into_list(){
        //given
        Manager manager = new Manager();
        ParkingBoy parkingBoy =new ParkingBoy();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        //when
        manager.addParkingboys(parkingBoy);
        manager.addParkingboys(smartParkingBoy);
        //then
        assertSame(manager.getParkingBoys(),manager.addParkingboys(superParkingBoy));
    }

    @Test
    public void should_return_car_when_manager_set_specific_parkingboy_to_fetch_car() throws NullCarException, NoTicketException, CarHasBeenParkedException, FakeTicketException, UsedTicketException, NoPositionException {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        Manager manager = new Manager();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLot2);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        Ticket ticket = manager.callParkingBoyToParkingCar(car,smartParkingBoy);
        Car expectedCar = manager.callParkingBoyToFetchCar(smartParkingBoy,ticket);
        //then
        assertSame(expectedCar,car);
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
