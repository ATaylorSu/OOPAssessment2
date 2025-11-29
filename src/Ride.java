import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private Queue<Visitor> waitingLine;

    private LinkedList<Visitor> rideHistory;

    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = new Employee();
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }

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

    @Override
    public void runOneCycle() {
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
}