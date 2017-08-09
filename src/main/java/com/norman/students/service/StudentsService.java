package com.norman.students.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.norman.students.dao.IDao;
import com.norman.students.entity.Students;

@Service
public class StudentsService {
	
	@Autowired
	@Qualifier("sqldao")
	private IDao objectDao;

	public Collection<Students> getAllStudents() {
		return this.objectDao.getAllStudents();
	}

	public Students getStudentsByID(int id) {
		return this.objectDao.getStudentsByID(id);
	}

	public String deleteStudentByID(int id) {
		return this.objectDao.deleteStudentByID(id);
	}

	public String updateStudent(Students student) {
		return this.objectDao.updateStudent(student);
	}

	public String insertStudents(Students student) {
		return this.objectDao.insertStudents(student);
	}
}
