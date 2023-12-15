package org.example.repositories;

import org.example.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    List<Flight> flights = new ArrayList<>();

    public List<Flight> findAll() {
        return flights;
    }

    public Flight findById(long id) {
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public void save(Flight flight) {
        flights.add(flight);
    }
}
