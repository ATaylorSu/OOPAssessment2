import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = new Employee();
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
            System.out.printf("[%s] The maximum number of tourists per visit has been set to:%d people\n", this.rideName, maxRider);
        } else {
            System.out.printf("[%s] Setting maximum number of tourists failed: ≥ 1 person is required (current input:%d)\n", this.rideName, maxRider);
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }
    public Queue<Visitor> getWaitingLine() { return waitingLine; }


    // ------ part3/part4 ------
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
            System.out.printf("Tourist [%s] has joined the waiting queue of [%s]\n", visitor.getName(), this.rideName);
        } else {
            System.out.printf("[%s] Adding tourist failed: tourist information is empty\n", this.rideName);
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll();
            System.out.printf("[%s] has been removed from the waiting queue of [%s]\n", removedVisitor.getName(), this.rideName);
        } else {
            System.out.printf("[%s] Removal of tourist failed: waiting queue is empty\n", this.rideName);
        }
    }

    @Override
    public void printQueue() {
        System.out.printf("\nWaiting queue for [%s] (total of% d people):\n", this.rideName, waitingLine.size());
        if (waitingLine.isEmpty()) {
            System.out.println("(No tourists in the queue)");
            return;
        }
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.printf("%d.%s\n", index++, visitor);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor); // LinkedList的add()：添加到末尾
            System.out.printf("Tourist [%s] has joined [%s]'s cycling history\n", visitor.getName(), this.rideName);
        } else {
            System.out.printf("[%s] Adding cycling history failed: tourist information is empty", this.rideName);
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.printf("[%s] Checking cycling history failed: tourist information is empty\n", this.rideName);
            return false;
        }
        // Traverse history: Determine by "ticket number"
        boolean isExist = false;
        for (Visitor v : rideHistory) {
            if (v.getVisitorTicketNumber().equals(visitor.getVisitorTicketNumber())) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.printf("Tourist [%s] (ticket number:%s) in the cycling history of [%s]\n",
                    visitor.getName(), visitor.getVisitorTicketNumber(), this.rideName);
        } else {
            System.out.printf("Tourist [%s] (ticket number:%s) is not in [%s]'s cycling history\n",
                    visitor.getName(), visitor.getVisitorTicketNumber(), this.rideName);
        }
        return isExist;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.printf("The cycling history of [%s] has a total of% d people\n", this.rideName, count);
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.printf("\n Cycling history of [%s] (total of% d people):\n", this.rideName, rideHistory.size());
        if (rideHistory.isEmpty()) {
            System.out.println("(No tourists in cycling history)");
            return;
        }

        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.printf("%d. %s\n", index++, visitor);
        }
    }

    public void sortRideHistory(VisitorComparator comparator) {
        if (rideHistory.isEmpty()) {
            System.out.printf("[%s] Sorting failed: No tourists in cycling history\n", this.rideName);
            return;
        }
        if (comparator == null) {
            System.out.printf("[%s] Sorting failed: Sorter is empty\n", this.rideName);
            return;
        }

        Collections.sort(rideHistory, comparator);
        System.out.printf("The cycling history of [%s] has been sorted according to the rules (age ascending → name ascending)\n", this.rideName);
    }

    // ------ part5 ------
    public void runOneCycle() {
        System.out.printf("\n[%s] Start attempting to run a cycling cycle once\n", this.rideName);

        // 1. Pre check 1: Whether there is an operator
        if (operator == null || operator.getEmployeeId().equals("EMP-000")) {
            System.out.printf("[%s] Running failed: No valid operator assigned\n", this.rideName);
            return;
        }

        // 2. Pre check 2: Check if there are any tourists in the waiting queue
        if (waitingLine.isEmpty()) {
            System.out.printf("[%s] Running failed: Waiting queue is empty, no tourists can ride\n", this.rideName);
            return;
        }

        // 3. Calculate the number of tourists that can be carried this time
        int availableVisitors = waitingLine.size();
        int ridersToTake = Math.min(maxRider, availableVisitors);
        System.out.printf("[%s] Number of tourists that can be carried in this cycle:% d people (remaining queue:% d people, maximum capacity:% d people)\n",
                this.rideName, ridersToTake, availableVisitors, maxRider);

        // 4. Move a specified number of tourists from the queue to the cycling history
        for (int i = 0; i < ridersToTake; i++) {
            Visitor rider = waitingLine.poll();
            if (rider != null) {
                addVisitorToHistory(rider);
            }
        }

        // 5. Cycling cycle times+1
        numOfCycles++;

        // 6. Print successful running message
        System.out.printf("[%s] Cycling cycle running successfully! Current total number of runs:% d times\n", this.rideName, numOfCycles);
    }

    // ------ part6 ------
    public void exportRideHistory(String filePath) {
        System.out.printf("\nStarting to export the cycling history of [%s] to CSV file:%s\n", this.rideName, filePath);

        if (rideHistory.isEmpty()) {
            System.out.printf("Export failed: The cycling history of [%s] is empty\n", this.rideName);
            return;
        }

        try (
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write("Name, age, ID number number, ticket number, visit date");
            bufferedWriter.newLine();

            for (Visitor visitor : rideHistory) {
                String csvLine = String.format(
                        "%s,%d,%s,%s,%s",
                        visitor.getName(),          // Name
                        visitor.getAge(),           // Age
                        visitor.getPersonId(),      // ID Number
                        visitor.getVisitorTicketNumber(), // Ticket Number
                        visitor.getVisitDate()      // Visit Date
                );
                bufferedWriter.write(csvLine);
                bufferedWriter.newLine();
            }

            System.out.printf("Export successful! A total of% d tourist records were exported to:%s\n", rideHistory.size(), filePath);

        } catch (IOException e) {
            System.out.printf("Export failed! IO exception:%s\n", e.getMessage());
            e.printStackTrace();
        }
    }

    // ------ part7 ------
    public void importRideHistory(String filePath) {
        System.out.printf("\nStarting to import cycling history from CSV file:%s\n", filePath);

        // 1. Initialize counter
        int importedCount = 0;
        int skippedCount = 0;

        // 2. Read and parse CSV (try catch captures multiple types of exceptions)
        try (
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            boolean isFirstLine = true;

            // Read CSV line by line
            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    skippedCount++;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length != 5) {
                    System.out.printf("Skip invalid lines: incorrect number of fields (5 required, current% d) - %s\n", fields.length, line);
                    skippedCount++;
                    continue;
                }

                try {
                    String name = fields[0].trim();
                    int age = Integer.parseInt(fields[1].trim());
                    String personId = fields[2].trim();
                    String ticketNumber = fields[3].trim();
                    String visitDate = fields[4].trim();

                    Visitor importedVisitor = new Visitor(name, age, personId, ticketNumber, visitDate);
                    rideHistory.add(importedVisitor);
                    importedCount++;

                } catch (NumberFormatException e) {
                    System.out.printf("Skip invalid line: Age format error (integer required) - %s\n", line);
                    skippedCount++;
                }
            }

            System.out.printf("Import completed! Successfully imported %d records, skipped %d invalid records\n", importedCount, skippedCount);

        } catch (java.io.FileNotFoundException e) {
            System.out.printf("Import failed: File does not exist - %s\n", filePath);
        } catch (IOException e) {
            System.out.printf("Import failed: IO exception - %s\n", e.getMessage());
        }
    }
}


