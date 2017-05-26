package com.dugu.acc.dev.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.dugu.acc.dev.dao.EmployeeDao;
import com.dugu.acc.dev.dto.Employee;
import com.dugu.acc.dev.dto.EmployeeList;
import com.dugu.acc.dev.model.EmployeeModel;

public class EmployeeParseService {

	public List<EmployeeModel> getEmployees() {
		return new EmployeeDao().getEmployees();
	}

	public List<Employee> convertModelToDto() {
		List<Employee> employees = new ArrayList<>();

		/*
		 * In java 7 for(EmployeeModel e:getEmployees()){ employees.add(new
		 * Employee(e.getId(), e.getName(), e .getDept(), e.getSalary())); }
		 */
		getEmployees().stream().forEach(
				e -> employees.add(new Employee(e.getId(), e.getName(), e
						.getDept(), e.getSalary())));
		return employees;
	}

	public void convertJavaToXML(String FileNameToBeGenerate) {
		EmployeeList employeeList = new EmployeeList();
		employeeList.setEmployee(convertModelToDto());
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(employeeList, new File(FileNameToBeGenerate));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
