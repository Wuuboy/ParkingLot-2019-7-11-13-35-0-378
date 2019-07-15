package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exceptions.*;

import java.util.List;

public class StandardParkingBoy extends ParkingBoy {

    public StandardParkingBoy() {
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        for (ParkingLot parkingLot:this.getParkingLots()) {
            if (parkingLot.getParkingSpaceCount()>0){
                Ticket ticket = parkingLot.park(car);
                this.getTicketParkinglot().put(ticket,parkingLot);
                return ticket;
            }
        }
//        exist problems
        return null;
    }


    @Override
    public Car fetch(Ticket ticket) throws FakeTicketException, UsedTicketException, NoPositionException, NoTicketException {
        return this.getTicketParkinglot().get(ticket).fetchCar(ticket);
    }
}
