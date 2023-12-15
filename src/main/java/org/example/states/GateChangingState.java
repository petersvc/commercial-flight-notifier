package org.example.states;

import org.example.Flight;
import org.example.factories.StateFactory;
import org.example.models.Passenger;

public class GateChangingState implements State {

    private final Flight flight;

    public GateChangingState(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void changeState(int stateType) throws Exception {
        State newState = StateFactory.createState(stateType, flight);
        if (newState instanceof CompletedState) {
            throw new Exception("Não é possível alterar o estado para concluído durante a troca de portão.");
        }
        flight.setState(newState);
    }

    @Override
    public void addPassenger(Passenger passenger) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Não é possível adicionar passageiros durante a troca de portão.");
    }

    @Override
    public void removePassenger(String name) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Não é possível remover passageiros durante a troca de portão.");
    }

    @Override
    public void changeGate(String gate) throws Exception {
        flight.setGate(gate);
        System.out.println("Portão de embarque alterado para " + gate + ".");
    }


    @Override
    public void notifyPassengers() {
        for (Passenger passenger : flight.getPassengers()) {
            passenger.notify("Voo cancelado. Pedimos perdão pela inconveniência.");
        }
    }
}
