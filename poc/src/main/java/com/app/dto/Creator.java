package com.app.dto;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Creator {
	@Autowired
	private SessionFactory session;
	public static void main(String args[]){
		System.out.println("Creating ......................");
		Profile profile= new Profile();
		for(int x=0;x<5;x++){
			profile.setFirstName("Nagesh"+Math.random());
			profile.setUserId("Nagesh3.13"+Math.random());
			profile.setFirstName("Nagesh"+Math.random());
			new Creator().session.getCurrentSession().save(profile);
		}
	}
}
