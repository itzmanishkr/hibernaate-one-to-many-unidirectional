package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesByDeptIdAndLocation {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EMployee Department Id and Location to be searched");
		
		int id=sc.nextInt();
		sc.nextLine();
		String location =sc.nextLine();
		
		Query q = manager.createQuery("select d.emps from Department d where d.id=?1 and d.location=?2");
		q.setParameter(1, id);
		q.setParameter(2, location);
		
		
		List<Employee> emps =  q.getResultList();
		if(!emps.isEmpty()) {
			for(Employee emp : emps)
				System.out.println(emp);
		}
		else {
			System.err.println("Invalid Department Id or Employee name");
		}
		
//		try {
//			Employee emp = (Employee) q.getSingleResult();
//			System.out.println(emp);
//		} catch(NoResultException e) {
//			System.err.println("Invalid Department Id or Employee name");
//		}

		
		
	}
}
