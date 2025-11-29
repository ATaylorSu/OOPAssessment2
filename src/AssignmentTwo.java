public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
    }

    public void partThree() {
        System.out.println("==================== Part3 ====================");

        // 1. Create operator
        Employee rideOperator = new Employee(
                "Adam",          // Person name
                30,             // Person age
                "111111111111111111", // Person personId
                "EMP-001",      // Employee employeeId
                "Ride Operator" // Employee position
        );

        Ride ferrisWheel = new Ride(
                "Dreamy Ferris Wheel",
                "Leisure category",
                rideOperator
        );

        // 3. Create 5 visitors
        System.out.println("\n1. Add 5 tourists to the Ferris wheel waiting queue:");
        ferrisWheel.addVisitorToQueue(new Visitor("Ben", 25, "222222222222222222", "TICKET-1001", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Caleb", 18, "333333333333333333", "TICKET-1002", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Daniel", 35, "444444444444444444", "TICKET-1003", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Eddie", 22, "555555555555555555", "TICKET-1004", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Ford", 28, "666666666666666666", "TICKET-1005", "2025-11-30"));

        System.out.println("\nRemove one tourist:");
        ferrisWheel.removeVisitorFromQueue();

        System.out.println("\nFerris wheel waiting queue:");
        ferrisWheel.printQueue();

        System.out.println("=====================================================================");
    }

    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}

}