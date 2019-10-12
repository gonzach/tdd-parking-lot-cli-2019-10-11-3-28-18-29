package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import javafx.beans.binding.BooleanExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_car_to_parking_lot_by_parking_boy_and_return_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingboy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        ParkingTicket car1_parkingTicket = parkingboy.park(car1);

        assertNotNull(car1_parkingTicket);
    }

    @Test
    void should_customer_give_the_parking_ticket_back_to_parking_boy_to_fetch_the_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingboy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        ParkingTicket car1_parkingTicket = parkingboy.park(car1);

        Car fetchedCar = parkingboy.fetch(car1_parkingTicket);

        assertNotNull(fetchedCar);
    }

    @Test
    void should_parking_boy_can_park_multiple_cars_into_the_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car car1 = new Car();
        ParkingTicket car1_parkingTicket = parkingBoy.park(car1);
        Car fetchedCar1 = parkingBoy.fetch(car1_parkingTicket);

        Car car2 = new Car();
        ParkingTicket car2_parkingTicket = parkingBoy.park(car2);
        Car fetchedCar2 = parkingBoy.fetch(car2_parkingTicket);

        assertEquals( fetchedCar1, car1);
        assertEquals( fetchedCar2, car2);
    }

    @Test
    void should_check_if_customer_gives_wrong_ticket_then_no_car_should_be_fetcher() {
        ParkingLot parkinglot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car1 = new Car();
        ParkingTicket car1_parkingTicket = parkingBoy.park(car1);

        Car fetchedCar = parkingBoy.fetch(new ParkingTicket());

        assertNull(fetchedCar);
    }

    @Test
    void should_check_if_customer_gives_used_ticket_then_no_car_should_be_fetcher() {
        ParkingLot parkinglot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car1 = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car1);

        Car fetchCar = parkingBoy.fetch(parkingTicket);
        Car fetchCarAgain = parkingBoy.fetch(parkingTicket);

        assertNotNull(fetchCar);
        assertNull(fetchCarAgain);
    }

    @Test
    void should_check_parking_lot_capacity() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i = 0; i< 10; i++){
            parkingBoy.park(new Car());
        }

        Car car1 = new Car();
        ParkingTicket car1_parkingTicket = parkingBoy.park(car1);

        assertNull(car1_parkingTicket);
    }

    @Test
    void should_get_response_message_if_customer_gives_wrong_ticket() {
        ParkingLot parkinglot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);

        Car fetchCar = parkingBoy.fetch(new ParkingTicket());

        assertNull(fetchCar);
       assertEquals(parkingBoy.getLastErrorMessage(), "Unrecognized parking ticket.");
    }

    @Test
    void should_get_response_message_when_customer_does_not_provide_ticket_when_fetching_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car fetchCar = parkingBoy.fetch(null);

        assertNull(fetchCar);
        assertEquals(parkingBoy.getLastErrorMessage(), "Please provide your parking ticket.");
    }


    @Test
    void should_park_cars_to_the_second_parking_lot_when_the_first_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot) ;
        for(int i = 0; i< 10; i++){
            parkingBoy.park(new Car());
        }

        Car car = new Car();
        parkingBoy.park(new Car());

        assertNotNull(car);
        assertEquals(parkingBoy.getLastErrorMessage(), "Not enough position.");
    }
}
