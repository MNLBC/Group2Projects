package edu.javacourse.jpa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "w6d1_teacher")
public class Teacher implements Serializable {

    @Id
//            (strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_school_name")
    private String teacherSchoolName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public Teacher() {
    }

    public Teacher(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }
 
    public Teacher(Integer teacherId, String teacherName, String teacherSchoolName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSchoolName = teacherSchoolName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Region{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName +
                ", teacherSchoolName=" + teacherSchoolName +
                '\'' + '}';
    }
}
