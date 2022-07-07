package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.ru.netology.repository.TicketRepository;
import ru.netology.manager.TicketManager;

public class TicketManagerTest {
    Ticket first = new Ticket(5, 123, "SVO", "KZN", 180);
    Ticket second = new Ticket(12, 128, "VKO", "KZN", 129);
    Ticket third = new Ticket(523, 217, "KUF", "SVO", 85);
    Ticket first1 = new Ticket(33, 211, "KUF", "VKO", 191);
    Ticket second1 = new Ticket(78, 119, "KZN", "LED", 67);
    Ticket third1 = new Ticket(218, 116, "KUF", "VKO", 174);

    @Test
    public void shouldFindAndSort() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(first1);
        manager.add(second1);
        manager.add(third1);

        Ticket[] actual = manager.findTickets("KUF", "VKO");
        Ticket[] expected = {third1, first1};

        Assertions.assertArrayEquals(expected, actual);
    }

}
