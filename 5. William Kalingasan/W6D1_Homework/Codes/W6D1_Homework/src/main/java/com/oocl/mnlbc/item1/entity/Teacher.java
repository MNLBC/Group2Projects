package com.oocl.mnlbc.item1.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "W6D1_TEACHER")
public class Teacher implements Serializable {

	@Id
	@Column(name = "TEACHER_ID")
	private String teacherId;
	@Column(name = "TEACHER_NAME")
	private String teacherName;
	@Column(name = "TEACHER_SCHOOL_NAME")
	private String teacherSchoolName;
	
	public Teacher() {
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSchoolName() {
		return teacherSchoolName;
	}

	public void setTeacherSchoolName(String teacherSchoolName) {
		this.teacherSchoolName = teacherSchoolName;
	}
}
