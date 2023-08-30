package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentUpdate {
	@Autowired
	StudentRepository sr;
	
	public String updateData(Long id,int amount) {
		Student temp=sr.findById(id).get();
		temp.setAmount(temp.getAmount()+amount);
		if(temp.getAmount()>=2000) {
			temp.setStatus("Fully Paid");
		}
		else if(temp.getAmount()==0) {
			temp.setStatus("Not paid");
		}
		else {
			
			temp.setStatus("Partial");
		}
		
		sr.save(temp);
		return "payment status updated succesfully";
		
	}

}
