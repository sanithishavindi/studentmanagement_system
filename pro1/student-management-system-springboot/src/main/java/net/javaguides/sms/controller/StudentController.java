package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RestController
@CrossOrigin("http://localhost:3306")
public class StudentController {
	@Autowired 
	private StudentRepository studentRepository;
	private StudentService studentService;

	@PostMapping("/students")
	Student newStudent(@RequestBody Student newStudent){
		return studentRepository.save(newStudent);
	}
	
	@GetMapping("/students")
	List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	

	public StudentController(StudentService studentService) {
		super();
		this.studentRepository = studentRepository;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	 @PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	 	studentService.saveStudent(student);
	 	return "redirect:/students";
 }
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setRegno(student.getRegno());
		existingStudent.setFaculty(student.getFaculty());
		existingStudent.setDegreeProgram(student.getDegreeProgram());
		existingStudent.setIntake(student.getIntake());
		existingStudent.setDob(student.getDob());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
			}
	
	//handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
