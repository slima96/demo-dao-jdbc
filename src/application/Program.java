package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
				
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: Sellet findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Test 2: Sellet findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: Sellet findAll ====");
		
		list = sellerDao.findAll();
		
		for (Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: Sellet insert ====");
		Seller newSeller = new Seller(null, "Sandro Lima", "lima@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("inserted! New Id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: Sellet update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		
	}

}
