package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NoPositionException {
        Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException {
        return parkingLot.fetchCar(ticket);
    }
}
