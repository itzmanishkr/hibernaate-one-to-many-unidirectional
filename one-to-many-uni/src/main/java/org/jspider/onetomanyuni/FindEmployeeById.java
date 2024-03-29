package org.jspider.onetomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployeeById {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id to be searched");
		int id = sc.nextInt();
		Employee emp = manager.find(Employee.class, id);
		if(emp!=null) {
			System.out.println(emp);
		}
		else {
			System.err.println("No Employee with Employee Id: " + id);
		}
		
	}
}
