package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParkingBoy {

    private List<ParkingLot> parkingLotList = new ArrayList<>();
    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car) {
        if (parkingLot.getAvailableParkingPosition() != 0)
            return parkingLot.addCar(car);
        else {
            ParkingLot availableParkingLot = parkingLotList.stream()
                    .filter(parkingLot -> parkingLot.countCars() != parkingLot.getCapacity())
                    .findFirst().orElse(null);
            if (availableParkingLot == null){
                setLastErrorMessage("Not enough position.");
                return null;
            } else {
                return availableParkingLot.addCar(car);
            }
        }
    }



    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public Car fetch(ParkingTicket ticket) {
        Car fetchedTicketCar = parkingLot.getCar(ticket);
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

    public void addParkingLot(ParkingLot parkingLot){
        parkingLotList.add(parkingLot);
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}
