package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_car_to_parking_lot_by_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingboy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingboy.park(car);

        assertNotNull(parkingTicket);
    }

    @Test
    void should_parking_boy_fetch_the_car() {
        ParkingTicket parkingTicket = new ParkingTicket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingboy = new ParkingBoy(parkingLot);
        parkingTicket = parkingboy.park(new Car());

        Car car = parkingboy.fetch(parkingTicket);

        assertNotNull(car);
    }

    @Test
    void should_customer_check_ticket() {

        ParkingLot parkinglot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = parkingBoy.fetch(new ParkingTicket());
        assertNull(car);
    }

    @Test
    void should_fetch_no_car() {
        ParkingTicket parkingTicket = new ParkingTicket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingTicket = parkingBoy.park(new Car());

        Car car = parkingBoy.fetch(parkingTicket);

        assertNotNull(car);
    }

    @Test
    void should_check_parking_lot_capacity() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        for(int i = 0; i< 10; i++){
            parkingBoy.park(new Car());
        }

        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);

        assertNull(parkingTicket);
    }
}
