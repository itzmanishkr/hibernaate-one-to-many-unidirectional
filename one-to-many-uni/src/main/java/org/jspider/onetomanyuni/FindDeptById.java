package org.jspider.onetomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindDeptById {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter id to be searched");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		
		Department dept = manager.find(Department.class, id);
		if(dept!=null) {
			System.out.println(dept);
		}
		else {
			System.err.println("No Dept with Id: " +id);
		}
		
	}
}
