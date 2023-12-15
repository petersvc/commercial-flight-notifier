package org.example.repositories;

import org.example.models.Aircraft;
import org.example.factories.AircraftFactory;
import org.example.Flight;

import java.util.ArrayList;
import java.util.List;

public class AircraftRepository {
    List<Aircraft> aircrafts = new ArrayList<>();
    AircraftFactory aircraftFactory = new AircraftFactory();

    public void save(String type, int HowManyToCreate) {
        aircrafts.addAll(aircraftFactory.create(type, HowManyToCreate));
    }

    public List<Aircraft> findAll() {
        return aircrafts;
    }

    public List<Aircraft> findByAvailability(FlightRepository flightRepository) {
        List<Aircraft> availableAircrafts = new ArrayList<>();

        for (Aircraft aircraft : this.aircrafts) {
            var isAvailable = true;

            for (Flight flight : flightRepository.findAll()) {
                if (flight.getAircraft().getId() == aircraft.getId()) {
                    isAvailable = false;
                    break;  // Interrompe o loop assim que uma correspondência é encontrada
                }
            }

            if (isAvailable) {
                availableAircrafts.add(aircraft);
            }
        }

        return availableAircrafts;
    }

    public Aircraft findById(long id) {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getId() == id) {
                return aircraft;
            }
        }
        return null;
    }

}
