package application;

import java.util.Iterator;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("***** Test 1 - Seller findById *******");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
		System.out.println("\n***** Test 2 - Seller findByDepartment*******");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller s : list) {
			System.out.println(s);
		}
		
	}

}
