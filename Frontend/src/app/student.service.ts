import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Student } from './student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseURL = "http://localhost:8086/college/students";
  
  constructor(private httpClient : HttpClient) { }

  getStudentsList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  getStudentsListDesc(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${`http://localhost:8086/college/students/byDesc`}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,student);
  }

  getStudentById(id: number): Observable<Student>{
      return this.httpClient.get<Student>(`${this.baseURL}/${id}`);
  }

  // updateStudent(id: number,student: Student): Observable<Object>{
  //   return this.httpClient.put(`${this.baseURL}/${id}`,student);
  // }

  updateStudent(id: any, student: Student): Observable<any> {
    return this.httpClient.put(`${this.baseURL}/${id}`, student);
  }

  deleteStudent(id: any): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
