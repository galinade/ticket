package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.ru.netology.repository.TicketRepository;

public class TicketRepositoryTest {

    Ticket first = new Ticket(5, 123, "SVO", "KZN", 180);
    Ticket second = new Ticket(12, 128, "VKO", "KZN", 129);
    Ticket third = new Ticket(523, 217, "LED", "SVO", 85);
    Ticket first1 = new Ticket(33, 111, "KUF", "VKO", 191);
    Ticket second1 = new Ticket(78, 119, "KZN", "LED", 67);
    Ticket third1 = new Ticket(218, 116, "KUF", "VKO", 174);


    @Test
    public void muTest() {

        TicketRepository repo = new TicketRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(first1);
        repo.save(second1);
        repo.save(third1);

        repo.removeById(523);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {first, second, first1, second1, third1};
        Assertions.assertArrayEquals(expected, actual);


    }


}
