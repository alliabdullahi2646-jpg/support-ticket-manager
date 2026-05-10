package model;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private String clientName;
    private String issueTitle;
    private priorityLevel PriorityLevel;
    private String assignedStaff;
    private TicketStatus ticketStatus;
    private LocalDateTime createdAt;

    public Ticket(int ticketId, String clientName, String issueTitle, priorityLevel priorityLevel, String assignedStaff) {
        this.ticketId = ticketId;
        this.clientName = clientName;
        this.issueTitle = issueTitle;
        this.PriorityLevel = priorityLevel;
        this.assignedStaff = assignedStaff;
        this.ticketStatus = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();
    }
    public int getTicketId() {
        return ticketId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public priorityLevel getPriorityLevel() {
        return PriorityLevel;
    }

    public String getAssignedStaff() {
        return assignedStaff;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setAssignedStaff(String assignedStaff) {
        this.assignedStaff = assignedStaff;
    }



    @Override
    public String toString() {
        return "[" + ticketId + "] " + clientName + " - " + issueTitle + " - " + PriorityLevel + " - " + assignedStaff + " - " + ticketStatus;
    }
}
