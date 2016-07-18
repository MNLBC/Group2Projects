package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "teacher_id")
   private String teacherId;
   @Column(name = "teacher_name")
   private String teacherName;
   @Column(name = "teacher_school_name")
   private String teacherSchoolName;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTeacherId", fetch = FetchType.LAZY)
   private List<Student> studentList;

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

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (teacherId != null ? teacherId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Teacher)) {
         return false;
      }
      Teacher other = (Teacher) object;
      if ((this.teacherId == null && other.teacherId != null)
         || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      int ave = 0;
      for (Student s : studentList) {
         ave += s.getStudentScore();
      }
      if (studentList.size() > 0) {
         ave = ave / studentList.size();
      }
      return "com.oocl.mnlbc.entity.Teacher[ teacherId=" + teacherId + ", teacherName=" + teacherName
         + ", teacherSchoolName=" + teacherSchoolName + ", studentAverage=" + ave + " ]";
   }
}
