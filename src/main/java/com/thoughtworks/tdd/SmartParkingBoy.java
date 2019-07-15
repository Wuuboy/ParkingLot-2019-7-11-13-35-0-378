package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        int bigCapacity = parkingLots.get(0).getParkingSpaceCount();
        ParkingLot parkingLotMax = parkingLots.get(0);
        for (ParkingLot parkingLot:parkingLots) {
            if (parkingLot.getParkingSpaceCount()>bigCapacity){
                bigCapacity = parkingLot.getParkingSpaceCount();
                parkingLotMax = parkingLot;
            }
        }
        Ticket ticket = parkingLotMax.park(car);
        this.getTicketParkinglot().put(ticket,parkingLotMax);
        return ticket;
    }
}
