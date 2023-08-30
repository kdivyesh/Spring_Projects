package com.klu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.*;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentManger {
	@Autowired
	StudentRepository sr;
	public String insertData(Student s) {
		sr.save(s);
		return "inserted data";
	}

	public String deleteData(Long id) {
		sr.deleteById(id);
		return "deleted data";
	}
	 public List<String> readData(){
		 List<String> l=new ArrayList<String>();
		 for(Student st:sr.findAll()) {
		 l.add(convertToJson(st));
	 }
	 return l;
 }

public String convertToJson(Object obj) {
	 GsonBuilder gs=new GsonBuilder();
	 Gson gs1=gs.create();
     return gs1.toJson(obj);
	}
}
