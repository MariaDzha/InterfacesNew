package ru.netology;

public class TicketOffer implements Comparable<TicketOffer> {
    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int flightTime;

    public TicketOffer(int id, int price, String departureAirport, String arrivalAirport, int flightTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightTime = flightTime;
    }

    public int getPrice() {
        return price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public int getId() {
        return id;
    }
    @Override
    public int compareTo(TicketOffer o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }
}

