package org.example.states;

import org.example.Flight;
import org.example.models.Passenger;
import org.example.factories.StateFactory;

public class DelayedState implements State {

    private final Flight flight;

    public DelayedState(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void changeState(int stateType) throws Exception {
        State newState = StateFactory.createState(stateType, flight);
        flight.setState(newState);
    }

    @Override
    public void addPassenger(Passenger passenger) throws Exception {
        if (!this.flight.isFull()) {
            flight.getPassengers().add(passenger);
            System.out.println("Passageiro " + passenger.getName() + " adicionado ao voo.");
        } else {
            throw new Exception("Não pode adicionar mais passageiros. A aeronave já está em sua capacidade máxima.");
        }
    }

    @Override
    public void removePassenger(String name) throws Exception {
        for (Passenger passenger : flight.getPassengers()) {
            if (passenger.getName().equals(name)) {
                flight.getPassengers().remove(passenger);
                System.out.println("Passageiro " + name + " removido do voo.");
                return;
            }
        }
        throw new Exception("O passageiro de nome " + name + " não foi encontrado na lista de passageiros do voo.");
    }

    @Override
    public void changeGate(String gate) throws Exception {
        throw new Exception("Não é possível alterar o portão diretamente no estado de Atraso. É necessário a transição para o estado de Troca de Portão primeiro..");
    }


    @Override
    public void notifyPassengers() {
        for (Passenger passenger : flight.getPassengers()) {
            passenger.notify("Voo em atraso. Por favor fique atento à novas informações.");
        }
    }
}
