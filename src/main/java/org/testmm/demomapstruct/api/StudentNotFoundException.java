package org.testmm.demomapstruct.api;

public class StudentNotFoundException extends RuntimeException{

    StudentNotFoundException(String message) {
        super(message);
    }
}
