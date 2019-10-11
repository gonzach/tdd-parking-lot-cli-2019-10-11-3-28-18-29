package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private ParkingTicket ticket;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return this.parkingLot.fetchTicket(car);
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
