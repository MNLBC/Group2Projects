

CREATE TABLE Teacher (
  teacher_id VARCHAR2(100) NOT NULL,
  teacher_name VARCHAR2(100) NULL,
  teacher_school_name VARCHAR2(100) NULL,
  PRIMARY KEY (teacher_id))
;


CREATE TABLE Student (
  student_id VARCHAR2(100) NOT NULL,
  student_name VARCHAR2(100) NULL,
  student_score NUMBER(10) NULL,
  student_teacherid VARCHAR2(100) NOT NULL,
  PRIMARY KEY (student_id, student_teacherid)
 ,
  CONSTRAINT fk_Student_Teacher
    FOREIGN KEY (student_teacherid)
    REFERENCES Teacher (teacher_id)
   )
;

CREATE INDEX fk_Student_Teacher_idx ON Student (student_teacherid ASC);