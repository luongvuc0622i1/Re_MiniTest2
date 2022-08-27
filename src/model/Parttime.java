package model;

import java.io.Serializable;

public class Parttime extends Employee implements Serializable {
    public static final int SALARYPERHOUR = 100;
    private int workHour;

    public Parttime() {
    }

    public Parttime(int id, String name, int age, int workHour) {
        super(id, name, age);
        this.workHour = workHour;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    @Override
    public int getNetSalary() {
        return (this.workHour * SALARYPERHOUR);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", workHour=" + workHour
                + '}';
    }
}
