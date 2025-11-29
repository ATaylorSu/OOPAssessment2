public class Visitor extends Person {
    private String visitorTicketNumber; // Ticket number
    private String visitDate;          // Visit date

    // 1. Default constructor
    public Visitor() {
        super();
        this.visitorTicketNumber = "TICKET-000";
        this.visitDate = "Unknown";
    }

    // 2. Constructor with parameters
    public Visitor(String name, int age, String personId, String visitorTicketNumber, String visitDate) {
        super(name, age, personId); // Initialize the three properties of the parent class
        this.visitorTicketNumber = visitorTicketNumber;
        this.visitDate = visitDate;
    }

    // 3. Getter for subclass specific properties
    public String getVisitorTicketNumber() {
        return visitorTicketNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    // 4. Setter for subclass specific properties
    public void setVisitorTicketNumber(String visitorTicketNumber) {
        this.visitorTicketNumber = visitorTicketNumber;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}