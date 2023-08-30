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
import com.klu.model.StudentUpdate;

@RestController
@RequestMapping("/hello")
public class StudentController {
	@Autowired
	StudentManger sm;
	@Autowired
	StudentUpdate su;
	@PostMapping("/insert")
	public String insert(@RequestBody Student s1) {
		return sm.insertData(s1);
		
	}
	
	@PutMapping("/update/{id}/{amount}")
	public String updateStatus(@PathVariable("id") Long id,@PathVariable("amount") int amount ) {
		return su.updateData(id, amount);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		return sm.deleteData(id);
		
	}
	@GetMapping("/read")
	public String readDat() {
	return sm.readData().toString();}
	
}

