public class Ride {
    private String rideName;    // Facility Name
    private String rideType;    // Facility type
    private Employee operator;  // Operator

    // 1. Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = new Employee();
    }

    // 2. Constructor with parameters
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
    }

    // getter
    public String getRideName() {
        return rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    // setter
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
}