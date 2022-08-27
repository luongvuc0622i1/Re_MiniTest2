package model;

import java.io.Serializable;

public class Fulltime extends Employee implements Serializable {
    private int bonus;
    private int fineMoney;
    private int baseSalary;

    public Fulltime() {
    }

    public Fulltime(int id, String name, int age, int bonus, int fineMoney, int baseSalary) {
        super(id, name, age);
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(int fineMoney) {
        this.fineMoney = fineMoney;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public int getNetSalary() {
        return (this.baseSalary + this.baseSalary + this.fineMoney);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", bonus=" + bonus
                + ", fineMoney=" + fineMoney
                + ", baseSalary=" + baseSalary
                + '}';
    }
}
