package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Danna Soquiat
 * @since 2016-07-18
 *
 *
 */


@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@Column(name = "student_id")
	private String studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_score")
	private int studentScore;
	@JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher studentTeacherId;
	
	
	public String getStid() {
		return studentId;
	}
	public void setStid(String stid) {
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
	public void setStscore(int studentScore) {
		this.studentScore = studentScore;
	}
	public Teacher getStudentTeacherId() {
		return studentTeacherId;
	}
	public void setStudentTeacherId(Teacher studentTeacherId) {
		this.studentTeacherId = studentTeacherId;
	}
	
	
}
