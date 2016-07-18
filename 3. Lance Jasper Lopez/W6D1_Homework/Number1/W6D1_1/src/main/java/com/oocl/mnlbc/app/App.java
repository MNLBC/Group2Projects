package com.oocl.mnlbc.app;

import com.oocl.mnlbc.model.Student;
import com.oocl.mnlbc.model.Teacher;
import com.oocl.mnlbc.service.TeacherSVC;

public class App {
	public static void main(String[] args) {
		TeacherSVC teach = new TeacherSVC();
		teach.init();
		Teacher teacher = new Teacher();
		teacher = teach.listTeacherStudGrades("1");
		System.out.println("Id:" + teacher.getTeacherId());
		System.out.println("Name:" + teacher.getTeacherName());
		System.out.println("School:" + teacher.getTeacherSchoolName());

		int ctr = 0;
		double average = 0;
		for (Student student : teacher.getStudentList()) {
			average += student.getStudentScore();
			ctr++;
			if (ctr == teacher.getStudentList().size()) {
				average /= ctr;
			}
		}
		System.out.println("Score Average:" + average);

	}
}
