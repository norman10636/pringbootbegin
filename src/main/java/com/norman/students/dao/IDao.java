package com.norman.students.dao;

import java.util.Collection;

import com.norman.students.entity.Students;

public interface IDao {

	Collection<Students> getAllStudents();

	Students getStudentsByID(int id);

	String deleteStudentByID(int id);

	String updateStudent(Students student);

	String insertStudents(Students student);

}