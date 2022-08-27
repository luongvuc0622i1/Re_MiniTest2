package views;

import controller.EmployeeManager;
import model.Employee;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static controller.EmployeeManager.inputDataEmployee;

public class Main {
    public static void main(String[] args) {
        ReadWriteFile readWriteData = ReadWriteFile.getInstance();
        EmployeeManager manager = new EmployeeManager();
        List<Employee> employees = new ArrayList<>();
        try {
            Scanner can = new Scanner(System.in);
            System.out.println("Nhập số lượng nhân viên chính thức: ");
            int amountFulltime = can.nextInt();
            System.out.println("Nhập số lượng nhân viên bán thời gian: ");
            int amountParttime = can.nextInt();
            employees = inputDataEmployee(amountFulltime, amountParttime);
        } catch (InputMismatchException e) {
            System.err.println("Nhập sai cú pháp rồi!");
        } finally {
            readWriteData.writeFile(employees);
            //Yêu cầu 0: hiển thị mảng vừa nhập
            manager.display();
            //Yêu cầu 1: tính lương trung bình của toàn bộ nhân viên
            float averageSalary = manager.getAverageSalary();
            System.out.println("Lương trung bình của toàn bộ nhân viên là: " + averageSalary);
            //Yêu cầu 2: Hiện danh sách nhân viên part lương dưới mức trung bình của cty
            List<Employee> employeePartList = manager.getParttimeUnderSalary();
            System.out.println("Danh sách nhân viên part lương dưới mức trung bình là: ");
            for (Employee e : employeePartList) {
                System.out.println(e);
            }
            //Yêu cầu 3: Tính số tiền lương trả cho tất cả nhân viên
            int money = manager.getSumSalary();
            System.out.println("Số tiền lương trả cho tất cả nhân viên là: " + money);
            //Yêu cầu 4: Sắp xếp danh sách nhân viên fulltime tăng dần lương
            List<Employee> employeeFullList = manager.sortEmployeeBySalary();
            System.out.println("Danh sách nhân viên fulltime tăng dần lương là: ");
            for (Employee e : employeeFullList) {
                System.out.println(e);
            }
        }
    }
}
