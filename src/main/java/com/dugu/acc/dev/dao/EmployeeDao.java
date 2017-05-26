package com.dugu.acc.dev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.dugu.acc.dev.model.EmployeeModel;

public class EmployeeDao {

	public Session getSession() {
		return new Configuration()
				.configure("com/dugu/acc/dev/config/hibernate.cfg.xml")
				.buildSessionFactory().openSession();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<EmployeeModel> getEmployees() {
		return getSession().createCriteria(EmployeeModel.class).list();
	}
}
