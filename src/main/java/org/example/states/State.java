package org.example.states;

import org.example.Flight;
import org.example.models.Passenger;

public interface State {

    void changeState(int stateType) throws Exception;

    void addPassenger(Passenger passenger) throws Exception;

    void removePassenger(String name) throws Exception;

    void changeGate(String gate) throws Exception;

    void notifyPassengers();

}

