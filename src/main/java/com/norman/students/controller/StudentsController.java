package com.norman.students.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.norman.students.entity.Students;
import com.norman.students.service.StudentsService;

@RestController
@RequestMapping(value="/students")
public class StudentsController {
	@Autowired
	private StudentsService studentsService;

	@RequestMapping(method=RequestMethod.GET)
	public Collection<Students> getAllStudents() {
	return this.studentsService.getAllStudents();
	}
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public Students getStudentsByID(@PathVariable("id")int id){
	return this.studentsService.getStudentsByID(id);
	}
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String deleteStudentByID(@PathVariable("id")int id){
	return this.studentsService.deleteStudentByID(id);
	}
	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Students student){
	return this.studentsService.updateStudent(student);
	}
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String insertStudents(@RequestBody Students student){
	return this.studentsService.insertStudents(student);
	}
}
