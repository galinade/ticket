package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.domain.ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDeparture().contains(from) && ticket.getArrival().contains(to)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}




