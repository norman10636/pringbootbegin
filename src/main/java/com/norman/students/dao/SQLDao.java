package com.norman.students.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import com.norman.students.entity.Students;
import com.norman.students.exception.DaoException;

/**
 * 
 * @author norman
 * simulate the operations of database by implementing IDao interface
 * 
 */
@Repository
@Qualifier("sqldao")
public class SQLDao implements IDao {
	private static List<Students> students;
	static {
		students = new ArrayList<Students>() {
			{
				add(new Students(1, "norman", "Algebra"));
				add(new Students(2, "Jane", "SQL"));
			}
		};
	}

	@Override
	public Collection<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return this.students;
	}

	@Override
	public Students getStudentsByID(int id) {
		// TODO Auto-generated method stub
		for (int i=0;i<students.size();i++){
			if (students.get(i).getId()==id){
				return students.get(i);
			}
		}
		throw new DaoException();
	}

	@Override
	public String deleteStudentByID(int id) {
		// TODO Auto-generated method stub
		for (int i=0;i<students.size();i++){
			if (students.get(i).getId()==id){
				students.remove(i);
				return "remove id= "+id+" record successfully!!!";
			}
		}
		return "there is no such record!!!";
	}

	@Override
	public String updateStudent(Students student) {
		for (int i=0;i<students.size();i++){
			if (students.get(i).getId()==student.getId()){
				students.get(i).setCourse(student.getCourse());
				students.get(i).setName(student.getName());
				return "update successfully!!!";
			}
		}
		return "there is no such record!!!";
	}

	@Override
	public String insertStudents(Students student) {
		students.add(student);
		return "insert a new record!!!";
	}

}
