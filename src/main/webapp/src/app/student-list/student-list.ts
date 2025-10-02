import {Component, DoCheck, OnInit} from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../service/student-service';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-student-list',
  templateUrl: './student-list.html',
  styleUrl: './student-list.scss'
})
export class StudentList implements OnInit, DoCheck {

  students: Student[] = []; // Default value

  constructor(private studentService: StudentService) {
  }

  ngOnInit() {
    this.loadData();
  }

  ngDoCheck() {
    console.log("in ngDoCheck");
    this.loadData();

  }

  loadData(): void {
    this.studentService.findAll().subscribe(data => {
      this.students = data;
    });
  }


}
