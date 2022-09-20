package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: department findById ===");
        System.out.print("Enter the department Id: ");
        int id = sc.nextInt();
        Department dep = departmentDao.findById(id);
        System.out.println(dep);
    }
}
