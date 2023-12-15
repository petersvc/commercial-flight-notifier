package org.example.states;

import org.example.Flight;
import org.example.models.Passenger;

public class CanceledState implements State {

    private final Flight flight;

    public CanceledState(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void changeState(int stateType) throws Exception {
        throw new Exception("o voo foi cancelado, não é possível mudar o estado.");
    }

    @Override
    public void addPassenger(Passenger passenger) throws Exception {
        throw new Exception("Não pode adicionar mais passageiros. o voo foi cancelado.");
    }

    @Override
    public void removePassenger(String name) throws Exception {
        throw new Exception("Não pode remover passageiros. o voo foi cancelado.");
    }

    @Override
    public void changeGate(String gate) throws Exception {
        throw new Exception("Não pode mudar o portão. o voo foi cancelado.");
    }


    @Override
    public void notifyPassengers() {
        for (Passenger passenger : flight.getPassengers()) {
            passenger.notify("Voo cancelado. Pedimos perdão pela inconveniência.");
        }
    }
}
