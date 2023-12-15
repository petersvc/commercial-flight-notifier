package org.example.factories;

import org.example.Flight;
import org.example.states.*;

public class StateFactory {

    public static State createState(int stateType, Flight flight) throws Exception {
        switch (stateType) {
            case 1:
                return new ScheduledState(flight);
            case 2:
                return new ConfirmedState(flight);
            case 3:
                return new CanceledState(flight);
            case 4:
                return new DelayedState(flight);
            case 5:
                return new GateChangingState(flight);
            default:
                throw new Exception("Invalid state type: " + stateType);
        }
    }
}

