package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: Department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n=== Test 2: Department findAll ====");
		
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list ) {
			System.out.println(obj);
		}	
				
		System.out.println("\n=== Test 3: Department insert ====");
		Department newDepartment = new Department(null, "DP01");
		departmentDao.insert(newDepartment);
		System.out.println("inserted! New Id = " + newDepartment.getId());
		
		System.out.println("\n=== Test 4: Department update ====");
		department = departmentDao.findById(1);
		department.setName("DP002");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test 6: Sellet delete ====");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		departmentDao.deletedById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
		
		
	}

}
