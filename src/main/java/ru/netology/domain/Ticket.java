package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int time;

    public Ticket(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && time == ticket.time && Objects.equals(departure, ticket.departure) && Objects.equals(arrival, ticket.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departure, arrival, time);
    }
}
