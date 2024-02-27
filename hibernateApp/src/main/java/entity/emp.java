package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class emp {
    @Id
    private int uid;
    private String name;
    private int age;
    private int salary;
    private String desig;
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getDesig() {
        return desig;
    }
    public void setDesig(String Desig) {
        this.desig = Desig;
    }

}
