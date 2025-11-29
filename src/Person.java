public abstract class Person {
    private String name;       // Name
    private int age;           // Age
    private String personId;   // Unique identification (such as ID number/tourist ID)

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.personId = "Unknown";
    }

    public Person(String name, int age, String personId) {
        this.name = name;
        this.age = age;
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPersonId() {
        return personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Age input is invalid, please re-enter (0-150)");
        }
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}