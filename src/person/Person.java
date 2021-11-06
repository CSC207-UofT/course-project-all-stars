package person;

// Abstract Class Person to define the basic layout
public abstract class Person {
    int age;
    String name;
    String sex;
    String address;

    public Person(String name, String address, String sex, int age) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

//    public Person(String name, String address, String sex, int age) {
//    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
