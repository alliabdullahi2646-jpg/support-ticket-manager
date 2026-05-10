package model;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private String clientName;
    private String issueTitle;
    private priorityLevel priorityLevel;
    private String assignedStaff;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;

    public Ticket(int ticketId, String clientName, String issueTitle, priorityLevel priorityLevel, String assignedStaff) {
        this.ticketId = ticketId;
        this.clientName = clientName;
        this.issueTitle = issueTitle;
        this.priorityLevel = priorityLevel;
        this.assignedStaff = assignedStaff;
        this.ticketStatus = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + ticketId + "] " + clientName + " - " + issueTitle + " - " + priorityLevel + " - " + assignedStaff + " - " + ticketStatus;
    }
}
