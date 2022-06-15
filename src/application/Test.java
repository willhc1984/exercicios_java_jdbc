package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("***** Test 1 - Seller findById *******");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
		System.out.println("\n***** Test 2 - Seller findByDepartment *******");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n***** Test 3 - Seller findAll *******");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n***** Test 4 - Seller insert *******");
		Seller seller2 = new Seller(null, "Ellon Musk", "ellon@gmail", new Date(), 4000.00, department);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = " + seller2.getId());
		
		System.out.println("\n***** Test 5 - Seller update *******");
		Seller seller3 = sellerDao.findById(5);
		seller3.setBaseSalary(12000.00);
		sellerDao.update(seller3);
		System.out.println("Updated! Seller id = " + seller3.getId());
		
		System.out.println("\n***** Test 6 - Seller delete *******");
		sellerDao.deleteById(9);
		System.out.println("Delete!");
	}

}
