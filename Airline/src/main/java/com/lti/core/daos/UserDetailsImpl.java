package com.lti.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.UserDetails;



@Repository
public class UserDetailsImpl implements UserDetailsDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
	@Override
	public boolean userRegistration(UserDetails userDetails) {
		manager.persist(userDetails);
		
		
		
		
		return true;
	}

	@Override
	public UserDetails userLogin(String userName, String password) {
		String strQry = "select p.password  from UserDetails p where p.email =:userName";
		
		 Query q = manager.createQuery(strQry);
//		 
		 q.setParameter("userName", userName);
		 String pass= (String) q.getSingleResult();
		 System.out.println(pass);
		 return null;
	}

//	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
//	@Override
//	public boolean insertDept(Department d) throws HrException {
//		// TODO Auto-generated method stub
//	    manager.persist(d);
//		return true;
//	}
	

}
