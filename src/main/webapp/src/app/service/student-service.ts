import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Student } from '../model/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentsUrl: string;
  private studentsSaveUrl: string;
  private baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) {
    this.studentsUrl = this.baseUrl + 'student/all';
    this.studentsSaveUrl = this.baseUrl + '/student/save';
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl);
  }

  public save(student: Student) {
    return this.http.post<Student>(this.studentsSaveUrl, student);
  }
}
