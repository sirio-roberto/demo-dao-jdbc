package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller s : sellers)
            System.out.println(s);

        System.out.println();
        System.out.println("=== TEST 3: seller findByAll ===");
        sellers = sellerDao.findAll();
        for (Seller s : sellers)
            System.out.println(s);

        System.out.println();
        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmil.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted: " + newSeller.getId());

        System.out.println();
        System.out.println("=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Beltrao");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("=== TEST 6: seller delete ===");
        System.out.print("Enter Id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();
    }
}