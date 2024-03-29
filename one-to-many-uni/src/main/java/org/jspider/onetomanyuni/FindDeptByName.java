package org.jspider.onetomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDeptByName {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter Department name to be searched");
		Scanner sc = new Scanner(System.in);
		String deptname = sc.next();
		
		Query q = manager.createQuery("select d from Department d where d.name =:name");
		q.setParameter("name", deptname);
		try {
			Department dept = (Department) q.getSingleResult();
			System.out.println(dept);
			
		}  catch(NoResultException e) {
			System.err.println("No Dept with Name: " +deptname);
		}
		
			
	}

}
