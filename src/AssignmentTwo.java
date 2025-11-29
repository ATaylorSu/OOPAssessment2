public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        // demo.partThree();
        // demo.partFourA();
        // demo.partFourB();
        // demo.partFive();
        demo.partSix();
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

    public void partFourB() {
        System.out.println("==================== Part4B ====================");

        Employee adam = new Employee(
                "Adam",
                30,
                "111111111111111111",
                "EMP-001",
                "Ride Operator"
        );

        Ride ferrisWheel = new Ride("Dreamy Sky", "Leisure category", adam);
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

        // Print the history before sorting (original order added: Ben → Caleb → Daniel → Eddie → Ford)
        System.out.println("\n1. Cycling history before sorting (original order of addition):");
        ferrisWheel.printRideHistory();

        // 4. 执行排序（使用自定义VisitorComparator）
        System.out.println("\n2. Sort the cycling history:");
        VisitorComparator ageNameComparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(ageNameComparator);

        // 5. 打印排序后的历史（预期顺序：Caleb(18)→Eddie(22)→Ben(25)→Ford(28)→Daniel(35)）
        System.out.println("\n3. Sorted cycling history (ascending age → ascending name):");
        ferrisWheel.printRideHistory();

        System.out.println("=======================================================================");
    }

    public void partFive() {
        System.out.println("==================== Part5 ====================");

        Employee adam = new Employee(
                "Adam",
                30,
                "111111111111111111",
                "EMP-001",
                "Ride Operator"
        );

        Ride ferrisWheel = new Ride("Dreamy Sky", "Leisure category", adam);
        ferrisWheel.setMaxRider(3); //Set a maximum of 3 people per session

        System.out.println("\n1. Add 10 tourists to the waiting queue for the Ferris wheel:");
        Visitor ben = new Visitor("Ben", 25, "222222222222222222", "TICKET-1001", "2025-11-30");
        Visitor caleb = new Visitor("Caleb", 18, "333333333333333333", "TICKET-1002", "2025-11-30");
        Visitor daniel = new Visitor("Daniel", 35, "444444444444444444", "TICKET-1003", "2025-11-30");
        Visitor eddie = new Visitor("Eddie", 22, "555555555555555555", "TICKET-1004", "2025-11-30");
        Visitor ford = new Visitor("Ford", 28, "666666666666666666", "TICKET-1005", "2025-11-30");

        Visitor grace = new Visitor("Grace", 24, "777777777777777777", "TICKET-1006", "2025-11-30");
        Visitor henry = new Visitor("Henry", 30, "888888888888888888", "TICKET-1007", "2025-11-30");
        Visitor ivy = new Visitor("Ivy", 21, "999999999999999999", "TICKET-1008", "2025-11-30");
        Visitor jack = new Visitor("Jack", 27, "101010101010101010", "TICKET-1009", "2025-11-30");
        Visitor kim = new Visitor("Kim", 32, "121212121212121212", "TICKET-1010", "2025-11-30");

        ferrisWheel.addVisitorToQueue(ben);
        ferrisWheel.addVisitorToQueue(caleb);
        ferrisWheel.addVisitorToQueue(daniel);
        ferrisWheel.addVisitorToQueue(eddie);
        ferrisWheel.addVisitorToQueue(ford);
        ferrisWheel.addVisitorToQueue(grace);
        ferrisWheel.addVisitorToQueue(henry);
        ferrisWheel.addVisitorToQueue(ivy);
        ferrisWheel.addVisitorToQueue(jack);
        ferrisWheel.addVisitorToQueue(kim);

        // 4. Print
        System.out.println("\n2. Waiting queue before running the cycling cycle:");
        ferrisWheel.printQueue();

        // 5. Run a cycling cycle
        System.out.println("\n3. Perform a cycling cycle:");
        ferrisWheel.runOneCycle();

        // 6. Print
        System.out.println("\n4. Waiting queue after cycling cycle:");
        ferrisWheel.printQueue();

        // 7. Print
        System.out.println("\n5. Cycling history after running the cycling cycle:");
        ferrisWheel.printRideHistory();

        // 8. Verify the number of cycling cycles (from 0 to 1)
        System.out.printf("\n6. The current total number of runs of the Ferris wheel:% d times\n", ferrisWheel.getNumOfCycles());

        System.out.println("=======================================================================");
    }

    public void partSix() {
        System.out.println("==================== Part6 ====================");

        Employee adam = new Employee(
                "Adam",
                30,
                "111111111111111111",
                "EMP-001",
                "Ride Operator"
        );

        Ride ferrisWheel = new Ride("Dreamy Sky", "Leisure category", adam);
        ferrisWheel.setMaxRider(3); //Set a maximum of 3 people per session

        System.out.println("\n1. Add 10 tourists to the waiting queue for the Ferris wheel:");
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

        // 4. Export cycling history to CSV file
        System.out.println("\n2. Export cycling history to CSV file:");
        String csvFilePath = "ferris_wheel_history.csv";
        ferrisWheel.exportRideHistory(csvFilePath);

        System.out.println("==========================================================================");
    }
    public void partSeven() {}

}