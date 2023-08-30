package com.klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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
	public List<Student> readData(){
		
			List<Student>list=sr.findAll();
			return list;
		
	}
	public String updateData(Long id,Student s) {
		Student temp=sr.findById(id).get();
		temp.setSid(s.getSid());
		temp.setSname(s.getSname());
		temp.setSdept(s.getSdept());
		sr.save(temp);
		return "Updated data";
	}
	public String deleteData(Long id) {
		sr.deleteById(id);
	    return "deleted sucessfull"	;
	}
	
	

}
