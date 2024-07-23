package equ.cjc.springcollageapplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Collage 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String Student;
	private String FacultyMember;
	private String Administrator;
	public String getStudent() {
		return Student;
	}
	public void setStudent(String student) {
		Student = student;
	}
	public String getFacultyMember() {
		return FacultyMember;
	}
	public void setFacultyMember(String facultyMember) {
		FacultyMember = facultyMember;
	}
	public String getAdministrator() {
		return Administrator;
	}
	public void setAdministrator(String administrator) {
		Administrator = administrator;
	}
	
	
	
	

}
