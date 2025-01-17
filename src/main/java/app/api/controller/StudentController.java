package app.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Student;
import app.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class StudentController {
	private final StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		
		List<Student> students = studentService.getAllStudent();
		
		return students;
	}
	
	@GetMapping("/students/{sid}")
	public Student getStudent(@PathVariable Long sid) {
		
		Student student = studentService.getStudent(sid);
		
		return student;
	}
	
	@PostMapping("/students")
	public Student insertStudent(String sname) {
		Student student = studentService.insertStudent(sname);
		return student;
	}
	
	@PutMapping("/students/{sid}")
	public Student updateStudent(@PathVariable Long sid, String sname) {

		Student student = studentService.updateStudent(sid, sname);
		return student;
	} 
	
	
	@DeleteMapping("/students/{sid}")
	public void deleteStudent(@PathVariable Long sid) {
		studentService.deleteStudent(sid);
	}
}

