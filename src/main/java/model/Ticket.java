package model;

public class Ticket {
    private int ticketId;
    private String clientName;
    private String issueTitle;
    private String issueDescription;
    private priorityLevel priorityLevel;
    private String assignedStaff;
    private TicketStatus ticketStatus;

    public Ticket(int ticketId, String clientName, String issueTitle, String issueDescription,
                  priorityLevel priorityLevel, String assignedStaff) {
        this.ticketId = ticketId;
        this.clientName = clientName;
        this.issueTitle = issueTitle;
        this.issueDescription = issueDescription;
        this.priorityLevel = priorityLevel;
        this.assignedStaff = assignedStaff;
        this.ticketStatus = TicketStatus.OPEN;
    }

    public int getTicketId() { return ticketId; }
    public String getClientName() { return clientName; }
    public String getIssueTitle() { return issueTitle; }
    public String getIssueDescription() { return issueDescription; }
    public priorityLevel getPriorityLevel() { return priorityLevel; }
    public String getAssignedStaff() { return assignedStaff; }
    public TicketStatus getTicketStatus() { return ticketStatus; }

    public void setTicketStatus(TicketStatus ticketStatus) { this.ticketStatus = ticketStatus; }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %s | %s | %s",
                ticketId, clientName, issueTitle, priorityLevel, ticketStatus, assignedStaff);
    }
}