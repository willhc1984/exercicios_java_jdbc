package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** Test 1 - Insert Department ****");
		Department dep = new Department(null, "Juridico");
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		depDao.insert(dep);
		System.out.println("Inserted! Department id: " + dep.getId());
		
		System.out.println("**** Test2 - update department ****");
		Department dep2 = new Department(6, "Secretaria");
		depDao.update(dep2);
		System.out.println("Updated! - Department id: " + dep2.getId());
		
		System.out.println("**** Test3 - Delete department ****");
		System.out.print("Type department id: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Deleted! Department id: " + id);
		
		System.out.println("**** Test4 - get department by Id 1 ****");
		System.out.print("Type department id: ");
		id = sc.nextInt();
		Department dep4 = depDao.findById(id);
		System.out.println(dep4);
		
		System.out.println("**** Test5 - Department Get All");
		List<Department> list = depDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
	}

}
