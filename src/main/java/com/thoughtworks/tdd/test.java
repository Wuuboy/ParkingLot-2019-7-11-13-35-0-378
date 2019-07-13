package com.thoughtworks.tdd;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws CarHasBeenParkedException, NullCarException, NoPositionException, FakeTicketException, UsedTicketException, NoTicketException {
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
        Car fetchedCar = parkingBoy.fetch(ticket);
    }
}
