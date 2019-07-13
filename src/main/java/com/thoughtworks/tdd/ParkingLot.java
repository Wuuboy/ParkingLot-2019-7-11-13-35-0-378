package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket, Car> parkingCarTicket = new HashMap<>();
    private int parkingSpaceCount = 5;

    public HashMap<Ticket, Car> getParkingCarTicket() {
        return parkingCarTicket;
    }

    public Car fetchCar(Ticket ticket) throws FakeTicketException, UsedTicketException {
        if (parkingCarTicket.containsKey(ticket)){
            if (parkingCarTicket.get(ticket)!=null){
                Car car =  parkingCarTicket.get(ticket);
//                parkingCarTicket.get(ticket) = null;
                parkingCarTicket.put(ticket,null);
                return car;
            }else {
                throw new UsedTicketException();
            }
        }else {
            throw new FakeTicketException("Unrecognized parking ticket.");
        }
    }

    public Ticket park(Car car) throws NoPositionException, CarHasBeenParkedException, NullCarException {
        if (car != null) {
            if (parkingSpaceCount > 0) {
                if (parkingCarTicket.containsValue(car)) {
                    throw new CarHasBeenParkedException();
                } else {
                    Ticket ticket = new Ticket();
                    parkingCarTicket.put(ticket, car);
                    parkingSpaceCount--;
                    return ticket;
                }
            } else {
                throw new NoPositionException();
            }
        }else {
            throw  new NullCarException();
        }
    }


}
