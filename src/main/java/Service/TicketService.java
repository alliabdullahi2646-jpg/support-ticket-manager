package Service;

import model.PriorityLevel;
import model.Ticket;
import model.TicketStatus;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();
    private Long nextId = 1L;  // <--- add this line

    public Ticket createTicket(String clientName, String issueTitle, String issueDescription,
                               PriorityLevel priority, String assignedStaff) {
        Ticket ticket = new Ticket(nextId++, clientName, issueTitle, issueDescription, priority, assignedStaff);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Ticket findTicketById(int ticketId) {
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId) {
                return t;
            }
        }
        return null;
    }

    public List<Ticket> findTicketsByClientName(String name) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getClientName().toLowerCase().contains(name.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    public boolean updateStatus(int ticketId, TicketStatus newStatus) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            ticket.setTicketStatus(newStatus);
            return true;
        }
        return false;
    }

    public boolean deleteTicket(int ticketId) {
        return tickets.removeIf(t -> t.getTicketId() == ticketId);
    }

    public String getSummary() {
        int total = tickets.size();
        long open = tickets.stream().filter(t -> t.getTicketStatus() == TicketStatus.OPEN).count();
        long resolved = tickets.stream().filter(t -> t.getTicketStatus() == TicketStatus.RESOLVED).count();
        long highPriority = tickets.stream().filter(t -> t.getPriorityLevel() == PriorityLevel.HIGH ||
                t.getPriorityLevel() == PriorityLevel.CRITICAL).count();
        return String.format("Total: %d | Open: %d | Resolved: %d | High/Critical: %d",
                total, open, resolved, highPriority);
    }
}