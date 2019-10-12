package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private ParkingTicket ticket;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
         if ( this.parkingLot.fetchTicket(car) == null) {
             setLastErrorMessage("Not enough position.");
             getLastErrorMessage();
         }
        return this.parkingLot.fetchTicket(car);
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public Car fetch(ParkingTicket ticket) {
        if (parkingLot.fetchCar(ticket) == null ){
            setLastErrorMessage("Unrecognized parking ticket");
            getLastErrorMessage();
        }
//        else if () {
//            setLastErrorMessage("Please provide your parking ticket.");
//            getLastErrorMessage();
//        }
        return parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
       return lastErrorMessage;
    }
}
