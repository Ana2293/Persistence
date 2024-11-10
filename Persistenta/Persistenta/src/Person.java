import java.io.Serializable;

public class Person implements Serializable {
    private int ID;
    private String surname;
    private int age;
    private String address;
    private double salary;

    public Person(String surname, int age, String address, double salary){
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(int ID, String surname, int age, String address, double salary){
        this.ID = ID;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public Person(){}

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
