package com.thoughtworks.tdd;

import java.util.*;

public class Manager extends ParkingBoy{
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

}
