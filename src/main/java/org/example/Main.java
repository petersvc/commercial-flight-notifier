package org.example;

import org.example.factories.NotifierFactory;
import org.example.models.Passenger;
import org.example.repositories.AircraftRepository;
import org.example.repositories.FlightRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var aircraftRepository = new AircraftRepository();
        var flightRepository = new FlightRepository();

        aircraftRepository.save("Boeing747", 3);
        aircraftRepository.save("AirbusA380", 5);

        System.out.println("Aeronaves disponíveis: "+ aircraftRepository.findAll().size());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-Vindo a JetAirlines");
            System.out.println("---------------Selecione uma opção abaixo:-----------------");
            System.out.println("1 - Cadastrar Voo");
            System.out.println("2 - Adicionar Passageiro");
            System.out.println("3 - Remover Passageiro");
            System.out.println("4 - Alterar Estado do Voo");
            System.out.println("5 - Mudar Portão de Embarque");

            var option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-----Menu Principal > Cadastrar Voo------");
                    System.out.println("Aeronaves disponíveis: ");
                    var availableAircrafts = aircraftRepository.findByAvailability(flightRepository);
                    availableAircrafts.forEach(aircraft -> {
                        System.out.println("Cod: " + aircraft.getId() + " | Modelo: " + aircraft.getModel() + " | Capacidade: " + aircraft.getCapacity());
                    });

                    System.out.println("Informe o código da aeronave");

                    var aircraftOption = scanner.nextLong();
                    var aircraft = aircraftRepository.findById(aircraftOption);

                    System.out.println("Informe os dados do Voo a seguir:");

                    System.out.print("Informe o código do voo: ");
                    var id = scanner.nextLong();

                    System.out.print("Informe o aeroporto de origem: ");
                    var departures = scanner.next();

                    System.out.print("Informe o aeroporto de destino: ");
                    var arrivals = scanner.next();

                    System.out.print("Informe a data do voo: ");
                    var date = scanner.next();

                    System.out.print("Informe a previsão do horário de partida: ");
                    var departureTime = scanner.next();

                    System.out.print("Informe a previsão do horário de chegada: ");
                    var arrivalTime = scanner.next();

                    System.out.print("Informe o portão de embarque: ");
                    var gate = scanner.next();

                    flightRepository.save(new Flight(id, departures, arrivals, date, departureTime, arrivalTime, gate, aircraft));
                    break;

                case 2:
                    System.out.println("Menu Principal > Adicionar Passageiro");

                    System.out.println("Informe o código do voo: ");
                    var flightId = scanner.nextLong();
                    var flight = flightRepository.findById(flightId);

                    System.out.println("Informe o nome do passageiro: ");
                    var passengerName = scanner.next();

                    System.out.println("Informe o CPF do passageiro: ");
                    var passengerCpf = scanner.next();

                    System.out.println("Informe o meio de notificação: ");
                    System.out.println("1 - SMS ");
                    System.out.println("2 - EMAIL ");
                    System.out.println("3 - PushNotification ");
                    var notificationOption = scanner.nextInt();
                    var notifier = NotifierFactory.create(notificationOption);
                    var passenger = new Passenger(passengerName, passengerCpf, notifier);
                    flight.addPassenger(passenger);
                    break;

                case 3:
                    System.out.println("Menu Principal > Remover Passageiro");

                    System.out.println("Informe o código do voo: ");
                    var flightIdToRemove = scanner.nextLong();
                    var flightToRemove = flightRepository.findById(flightIdToRemove);

                    System.out.println("Informe o nome do passageiro: ");
                    var passengerNameToRemove = scanner.next();

                    flightToRemove.removePassenger(passengerNameToRemove);
                    break;

                case 4:
                    System.out.println("Menu Principal > Alterar Estado do Voo");

                    System.out.println("Informe o código do voo: ");
                    var flightIdToChangeState = scanner.nextLong();
                    var flightToChangeState = flightRepository.findById(flightIdToChangeState);

                    System.out.println("Informe o novo estado do voo: ");
                    System.out.println("1 - Programado");
                    System.out.println("2 - Confirmado");
                    System.out.println("3 - Cancelado");
                    System.out.println("4 - Atrasado");
                    System.out.println("5 - Mudança de portão");
                    System.out.println("6 - Concluído");
                    var stateOption = scanner.nextInt();

                    flightToChangeState.changeState(stateOption);
                    break;

                case 5:
                    System.out.println("Menu Principal > Mudar Portão de Embarque");

                    System.out.println("Informe o código do voo: ");
                    var flightIdToChangeGate = scanner.nextLong();
                    var flightToChangeGate = flightRepository.findById(flightIdToChangeGate);

                    System.out.println("Informe o novo portão de embarque: ");
                    var newGate = scanner.next();

                    flightToChangeGate.changeGate(newGate);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        }

    }
}