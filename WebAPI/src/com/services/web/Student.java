package com.services.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	private int student_id;
	private String first_name;
	private String last_name;
	private int batch_id;
	private String gender;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return this.getStudent_id()+" "+this.getFirst_name()+" "+this.getLast_name()
		+" "+this.getBatch_id()+" "+this.getGender();
	}
	
}
