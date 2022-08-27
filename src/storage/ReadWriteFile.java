package storage;

import model.Employee;

import java.io.*;
import java.util.List;

public class ReadWriteFile {
    private static ReadWriteFile instance=null;

    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance(){
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }
    public static void writeFile(List<Employee> employees){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("employee.dat");
            ObjectOutputStream ost = new ObjectOutputStream(fileOutputStream);
            ost.writeObject(employees);
            ost.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFile(){
        try {
            FileInputStream fis = new FileInputStream("employee.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object ob = ois.readObject();
            List<Employee> employees = (List<Employee>) ob;
            ois.close();
            fis.close();
            return employees;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
