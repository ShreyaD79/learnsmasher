import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Event {
    private String title;
    private String date;

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

class Calendar {
    private List<Event> events;

    public Calendar() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added successfully.");
    }

    public void updateEvent(int index, Event updatedEvent) {
        if (index >= 0 && index < events.size()) {
            events.set(index, updatedEvent);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

    public void deleteEvent(int index) {
        if (index >= 0 && index < events.size()) {
            events.remove(index);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Invalid event index.");
        }
    }

    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("Events:");
            for (int i = 0; i < events.size(); i++) {
                Event event = events.get(i);
                System.out.println((i + 1) + ". " + event.getTitle() + " on " + event.getDate());
            }
        }
    }
}

public class CalendarApp {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCalendar Application");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Display Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter event title: ");
                    scanner.nextLine(); // Consume newline character
                    String title = scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String date = scanner.nextLine();
                    Event event = new Event(title, date);
                    calendar.addEvent(event);
                    break;
                case 2:
                    calendar.displayEvents();
                    System.out.print("Enter event index to update: ");
                    int updateIndex = scanner.nextInt();
                    System.out.print("Enter new event title: ");
                    scanner.nextLine(); // Consume newline character
                    String updatedTitle = scanner.nextLine();
                    System.out.print("Enter new event date: ");
                    String updatedDate = scanner.nextLine();
                    Event updatedEvent = new Event(updatedTitle, updatedDate);
                    calendar.updateEvent(updateIndex - 1, updatedEvent);
                    break;
                case 3:
                    calendar.displayEvents();
                    System.out.print("Enter event index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    calendar.deleteEvent(deleteIndex - 1);
                    break;
                case 4:
                    calendar.displayEvents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid date");
            }
        }
    }
}