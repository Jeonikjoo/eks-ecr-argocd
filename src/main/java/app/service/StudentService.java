package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Student;
import app.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll().stream().toList();
	}

	public Student getStudent(Long sid) {
		
		return studentRepository.findById(sid).orElseThrow();
	}

	@Transactional
	public Student insertStudent(String sname) {
		
		Student student = new Student();
		student.setName(sname);
		
		Student result = studentRepository.save(student);
	
		return result;
	}
	
	@Transactional
	public Student updateStudent(Long sid, String sname) {
		
		Student student = studentRepository.findById(sid).orElseThrow();
		student.setName(sname);
		
		return student;
	}

	public void deleteStudent(Long sid) {
		studentRepository.deleteById(sid);
		
	}

	

	
}
