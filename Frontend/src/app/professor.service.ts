import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professor } from './professor';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  private baseURL = "http://localhost:8086/college/professors";

  constructor(private httpClient : HttpClient) { }

  getProfessorsList(): Observable<Professor[]>{
    return this.httpClient.get<Professor[]>(`${this.baseURL}`);
  }

  getProfessorsListDesc(): Observable<Professor[]>{
    return this.httpClient.get<Professor[]>(`${`http://localhost:8086/college/professors/byDesc`}`);
  }

  createProfessor(professor: Professor): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,professor);
  }

  getProfessorById(id: number): Observable<Professor>{
      return this.httpClient.get<Professor>(`${this.baseURL}/${id}`);
  }

  updateProfessor(id: any, professor: Professor): Observable<any> {
    return this.httpClient.put(`${this.baseURL}/${id}`, professor);
  }

  deleteProfessor(id: any): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
