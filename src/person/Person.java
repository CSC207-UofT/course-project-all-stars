package person;

// Abstract Class Person to define the basic layout
public abstract class Person {
    int id;
    int age;
    String name;
    String sex;
    String address;

    public Person(int ID, String name, String address, String sex, int age) {
        this.id = ID;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    public int getId(){return this.id;}

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
}
