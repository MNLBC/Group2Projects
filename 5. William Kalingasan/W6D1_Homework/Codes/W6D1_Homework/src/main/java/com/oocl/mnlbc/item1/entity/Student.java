package com.oocl.mnlbc.item1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "W6D1_STUDENT")
public class Student implements Serializable {

	@Id
	@Column(name = "STUDENT_ID")
	private String studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "STUDENT_SCORE")
	private int studentScore;
	@JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID")
	private String teacher_Id;

	public Student() {

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	public String getTeacherId() {
		return teacher_Id;
	}

	public void setTeacherId(String teacherId) {
		this.teacher_Id = teacherId;
	}

}
