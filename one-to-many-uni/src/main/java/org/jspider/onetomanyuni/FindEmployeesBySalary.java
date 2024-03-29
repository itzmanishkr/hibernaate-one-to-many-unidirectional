package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesBySalary {

	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Salary to be searched");
		double salary=sc.nextDouble();
		Query q = manager.createQuery("select e from Employee e where e.salary=?1");
		q.setParameter(1, salary);
		List<Employee> emps = q.getResultList();
		if(!emps.isEmpty()) {
			for(Employee emp: emps) 
			System.out.println(emp);
		}
		else {
			System.err.println("No Employee with Salary: " + salary);
		}
		
	}
}
