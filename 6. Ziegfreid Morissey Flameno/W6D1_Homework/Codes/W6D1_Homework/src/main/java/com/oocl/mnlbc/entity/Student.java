package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Student entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "Student")
public class Student implements Serializable {

   @Id
   // (strategy = GenerationType.AUTO)
   @Column(name = "student_id")
   private String studentId;
   @Column(name = "student_name")
   private String studentName;
   @Column(name = "student_score")
   private Integer studentScore;
   @JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private Teacher studentTeacherId;

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

   public Integer getStudentScore() {
      return studentScore;
   }

   public void setStudentScore(Integer studentScore) {
      this.studentScore = studentScore;
   }

   public Teacher getStudentTeacherId() {
      return studentTeacherId;
   }

   public void setStudentTeacherId(Teacher studentTeacherId) {
      this.studentTeacherId = studentTeacherId;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (studentId != null ? studentId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Student)) {
         return false;
      }
      Student other = (Student) object;
      if ((this.studentId == null && other.studentId != null)
         || (this.studentId != null && !this.studentId.equals(other.studentId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Student{" + "studentId=" + studentId + ", studentName='" + studentName + '\'' + '}';
   }
}
