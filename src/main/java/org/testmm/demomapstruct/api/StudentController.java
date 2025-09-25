package org.testmm.demomapstruct.api;

import org.testmm.demomapstruct.dto.StudentDto;
import org.testmm.demomapstruct.dto.StudentRequestDto;
import org.testmm.demomapstruct.model.Student;
import org.testmm.demomapstruct.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@Tag(name = "Student", description = "the Student Api")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public StudentDto getById(@PathVariable long studentId) {
        Optional<StudentDto> resultDto =  studentService.getStudentById(studentId);
        if (resultDto.isEmpty()) {
            throw new StudentNotFoundException(String.format("Student not found for id :%s", studentId));
        }
        return resultDto.get();
    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.saveStudent(studentRequestDto);
    }

    @PutMapping("/update/{studentId}")
    public StudentDto save(@RequestBody StudentRequestDto studentRequestDto, @PathVariable long studentId) {
        Optional<StudentDto> resultDto = studentService.updateStudent(studentRequestDto, studentId);
        if (resultDto.isEmpty()) {
            throw new StudentNotFoundException(String.format("Student not found for id :%s", studentId));
        }
        return resultDto.get();
    }

    @DeleteMapping("/delete/{studentId}")
    public String delete(@PathVariable long studentId) {
        studentService.deleteStudent(studentId);
        return "Student deleted successfully";
    }
}
