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


/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

@Entity
@Table(name = "TEACHER")
public class Teacher{

	@Id
	@Column(name = "teacher_id")
	private String teacherId;
	@Column(name = "teacher_name")
	private String teacherName;
	@Column(name = "teacher_school_name")
	private String teacherSchoolName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTeacherId", fetch = FetchType.LAZY)
    private List<Student> studentList;
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
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
