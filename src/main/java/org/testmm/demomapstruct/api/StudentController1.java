package org.testmm.demomapstruct.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.testmm.demomapstruct.dto.StudentDto;
import org.testmm.demomapstruct.dto.StudentRequestDto;
import org.testmm.demomapstruct.model.Student;
import org.testmm.demomapstruct.service.StudentService1;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Student1", description = "the Student1 Api")
@RequestMapping("/student1")
public class StudentController1 {
    private final StudentService1 studentService1;
    private final StudentMapper studentMapper;

    public StudentController1(StudentService1 studentService1, StudentMapper studentMapper) {
        this.studentService1 = studentService1;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/all")
    public List<StudentDto> getAll() {
        List<Student> students = studentService1.getAllStudents();
        return studentMapper.studentToStudentDto(students);
    }

    @GetMapping("/{studentId}")
    public StudentDto getById(@PathVariable long studentId) {
        Student student =  studentService1.getStudentById(studentId);
        return studentMapper.studentToStudentDto(student);
    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentRequestDto studentRequestDto) {
        Student student = studentService1.saveStudent(studentMapper.studentRequestDtoToStudent(studentRequestDto));
        return studentMapper.studentToStudentDto(student);
    }

    @PutMapping("/update/{studentId}")
    public StudentDto save(@RequestBody StudentRequestDto studentRequestDto, @PathVariable long studentId) {
        Optional<Student> student = studentService1.updateStudent(studentMapper.studentRequestDtoToStudent(studentRequestDto), studentId);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(String.format("Student not found for id :%s", studentId));
        }
        return studentMapper.studentToStudentDto(student.get());
    }

    @DeleteMapping("/delete/{studentId}")
    public String delete(@PathVariable long studentId) {
        studentService1.deleteStudent(studentId);
        return "Student deleted successfully";
    }
}

