package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesByName {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name to be searched");
		String name=sc.next();
		Query q = manager.createQuery("select e from Employee e where e.name=?1");
		q.setParameter(1, name);
		List<Employee> emps = q.getResultList();
		if(!emps.isEmpty()) {
			for(Employee emp: emps) 
			System.out.println(emp);
		}
		else {
			System.err.println("No Employee with Employee Name: " + name);
		}
		
	}
}
