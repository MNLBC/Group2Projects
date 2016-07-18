package com.oocl.mnlbc.java;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.Book;

public class ManyToManyDemo {
	
	private static EntityManager em = null;

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DEMO_PU");
		
		em = emf.createEntityManager();
		
		Product item1 = new Product();
		item1.setName("Book 1");
		
		Product item2 = new Product();
		item2.setName("Book 2");
		
		Book category1 = new Book();
		category1.setName("Product 1");
		
		Book category2 = new Book();
		category2.setName("Product 2");
		
		item1.getCateGory().add(category1);
		item2.getCateGory().add(category1);
		
		item1.getCateGory().add(category2);
		item2.getCateGory().add(category2);
		
		saveItem(item1);
		saveItem(item2);
		
		// Update item
		Book category3 = new Book();
		category3.setName("Product 3");
		item1.getCateGory().add(category3);
		Product itemCopy = updateItem(item1);
		
		// Find item by id
		Product itemLoaded = findItemById(itemCopy.getId());
		System.out.println(">>>>>>>>>>>>> itemLoaded's id : " + itemLoaded.getId());
		System.out.println(">>>>>>>>>>>>> number of Category itemLoaded belong to: " + itemLoaded.getCateGory().size());
		
		//Delete item
		delteItem(itemLoaded);
		
	}
	
	public static void saveItem(Product item){
		
		System.out.println(">>>>>>>>>>>>> saveItem begin...");
		
		em.getTransaction().begin();
		
		em.persist(item);
		
		em.getTransaction().commit();
		
		System.out.println(">>>>>>>>>>>>> saveItem ended");
		
	}
	
	public static Product updateItem(Product item){
		
		System.out.println(">>>>>>>>>>>>> updateItem begin...");
		
		em.getTransaction().begin();
		
		Product itemCopy = em.merge(item);
		
		em.getTransaction().commit();
		
		System.out.println(">>>>>>>>>>>>> updateItem ended");
		
		return itemCopy;
		
	}
	
	public static Product findItemById(long id) {
		
		System.out.println(">>>>>>>>>>>>> findItemById begin...");
	
		Product itemLoaded = em.find(Product.class, id);
		
		System.out.println(">>>>>>>>>>>>> findItemById ended");
		
		return itemLoaded;
		
	}
	
	public static void delteItem(Product item) {
		
		System.out.println(">>>>>>>>>>>>> delteItem begin...");
		
		em.getTransaction().begin();
		
		em.remove(item);
		
		em.getTransaction().commit();
		
		System.out.println(">>>>>>>>>>>>> delteItem ended");
		
	}

}
