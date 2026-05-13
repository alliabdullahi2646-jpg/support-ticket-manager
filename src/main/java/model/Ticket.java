package model;

public class Ticket {
    private Long ticketId;
    private String clientName;
    private String issueTitle;
    private String issueDescription;
    private PriorityLevel priorityLevel;
    private String assignedStaff;
    private TicketStatus ticketStatus;

    public Ticket(Long ticketId, String clientName, String issueTitle, String issueDescription,
                  PriorityLevel priorityLevel, String assignedStaff) {
        this.ticketId = ticketId;
        this.clientName = clientName;
        this.issueTitle = issueTitle;
        this.issueDescription = issueDescription;
        this.priorityLevel = priorityLevel;
        this.assignedStaff = assignedStaff;
        this.ticketStatus = TicketStatus.OPEN;
    }

    public Long getTicketId() { return ticketId; }
    public String getClientName() { return clientName; }
    public String getIssueTitle() { return issueTitle; }
    public String getIssueDescription() { return issueDescription; }
    public PriorityLevel getPriorityLevel() { return priorityLevel; }
    public String getAssignedStaff() { return assignedStaff; }
    public TicketStatus getTicketStatus() { return ticketStatus; }

    public void setTicketStatus(TicketStatus ticketStatus) { this.ticketStatus = ticketStatus; }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %s | %s | %s",
                ticketId, clientName, issueTitle, priorityLevel, ticketStatus, assignedStaff);
    }
}