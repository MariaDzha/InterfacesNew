package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketOfferManagerTest {
    TicketOfferRepository ticketOfferRepository = new TicketOfferRepository();
    TicketOfferManager ticketOfferManager = new TicketOfferManager(ticketOfferRepository);

    TicketOffer ticketOffer1 = new TicketOffer(1, 10_000, "BER", "CDG", 70);
    TicketOffer ticketOffer2 = new TicketOffer(2, 12_000, "BER", "CDG", 80);
    TicketOffer ticketOffer3 = new TicketOffer(3, 15_000, "BER", "CDG", 55);
    TicketOffer ticketOffer4 = new TicketOffer(4, 10_000, "BTS", "CDG", 60);

    @BeforeEach
    public void addTicketOffer() {
        ticketOfferManager.add(ticketOffer1);
        ticketOfferManager.add(ticketOffer2);
        ticketOfferManager.add(ticketOffer3);
        ticketOfferManager.add(ticketOffer4);
    }

    @Test
    public void ShouldSortByAirports() {
        TicketOffer[] results = ticketOfferManager.searchByAirports("BER", "CDG");
        TicketOffer[] expected = new TicketOffer[3];
        expected[0]= ticketOffer1;
        expected[1]= ticketOffer2;
        expected[2]= ticketOffer3;
        assertEquals(expected.length, results.length);
        assertArrayEquals(expected, results);
        }
}
