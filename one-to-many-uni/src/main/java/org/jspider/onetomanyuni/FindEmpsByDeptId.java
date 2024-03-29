package org.jspider.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmpsByDeptId {

	public static void main(String[] args) {
		System.out.println("Enter the department id to display employees");
		int id = new Scanner(System.in).nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "select d.emps from Department d where d.id=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);
		
		List<Employee> emps = q.getResultList();
		if(emps.size()>0)
		{
			for(Employee emp : emps) {
				System.out.println(emp);
			}
		}
		else {
			System.err.println("No Employees in department");
		}
	}
}
