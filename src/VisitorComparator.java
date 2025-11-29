import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 1. Compare age first
        int ageCompare = v1.getAge() - v2.getAge();
        if (ageCompare != 0) {
            return ageCompare;
        }
        // 2. Same age, compare names
        return v1.getName().compareTo(v2.getName());
    }
}