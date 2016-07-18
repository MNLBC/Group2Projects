package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher{

	@Id
	@Column(name = "teacher_id")
	private String tid;
	@Column(name = "teacher_name")
	private String tname;
	@Column(name = "teacher_school_name")
	private String tschoolname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stteacherid", fetch = FetchType.LAZY)
    private List<Student> studentList;
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTschoolname() {
		return tschoolname;
	}
	public void setTschoolname(String tschoolname) {
		this.tschoolname = tschoolname;
	}
}
