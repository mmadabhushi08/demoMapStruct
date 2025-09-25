package org.testmm.demomapstruct.service;

import org.testmm.demomapstruct.api.StudentNotFoundException;
import org.testmm.demomapstruct.dto.StudentDto;
import org.testmm.demomapstruct.dto.StudentRequestDto;
import org.testmm.demomapstruct.model.Student;
import org.testmm.demomapstruct.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream()
                .map(s -> new StudentDto(s.getStudentId(), s.getName(), s.getAddr(), s.getScore()))
                .collect(Collectors.toList());
    }

    public Optional<StudentDto> getStudentById(long studentId) {
        Optional<Student> student  = studentRepository.findById(studentId);
        if (student.isPresent()) {
            Student s = student.get();
           return Optional.of(new StudentDto(s.getStudentId(), s.getName(), s.getAddr(), s.getScore()));
        }
        return  Optional.empty();
    }

    public StudentDto saveStudent(StudentRequestDto inputDto) {
        Student student = new Student();
        student.setName(inputDto.getName());
        student.setAddr(inputDto.getAddr());
        student.setScore(inputDto.getScore());

        Student s =  studentRepository.save(student);
        return new StudentDto(s.getStudentId(), s.getName(), s.getAddr(), s.getScore());
    }

    public Optional<StudentDto> updateStudent(StudentRequestDto inputDto, long studentId) {
        Optional<Student> inputStudent  = studentRepository.findById(studentId);
        if (inputStudent.isPresent()) {
            Student student = inputStudent.get();
            student.setName(inputDto.getName());
            student.setAddr(inputDto.getAddr());
            student.setScore(inputDto.getScore());
            Student s =  studentRepository.save(student);
            return Optional.of(new StudentDto(s.getStudentId(), s.getName(), s.getAddr(), s.getScore()));
        }
        return Optional.empty();
    }

    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }
}
