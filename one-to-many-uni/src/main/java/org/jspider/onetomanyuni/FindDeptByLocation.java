package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDeptByLocation {

public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter Location of department to be searched");
		Scanner sc = new Scanner(System.in);
		String loc = sc.nextLine();
		
		Query q = manager.createQuery("select d from Department d where d.location =:loc");
		q.setParameter("loc", loc);
		
			List<Department> depts = q.getResultList();
			if(!depts.isEmpty()) {
				
				for(Department d : depts)
					System.out.println(d);
			
		}  else {
			System.err.println("No Dept in loc: " +loc);
		}
		
			
	}

}
