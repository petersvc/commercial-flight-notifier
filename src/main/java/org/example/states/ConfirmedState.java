package org.example.states;

import org.example.Flight;
import org.example.factories.StateFactory;
import org.example.models.Passenger;

public class ConfirmedState implements State {

    private final Flight flight;

    public ConfirmedState(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void changeState(int stateType) throws Exception {
        State newState = StateFactory.createState(stateType, flight);
        flight.setState(newState);
    }

    @Override
    public void addPassenger(Passenger passenger) throws Exception {
        throw new Exception("Voo confirmado, não é possível adicionar passageiros");
    }

    @Override
    public void removePassenger(String name) throws Exception {
        throw new Exception("Voo confirmado, não é possível remover passageiros");
    }

    @Override
    public void changeGate(String gate) throws Exception {
        throw new Exception("Voo confirmado, não é possível alterar o portão de embarque");
    }

    @Override
    public void notifyPassengers() {
        for (Passenger passenger : flight.getPassengers()) {
            passenger.notify("Voo confirmado. Aguarde a horario de emabarque.");
        }
    }
}
