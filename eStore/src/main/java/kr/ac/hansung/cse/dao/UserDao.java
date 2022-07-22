package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.User;

@Repository
@Transactional // 각각의 메소드를 프랜젝션으로
public class UserDao {
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session.saveOrUpdate(user);
		
		session.flush();
	}

	public User getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId); //id에 해당되는 객체를 DB에서 조회
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User wherer username = ?");
		query.setParameter(0, username);
		
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User>getAllUsers(){
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User");
		List<User> userList = query.getResultList();
		
		return userList;
	}
	
	
}
