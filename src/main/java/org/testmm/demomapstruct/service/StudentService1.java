package org.testmm.demomapstruct.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.testmm.demomapstruct.model.Student;
import org.testmm.demomapstruct.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService1 {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public Student saveStudent(Student inStudent) {
        return studentRepository.save(inStudent);
    }

    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> updateStudent(Student inputDto, long studentId) {
        Optional<Student> inputStudent  = studentRepository.findById(studentId);
        if (inputStudent.isPresent()) {
            Student student = studentRepository.save(inputDto);
            return Optional.of(student);
        }
        return Optional.empty();
    }


}