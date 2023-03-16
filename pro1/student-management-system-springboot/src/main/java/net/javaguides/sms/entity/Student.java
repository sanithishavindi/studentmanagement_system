package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "student_name", nullable = false)
	private String studentName;
	
	@Column(name = "regno")
	private String regno;
	
	@Column(name = "faculty")
	private String faculty;

	@Column(name = "degreeProgram")
	private String degreeProgram;

	@Column(name = "intake")
	private String intake;
	
	public Student() {
		
	}
	
	public Student(String studenttName, String regno, String faculty, String degreeProgram, String intake) {
		super();
		this.studentName = studentName;
		this.regno = regno;
		this.faculty = faculty;
		this.degreeProgram=degreeProgram;
		this.intake=intake;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDegreeProgram() {
		return degreeProgram;
	}

	public void setDegreeProgram(String degreeProgram) {
		this.degreeProgram = degreeProgram;
	}

	public String getIntake() {
		return intake;
	}

	public void setIntake(String intake) {
		this.intake = intake;
	}

	
	
}
