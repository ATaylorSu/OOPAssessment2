import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;

    private Queue<Visitor> waitingLine; // Store waiting tourists

    // 1. Default Constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = new Employee();
        this.waitingLine = new LinkedList<>();
    }

    // 2. Constructor with parameters
    public Ride(String rideName, String rideType, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingLine = new LinkedList<>();
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor); // Queue的offer()：添加元素（成功返回true，不抛异常）
            System.out.printf("Tourist [%s] has joined the waiting queue of [%s]\n",
                    visitor.getName(), this.rideName);
        } else {
            System.out.printf("[%s] Adding tourist failed: tourist information is empty\n", this.rideName);
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removedVisitor = waitingLine.poll(); // Queue的poll()：移除并返回队首（空则返回null）
            System.out.printf("[%s] has been removed from the waiting queue of [%s]\n",
                    removedVisitor.getName(), this.rideName);
        } else {
            System.out.printf("[%s] Removal of tourist failed: waiting queue is empty\n ", this.rideName);
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
            System.out.printf("   %d. %s\n", index++, visitor);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return 0;
    }

    @Override
    public void printRideHistory() {
    }

    @Override
    public void runOneCycle() {
    }
}