package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Test {

	public static void main(String[] args) {
		
		Department dep = new Department(1, "Almoxarifado");
		System.out.println(dep);
		
		Seller seller = new Seller(1, "joao", "email", new Date(), 10.00, dep);
		System.out.println(seller);
	}

}
