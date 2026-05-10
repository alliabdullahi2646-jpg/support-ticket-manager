package main;

import model.priorityLevel;
import model.TicketStatus;
import model.Ticket;
import Service.TicketService;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TicketService service = new TicketService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== SUPPORT TICKET SYSTEM =====");
            System.out.println("1. Create Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket Status");
            System.out.println("4. Search Ticket");
            System.out.println("5. Ticket Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number 1-6.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Client name: ");
                    String name = scanner.nextLine();
                    if (InputValidator.isEmpty(name)) {
                        System.out.println("Client name cannot be empty.");
                        break;
                    }

                    System.out.print("Issue title: ");
                    String title = scanner.nextLine();
                    System.out.print("Issue description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Priority LOW/MEDIUM/HIGH/CRITICAL: ");
                    priorityLevel priority;
                    try {
                        priority = priorityLevel.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid priority.");
                        break;
                    }

                    System.out.print("Assigned staff: ");
                    String staff = scanner.nextLine();

                    Ticket t = service.createTicket(name, title, desc, priority, staff);
                    System.out.println("Created: " + t);
                    pause(scanner);
                    break;

                case 2:
                    List<Ticket> all = service.getAllTickets();
                    if (all.isEmpty()) {
                        System.out.println("No tickets found.");
                    } else {
                        System.out.println("\nID | Client | Title | Priority | Status | Staff");
                        for (Ticket ticket : all) {
                            System.out.println(ticket);
                        }
                    }
                    pause(scanner);
                    break;

                case 3:
                    System.out.print("Enter ticket ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("New status OPEN/IN_PROGRESS/RESOLVED/CLOSED: ");
                    try {
                        TicketStatus status = TicketStatus.valueOf(scanner.nextLine().toUpperCase());
                        if (service.updateStatus(id, status)) {
                            System.out.println("Status updated.");
                        } else {
                            System.out.println("Ticket not found.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid status.");
                    }
                    pause(scanner);
                    break;

                case 4:
                    System.out.print("Search by 1.ID or 2.Client Name: ");
                    int searchType = Integer.parseInt(scanner.nextLine());
                    if (searchType == 1) {
                        System.out.print("Enter ID: ");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Ticket found = service.findTicketById(searchId);
                        System.out.println(found != null ? found : "Ticket not found.");
                    } else if (searchType == 2) {
                        System.out.print("Enter client name: ");
                        String client = scanner.nextLine();
                        List<Ticket> results = service.findTicketsByClientName(client);
                        if (results.isEmpty()) {
                            System.out.println("No tickets found.");
                        } else {
                            results.forEach(System.out::println);
                        }
                    } else {
                        System.out.println("Invalid option.");
                    }
                    pause(scanner);
                    break;

                case 5:
                    System.out.println(service.getSummary());
                    pause(scanner);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    pause(scanner);
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void pause(Scanner scanner) {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}