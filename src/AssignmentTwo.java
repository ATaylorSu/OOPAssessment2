public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partFourA();
    }

    public void partThree() {
        System.out.println("==================== Part3 ====================");
        Employee rideOperator = new Employee(
                "Adam",
                30,
                "111111111111111111",
                "EMP-001",
                "Ride Operator"
        );
        Ride ferrisWheel = new Ride("Dreamy Sky", "Leisure category", rideOperator);
        System.out.println("\n1. Add 5 tourists to the Ferris wheel waiting queue:");
        ferrisWheel.addVisitorToQueue(new Visitor("Ben", 25, "222222222222222222", "TICKET-1001", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Caleb", 18, "333333333333333333", "TICKET-1002", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Daniel", 35, "444444444444444444", "TICKET-1003", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Eddie", 22, "555555555555555555", "TICKET-1004", "2025-11-30"));
        ferrisWheel.addVisitorToQueue(new Visitor("Ford", 28, "666666666666666666", "TICKET-1005", "2025-11-30"));
        System.out.println("\n2. Remove 1 tourist:");
        ferrisWheel.removeVisitorFromQueue();
        System.out.println("\n3. Printing the final waiting queue for the Ferris wheel:");
        ferrisWheel.printQueue();
        System.out.println("=====================================================================");
    }

    public void partFourA() {
        System.out.println("==================== Part4A ====================");

        Employee adam = new Employee(
                "Adam",
                30,
                "111111111111111111",
                "EMP-001",
                "Ride Operator"
        );

        Ride ferrisWheel = new Ride("Dreamy Sky", "Leisure category", adam);

        System.out.println("\n1. Add 5 tourists to the Ferris wheel waiting queue:");
        Visitor ben = new Visitor("Ben", 25, "222222222222222222", "TICKET-1001", "2025-11-30");
        Visitor caleb = new Visitor("Caleb", 18, "333333333333333333", "TICKET-1002", "2025-11-30");
        Visitor daniel = new Visitor("Daniel", 35, "444444444444444444", "TICKET-1003", "2025-11-30");
        Visitor eddie = new Visitor("Eddie", 22, "555555555555555555", "TICKET-1004", "2025-11-30");
        Visitor ford = new Visitor("Ford", 28, "666666666666666666", "TICKET-1005", "2025-11-30");

        ferrisWheel.addVisitorToHistory(ben);
        ferrisWheel.addVisitorToHistory(caleb);
        ferrisWheel.addVisitorToHistory(daniel);
        ferrisWheel.addVisitorToHistory(eddie);
        ferrisWheel.addVisitorToHistory(ford);

        // 4.Check if a tourist is in history
        System.out.println("\n2. Check if tourist Ben is in the cycling history:");
        ferrisWheel.checkVisitorFromHistory(ben);

        // 5. Print the number of historical cycling tourists
        System.out.println("\n3. View the number of tourists with cycling history:");
        ferrisWheel.numberOfVisitors();

        // 6. Print complete cycling history
        System.out.println("\n4. Print complete cycling history:");
        ferrisWheel.printRideHistory();

        System.out.println("======================================================================");
    }

    public void partFourB() {}
    public void partSix() {}
    public void partSeven() {}

}