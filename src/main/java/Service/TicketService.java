package Service;

import model.Ticket;
import model.priorityLevel;
import model.TicketStatus;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();
    private int idCounter = 1;

    public Ticket createTicket(String clientName, String issueTitle, priorityLevel priority, String assignedStaff) {
        Ticket ticket = new Ticket(idCounter++, clientName, issueTitle, priority, assignedStaff);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public void updateStatus(int ticketId, TicketStatus newStatus) {
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId) {
                t.setTicketStatus(newStatus);
                return;
            }
        }
        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    public Ticket findTicketById(int ticketId) {
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId) {
                return t;
            }
        }
        return null;
    }

    public void deleteTicket(int ticketId) {
        tickets.removeIf(t -> t.getTicketId() == ticketId);
    }
}