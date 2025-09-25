package org.testmm.demomapstruct.api;

import org.mapstruct.Mapper;
import org.testmm.demomapstruct.dto.StudentDto;
import org.testmm.demomapstruct.dto.StudentRequestDto;
import org.testmm.demomapstruct.model.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentRequestDto studentToStudentRequestDto(Student student);

    StudentDto studentToStudentDto(Student student);

    List<StudentDto> studentToStudentDto(List<Student> student);

    Student  studentDtoToStudent(StudentDto student);
}
