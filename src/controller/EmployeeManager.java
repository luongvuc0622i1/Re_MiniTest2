package controller;

import model.Employee;
import model.Fulltime;
import model.Parttime;
import storage.ReadWriteFile;

import java.util.*;

public class EmployeeManager {
    public static List<Employee> employees = ReadWriteFile.readFile();

    public static List<Employee> inputDataEmployee(int amountFulltime, int amountParttime) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < amountFulltime; i++) {
            Fulltime fulltime = new Fulltime();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập vào thông tin nhân viên fulltime " + (i+1));
            System.out.printf("Nhập vào mã nhân viên: ");
            fulltime.setId(input.nextInt());
            System.out.printf("Nhập vào tên nhân viên: ");
            input.nextLine();
            fulltime.setName(input.nextLine());
            System.out.printf("Nhập vào số tuổi: ");
            fulltime.setAge(input.nextInt());
            System.out.printf("Nhập vào tiền thưởng: ");
            fulltime.setBonus(input.nextInt());
            System.out.printf("Nhập vào tiền phạt: ");
            fulltime.setFineMoney(input.nextInt());
            System.out.printf("Nhập vào tiền lương cứng: ");
            fulltime.setBaseSalary(input.nextInt());
            employees.add(fulltime);
        }
        for (int i = 0; i < amountParttime; i++) {
            Parttime parttime = new Parttime();
            Scanner input = new Scanner(System.in);
            System.out.println("Nhập vào thông tin nhân viên parttime " + (i+1));
            System.out.printf("Nhập vào mã nhân viên: ");
            parttime.setId(input.nextInt());
            System.out.printf("Nhập vào tên nhân viên: ");
            input.nextLine();
            parttime.setName(input.nextLine());
            System.out.printf("Nhập vào số tuổi: ");
            parttime.setAge(input.nextInt());
            System.out.printf("Nhập vào số giờ làm: ");
            parttime.setWorkHour(input.nextInt());
            employees.add(parttime);
        }
        return employees;
    }
    // Hien thi
    public static void display() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    //Them moi nhan vien
    public void addNewEmployee(Employee employee) {
        employees.add(employee);
        ReadWriteFile.writeFile(employees);
    }

    //    1. Lay ra luong trung binh cua cong ty
    public float getAverageSalary(){
        float sum= 0;
        for (Employee e: employees) {
            sum += e.getNetSalary();
        }
        float average = sum/employees.size();
        return average;
    }

    //    2. Lay danh sach nhan vien luong thap hon luong tb
    public List<Employee> getParttimeUnderSalary(){
        List<Employee> employeeArrayList = new ArrayList<>();
        float average = getAverageSalary();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Parttime &&
                    employees.get(i).getNetSalary()<average)
                employeeArrayList.add(employees.get(i));
        }
        return employeeArrayList;
    }

    //    3. Tinh so luong tra cho tat ca nhan vien
    public int getSumSalary() {
        int sum = 0;
        for (Employee e : employees) {
            sum += e.getNetSalary();
        }
        return sum;
    }

    //    4. Sap xep danh sach nhan vien full theo luong tang dan
    public List<Employee> sortEmployeeBySalary() {
        List<Employee> employeeArrayList = new ArrayList<>();
        Collections.sort(employees);
        for (Employee e : employees) {
            if (e instanceof Fulltime) {
                employeeArrayList.add(e);
            }
        }
        return employeeArrayList;
    }
}
