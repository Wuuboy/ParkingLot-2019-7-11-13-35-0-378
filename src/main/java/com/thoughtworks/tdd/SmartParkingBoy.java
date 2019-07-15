package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        int bigCapacity = this.getParkingLots().get(0).getParkingSpaceCount();
        ParkingLot parkingLotMax = this.getParkingLots().get(0);
        for (ParkingLot parkingLot:this.getParkingLots()) {
            if (parkingLot.getParkingSpaceCount()>bigCapacity){
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
