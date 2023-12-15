package org.example.factories;

import org.example.Flight;
import org.example.states.*;

public class StateFactory {

    public static State createState(int stateType, Flight flight) throws Exception {
        return switch (stateType) {
            case 1 -> new ScheduledState(flight);
            case 2 -> new ConfirmedState(flight);
            case 3 -> new CanceledState(flight);
            case 4 -> new DelayedState(flight);
            case 5 -> new GateChangingState(flight);
            case 6 -> new CompletedState(flight);
            default -> throw new Exception("Invalid state type: " + stateType);
        };
    }
}

