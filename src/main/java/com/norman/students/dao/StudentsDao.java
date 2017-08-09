package com.norman.students.dao;

import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.norman.students.entity.Students;
import com.norman.students.exception.DaoException;
import java.util.Collection;
import java.util.HashMap;

/**
 * 
 * @author norman
 * simulate the operations of database by implementing IDao interface
 * 
 */
@Repository
@Qualifier("studentsdao")
public class StudentsDao implements IDao {
	private static Map<Integer, Students> students;

	static {
		students = new HashMap<Integer, Students>() {

			{
				put(1, new Students(1, "Norman", "Algorithm"));
				put(2, new Students(2, "Jimmy", "DataBase"));
				put(3, new Students(3, "Jane", "JAVA"));
			}
		};

	}

	@Override
	public Collection<Students> getAllStudents() {
		return this.students.values();
	}

	@Override
	public Students getStudentsByID(int id) {
		if (this.students.containsKey(id)) {
			return this.students.get(id);
		} else {
			throw new DaoException();
		}
	}

	@Override
	public String deleteStudentByID(int id) {
		if (this.students.containsKey(id)) {
			this.students.remove(id);
			return "remove id = " + id + " record";
		} else {
			throw new DaoException();
		}
	}

	@Override
	public String updateStudent(Students student) {
		if (this.students.containsKey(student.getId())) {
			Students s = this.students.get(student.getId());
			s.setName(student.getName());
			s.setCourse(student.getCourse());
			return "update successfully!!!";
		} else {
			throw new DaoException();
		}

	}

	@Override
	public String insertStudents(Students student) {
		this.students.put(student.getId(), student);
		return "insert id = " + student.getId() + " successfully!!!";
	}
}
