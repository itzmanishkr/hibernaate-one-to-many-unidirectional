package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeesByDeptIdAndName {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Id and Name to be searched");
		int id=sc.nextInt();
		String dname =sc.next();
		Query q = manager.createQuery("select d.emps from Department d where d.id=?1 and d.name=?2");
		q.setParameter(1, id);
		q.setParameter(2, dname);
		
		
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
