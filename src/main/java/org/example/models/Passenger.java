package org.example.models;

public class Passenger implements Notifier {
    private final String name;
    private final String cpf;
    private Notifier notifier;

    public Passenger(String name, String cpf, Notifier notifier) {
        this.name = name;
        this.cpf = cpf;
        this.notifier = notifier;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void notify(String msg) {
        System.out.println("Passenger: "+ this.name);
        this.notifier.notify(msg);
    }

    public Notifier getNotifier() {
        return notifier;
    }

    public void setNotifier(Notifier n) {
        this.notifier = n;
    }

}
