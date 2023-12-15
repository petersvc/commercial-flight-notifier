package org.example.models;

public class Ticket {

  private String passengerName;
  private String nomeDoVoo;
  private String time;
  private String date;
  private String departures;
  private String destino;


  public Ticket(String time, String date, String departures,
                String destino, String nomeDoPassageiro, String nomeDoVoo) {
    this.time = time;
    this.date = date;
    this.departures = departures;
    this.destino = destino;
    this.passengerName = nomeDoPassageiro;
    this.nomeDoVoo = nomeDoVoo;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String novoHorario) {
    this.time = novoHorario;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String novaData) {
    this.date = novaData;
  }

  public String getDepartures() {
    return this.departures;
  }

  public String getDestino() {
    return destino;
  }

  public String getPassengerName() {
    return passengerName;
  }

  public String getNomeDoVoo() {
    return nomeDoVoo;
  }
}