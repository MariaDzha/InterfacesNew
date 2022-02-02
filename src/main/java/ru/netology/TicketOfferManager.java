package ru.netology;

import java.util.Arrays;

public class TicketOfferManager {
    private final TicketOfferRepository repository;

    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer ticketOffer) {
        repository.save(ticketOffer);
    }


    public TicketOffer[] searchByAirports(String departureAirport, String arrivalAirport) {
        TicketOffer[] ticketOffers = repository.findAll();
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticketOffer : ticketOffers){
            if (ticketOffer.getDepartureAirport().equals(departureAirport) && ticketOffer.getArrivalAirport().equals(arrivalAirport)) {
                int length = result.length + 1;
                TicketOffer[] tmp = new TicketOffer[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticketOffer;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }

}
