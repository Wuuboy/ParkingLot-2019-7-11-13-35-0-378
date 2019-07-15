package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exceptions.*;

import java.util.*;

public class Manager extends StandardParkingBoy{
    ArrayList<ParkingBoy> parkingBoys = new ArrayList<>();
    ArrayList<ParkingLot> parkingLots;

    public Manager() {

    }

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = (ArrayList<ParkingLot>) parkingLots;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ArrayList<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public ArrayList<ParkingBoy> addParkingboys(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        return parkingBoys;
    }
    public ArrayList<ParkingLot> addParkinglot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLots;
    }

    @Override
    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        return super.park(car);
    }

    @Override
    public Car fetch(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException, NoTicketException {
        return super.fetch(ticket);
    }

    public Ticket callParkingBoyToParkingCar(Car car, ParkingBoy parkingBoy) throws CarHasBeenParkedException, NullCarException, NoPositionException, FakeTicketException, UsedTicketException, NoTicketException {
        Ticket ticket = parkingBoy.park(car);
        return ticket;
    }

    public Car callParkingBoyToFetchCar(ParkingBoy parkingBoy,Ticket ticket) throws NoTicketException, FakeTicketException, UsedTicketException, NoPositionException {
        Car fetchedCar = parkingBoy.fetch(ticket);
        return fetchedCar;
    }
}
