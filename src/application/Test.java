package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("***** Test 1 - Seller findById *******");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);
		
	}

}
