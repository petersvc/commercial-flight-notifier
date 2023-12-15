package org.example.states;

import org.example.Flight;
import org.example.models.Passenger;

public class CompletedState implements State {

    private final Flight flight;

    public CompletedState(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void changeState(int stateType) throws Exception {
        throw new Exception("Voo finalizado, não é possível alterar o estado");
    }

    @Override
    public void addPassenger(Passenger passenger) throws Exception {
        throw new Exception("Voo finalizado, não é possível adicionar passageiros");
    }

    @Override
    public void removePassenger(String name) throws Exception {
        throw new Exception("Voo finalizado, não é possível remover passageiros");
    }

    @Override
    public void changeGate(String gate) throws Exception {
        throw new Exception("Voo finalizado, não é possível alterar o portão de embarque");
    }

    @Override
    public void notifyPassengers() {
        System.out.println("Voo" + flight.getId() + "finalizado, agradecemos a preferencia.");
    }
}
