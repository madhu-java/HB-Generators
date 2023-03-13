package com.madhu.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;

public class TestApp {
	public static void main(String[] args) {
Session session =null;
Transaction  transaction=null;
boolean flag=false;
Integer id =null;

try {
	session=HibernateUtil.getSession();
	if(session!=null)
		transaction= session.beginTransaction();
	if(transaction!=null) {
		Student student = new Student();
		student.setSaddress("MI");
		student.setSage(35);
		student.setSname("sachin");
		 id = (Integer) session.save(student);
		 flag=true;
	}
	
}catch(HibernateException e) {
	e.printStackTrace();
}catch(Exception e) {
	e.printStackTrace();
}finally {
	if(flag) {
		transaction.commit();
		System.out.println("record inserted successfully...");
	}else {
		transaction.rollback();
		System.out.println("record insertion failed...");
	}
	HibernateUtil.closeSession(session);
	HibernateUtil.closeSessionFactory();
}
	}
}
