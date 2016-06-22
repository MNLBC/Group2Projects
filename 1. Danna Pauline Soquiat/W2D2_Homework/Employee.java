package com.oocl.mnlbc.homework.w2.d2;

public class Employee {
		public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getMgrid() {
		return mgrid;
	}


	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


		private int Id;
	    private String fname;
	    private String lname;
	    private int mgrid;
	    private int salary;
	    

		Employee(int Id, String fname, String lname, int mgrid, int salary) {
	        this.Id = Id;
	        this.fname = fname;
	        this.lname = lname;
	        this.mgrid = mgrid;
	        this.salary = salary;

	        
	   }

		
	}


