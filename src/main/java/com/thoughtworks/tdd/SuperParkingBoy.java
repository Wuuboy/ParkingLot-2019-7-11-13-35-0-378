package com.thoughtworks.tdd;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy {

    public SuperParkingBoy() {
    }

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        int bigCapacity = this.getParkingLots().get(0).getParkingSpaceCount()/5;
        ParkingLot parkingLotMax = this.getParkingLots().get(0);
        for (ParkingLot parkingLot:this.getParkingLots()) {
            if (parkingLot.getParkingSpaceCount()/5>=bigCapacity){
                bigCapacity = parkingLot.getParkingSpaceCount();
                parkingLotMax = parkingLot;
            }
        }
        Ticket ticket = parkingLotMax.park(car);
        this.getTicketParkinglot().put(ticket,parkingLotMax);
        return ticket;
    }

    @Override
    public Car fetch(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException, NoTicketException {
        return this.getTicketParkinglot().get(ticket).fetchCar(ticket);
    }
}
