package person;

// Abstract Class Person to define the basic layout
public abstract class Person {
    private final int id;
    private final int age;
    private final String name;
    private final String sex;
    private final String address;

    //constructor for Person
    public Person(int id, String name, String address, String sex, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    //getter methods
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public int getId(){
        return id;
    }
}
