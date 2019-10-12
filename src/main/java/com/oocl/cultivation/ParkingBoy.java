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
        Car fetchedTicketCar = parkingLot.fetchCar(ticket);
        if ( ticket == null ) {
            setLastErrorMessage("Please provide your parking ticket.");
            getLastErrorMessage();
        } else if ( fetchedTicketCar == null ) {
            setLastErrorMessage( "Unrecognized parking ticket.");
            getLastErrorMessage();
        }
        return fetchedTicketCar;
    }

    public String getLastErrorMessage() {
       return lastErrorMessage;
    }
}
