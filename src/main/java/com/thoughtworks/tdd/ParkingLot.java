package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket, Car> parkingCarTicket = new HashMap<>() ;

//    public ParkingLot() {
//        this.parkingCarTicket = new HashMap<>();
//    }

    public HashMap<Ticket, Car> getParkingCarTicket() {
        return parkingCarTicket;
    }

    public Car fetchCar(Ticket ticket) throws Exception {
        if (!parkingCarTicket.containsKey(ticket)){
            throw new Exception();
        }
        Car car =  parkingCarTicket.get(ticket);
        return car;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingCarTicket.put(ticket, car);
        return ticket;
    }

}
