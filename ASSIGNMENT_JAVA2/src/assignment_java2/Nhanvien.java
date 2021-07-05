package assignment_java2;

import java.io.Serializable;

public class Nhanvien implements Serializable {

    private String id;
    private String name;
    private double age;
    private String email;
    private double salary;

    public Nhanvien() {
    }

    public Nhanvien(String id, String name, double age, String email, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
