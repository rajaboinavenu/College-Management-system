import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Department } from './department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private baseURL = "http://localhost:8086/college/departments";
  constructor(private httpClient : HttpClient) { }

  // getDepartmentsList(): Observable<Department[]>{
  //   return this.httpClient.get<Department[]>(`${this.baseURL}`);
  // }

  public getDepartmentsList() {
    return this.httpClient.get<Department[]>(`${this.baseURL}`);
  }

  getDepartmentsListDesc(): Observable<Department[]>{
    return this.httpClient.get<Department[]>(`${`http://localhost:8086/college/departments/byDesc`}`);
  }

  createDepartment(department: Department): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,department);
  }

  deleteDepartment(id: any): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
