package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();
    private static final int GROW_FACTOR = 2;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }


    public ParkingTicket fetchTicket(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        if ( getAvailableParkingPosition()  == 0 ) {
            return null;
        }
        cars.put(parkingTicket, car);
        return parkingTicket;
    }


    public Car fetchCar(ParkingTicket ticket) {
        Car car = cars.get(ticket);
        cars.remove(ticket);
        return car;
    }

}
