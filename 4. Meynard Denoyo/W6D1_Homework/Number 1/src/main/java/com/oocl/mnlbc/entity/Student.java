package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "student_id")
	private String stid;
	@Column(name = "student_name")
	private String stname;
	@Column(name = "student_score")
	private int stscore;
	@JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher stteacherid;
	
	
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public int getStscore() {
		return stscore;
	}
	public void setStscore(int stscore) {
		this.stscore = stscore;
	}
	public Teacher getStteacherid() {
		return stteacherid;
	}
	public void setStteacherid(Teacher stteacherid) {
		this.stteacherid = stteacherid;
	}
	
	
}
