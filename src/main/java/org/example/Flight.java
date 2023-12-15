package org.example;

import org.example.models.Aircraft;
import org.example.models.Passenger;
import org.example.states.ScheduledState;
import org.example.states.State;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private final long id;
    private String departures;
    private String arrivals;
    private String date;
    private String departureTime;
    private String arrivalTime;
    private final String gate;
    private Aircraft aircraft;
    private final List<Passenger> passengers = new ArrayList<>();
    private State state;

    public Flight(long id, String departures, String arrivals, String date, String departureTime, String arrivalTime, String gate, Aircraft aircraft) {
        this.id = id;
        this.departures = departures;
        this.arrivals = arrivals;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gate = gate;
        this.aircraft = aircraft;
        this.state = new ScheduledState(this);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) throws Exception {
        state.addPassenger(passenger);
    }

    public void removePassenger(String name) throws Exception {
        state.removePassenger(name);
    }

    public void changeState(int stateOption) throws Exception {
        try {
            state.changeState(stateOption);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setState(State state) {
        this.state = state;
        this.notifyPassengers();
    }

    public void notifyPassengers() {
        state.notifyPassengers();
    }

    public long getId() {
        return id;
    }

    public String getDepartures() {
        return departures;
    }

    public void setDepartures(String departures) {
        this.departures = departures;
    }

    public String getArrivals() {
        return arrivals;
    }

    public void setArrivals(String arrivals) {
        this.arrivals = arrivals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) throws Exception {
        state.changeGate(gate);
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public boolean isFull() {
        return this.passengers.size() >= this.aircraft.getCapacity();
    }

    public void changeGate(String newGate) {
        try {
            state.changeGate(newGate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

