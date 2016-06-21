package com.oocl.mnlbc.homework.w2.d2;

public class EmployeeJBDCTest {
	private static final int NULL = 0;

	public static void main(String args[]) {
		EmployeeJDBC.getAll();
	    
	    EmployeeJDBC.insert(new Employee(1, "Rose", "Tyler", 4, 1500));
	    EmployeeJDBC.insert(new Employee(2, "Matha", "Jones",4, 2200));
	    EmployeeJDBC.insert(new Employee(3, "Donna", "Noble", 4, 1300));
	    EmployeeJDBC.insert(new Employee(4, "Doctor", "Who", NULL ,5500));
	    EmployeeJDBC.insert(new Employee(5, "Jack", "Harkness", 1 ,3500));
	    EmployeeJDBC.getAll();
	    
	    EmployeeJDBC.insert(new Employee(6, "Alex", "Lee", 1 ,4500));
	    EmployeeJDBC.getAll();
	    EmployeeJDBC.update(new Employee(2, "Matha", "Tate",4, 2200),"Jones");
	    EmployeeJDBC.getAll();
	}

}

