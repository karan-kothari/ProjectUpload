package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;

@Repository
public class CountryDao {

	@Autowired
	SessionFactory factory;
	
	

	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is addedd...";
		}catch (Exception e) {
						
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;
	}

	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction tx=null;
		String msg= null;
		
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
	 Country country=session.get(Country.class, id);
	 country.setCname(c.getCname());
		
		session.merge(country);
		tx.commit();
		
		msg="Country is updatated";
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;

	}

	public String deleteCountry(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {		
		 session= factory.openSession();
		 tx=session.beginTransaction();
		 Country country= session.get(Country.class, id);
		
		 session.remove(country);
		 tx.commit();
		 
		 msg="Record is Deleted";
		}catch (Exception e1) {
			if(tx!=null) {
				tx.rollback();
			}
						
			e1.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session=null;
		Transaction tx=null;
		String strQuery="from Country";
		List<Country> list=null;
		try {
	
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Query<Country> query=session.createQuery(strQuery,Country.class);
		
		 list=query.list();
	     tx.commit();
	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
		return list;
}

	public Country getParticularCountryByID(int id) {
		Session  session=null;
		Transaction tx=null;
		Country country=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			country=session.get(Country.class, id);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return country;
	}

	public String addEmployee(Employee emp) {
		Session session= null;
		Transaction tx= null;
		String msg=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg="Recod is Adeed.....";
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String upadteEmployee(Employee emp) {
		Session session=null;
		Transaction tx= null;
		String msg= null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee employee= session.get(Employee.class, emp.getId());
			
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setPhoneno(emp.getPhoneno());
			employee.setSalary(emp.getSalary());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setCreatedby(emp.getCreatedby());
			employee.setUpdatedtm(emp.getUpdatedtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setEmailid(emp.getEmailid());
			
			session.merge(employee);
			tx.commit();
			msg="Employee record is Upadated.....";
		
		    
		   } catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return msg;
	}

	public String deletEmplpoyee(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Employee employee=session.get(Employee.class, id);
		session.remove(employee);
		tx.commit();
		msg="Employee record is deleted....";
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session= null;
		Transaction tx= null;
		String strQuery="from Employee";
		List<Employee> list=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(strQuery,Employee.class);
			
			 list=query.list();
			tx.commit();
		} catch (Exception e) {
	     if(tx!=null) {
	    	 tx.rollback();
	     }e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee getEmployeeByParticlarId(int id) {
		Session session=null;
		Transaction tx= null;
		Employee employee = null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
		     employee=session.get(Employee.class, id);
		     tx.commit();
			
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
	}

	

	public List<Employee> getEmployeeByStatus(String status) {
		Session session= null;
		Transaction tx= null;
		List<Employee> list=null;
		String strQuery="from Employee where status=:mystatus";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(strQuery,Employee.class);
			
			query.setParameter("mystatus", status);
			
			 list=query.list();
			tx.commit();
		} catch (Exception e) {
	     if(tx!=null) {
	    	 tx.rollback();
	     }e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;

	}

	public Employee loginCheck(Employee emp) {
		Session session= null;
		Transaction tx= null;
        Employee employee = null;
		String hqlQuery="from Employee where emailid=:myemailid and phoneno=:myphoneno";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphoneno", emp.getPhoneno());
			
			employee=query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
	     if(tx!=null) {
	    	 tx.rollback();
	     }e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;

	}

	public List<Employee> getemployeesalarygreatorthan(double salary) {
		Session session= null;
		Transaction tx= null;
		List<Employee> list=null;
		String strQuery="from Employee where salary <= :mysalary";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query=session.createQuery(strQuery,Employee.class);
			
			query.setParameter("mysalary", salary);
			
			 list=query.list();
			tx.commit();
		} catch (Exception e) {
	     if(tx!=null) {
	    	 tx.rollback();
	     }e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}
	
}