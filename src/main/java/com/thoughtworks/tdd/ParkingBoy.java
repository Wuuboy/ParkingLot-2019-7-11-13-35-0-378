package com.thoughtworks.tdd;

import java.util.*;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;
    private Map<Ticket,ParkingLot> ticketParkinglot= new HashMap<>();

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Map<Ticket, ParkingLot> getTicketParkinglot() {
        return ticketParkinglot;
    }

    public ParkingBoy() {
    }


    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Ticket moreParkLots(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        for (ParkingLot parkingLot:parkingLots) {
            if (parkingLot.getParkingSpaceCount()>0){
                Ticket ticket = parkingLot.park(car);
                ticketParkinglot.put(ticket,parkingLot);
                return ticket;
            }
        }
//        exist problems
        return null;
    }

    public Car fetchWithMoreParkingplots(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException, NoTicketException {
        return ticketParkinglot.get(ticket).fetchCar(ticket);
    }

    public Car fetch(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException, NoTicketException {
        return parkingLot.fetchCar(ticket);
    }
}
