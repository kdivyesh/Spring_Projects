package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Student;
import com.klu.model.StudentManger;

@RestController
@RequestMapping("/hello")
public class StudentController {
	@Autowired
	StudentManger sm;
	@PostMapping("/insert")
	public String insert(@RequestBody Student s1) {
		return sm.insertData(s1);
		
	}
	@GetMapping("/read")
	public List<Student> read(){
		return sm.readData();
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id,@RequestBody Student s) {
		return sm.updateData(id,s);
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		return sm.deleteData(id);
	}

}
