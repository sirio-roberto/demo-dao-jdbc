package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: department findById ===");
        System.out.print("Enter the department Id: ");
        // int id = Integer.parseInt(sc.nextLine());
        int id = 1;
        Department dep = departmentDao.findById(id);
        System.out.println(dep);

        System.out.println();
        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== TEST 3: department insert ===");
        Department dep2 = new Department();
        dep2.setName("Food");
        departmentDao.insert(dep2);
        System.out.println("Departmet Inserted! " + dep2);

        System.out.println();
        System.out.println("=== TEST 4: department update ===");
        dep2.setId(6);
        dep2.setName("Drinks");
        departmentDao.update(dep2);
        System.out.println("Department updated: " + departmentDao.findById(dep2.getId()));
    }
}
