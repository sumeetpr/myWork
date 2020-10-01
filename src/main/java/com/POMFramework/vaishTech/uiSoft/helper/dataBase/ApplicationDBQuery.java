package com.POMFramework.vaishTech.uiSoft.helper.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDBQuery {
	
	
	public int getEmployeeSalary(int empid) throws SQLException {
		
		int salary=0;
		String dbQuery = "Select *from employee where id = "+empid;
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while(result.next()) {
			
			salary = Integer.parseInt(result.getString("salary"));
			
		}
		
		return salary;
	}
	
	public List<Employee> getEmployeeData() throws SQLException {
		
		List<Employee> data = new ArrayList<Employee>();
//		Employee emp = new Employee();
		String dbQuery = "Select *from employee";
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		
		while(result.next()) {
			Employee emp = new Employee();
			emp.setEmpId(Integer.parseInt(result.getString("id")));
			emp.setSalary(Integer.parseInt(result.getString("salary")));
			emp.setName(result.getString("name"));
			emp.setDept(result.getString("dept"));
			data.add(emp);
			
		}
		
		return data;
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		ApplicationDBQuery app = new ApplicationDBQuery();
		List<Employee> data = app.getEmployeeData();
		for (Employee e : data) {
			
			System.out.println("empid="+e.getEmpId()+"Name="+e.getName()+"Name="+e.getSalary()+"Dept="+e.getDept());
			
		}
	}

}
