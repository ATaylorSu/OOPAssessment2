// Visitor.java：补充toString()方法，用于打印游客详情
public class Visitor extends Person {
    // Part1原有属性（不变）
    private String visitorTicketNumber;
    private String visitDate;

    // Part1原有构造器（不变）
    public Visitor() {
        super();
        this.visitorTicketNumber = "TICKET-000";
        this.visitDate = "Unknown";
    }

    public Visitor(String name, int age, String personId, String visitorTicketNumber, String visitDate) {
        super(name, age, personId);
        this.visitorTicketNumber = visitorTicketNumber;
        this.visitDate = visitDate;
    }

    public String getVisitorTicketNumber()
    {
        return visitorTicketNumber;
    }

    public void setVisitorTicketNumber(String visitorTicketNumber)
    {
        this.visitorTicketNumber = visitorTicketNumber;
    }

    public String getVisitDate()
    {
        return visitDate;
    }

    public void setVisitDate(String visitDate)
    {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Visitor {name='%s', age=%d, ID number number='%s', ticket number='%s', visit date='%s'}",
                super.getName(),
                super.getAge(),
                super.getPersonId(),
                this.visitorTicketNumber,
                this.visitDate
        );
    }
}