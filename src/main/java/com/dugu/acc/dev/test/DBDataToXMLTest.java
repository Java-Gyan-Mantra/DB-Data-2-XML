package com.dugu.acc.dev.test;

import com.dugu.acc.dev.service.EmployeeParseService;

public class DBDataToXMLTest {

	private static String FILE_PATH = "src/main/java/com/dugu/acc/dev/generate/files/";

	public static void main(String[] args) {

		new EmployeeParseService().convertJavaToXML(FILE_PATH + "employee.xml");
	}

}
