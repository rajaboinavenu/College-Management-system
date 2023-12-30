import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  student: Student = new Student();

  students: Student[] | undefined;

  constructor(private studentService: StudentService, 
              private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  public getStudents(){
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data;
    });
  }

  public getStudentsByDesc(){
    this.studentService.getStudentsListDesc().subscribe(data => {
      this.students = data;
    });
  }

  updateStudent(id: any){
    this.router.navigate(['update-student', id]);
  }

  deleteStudent(id: any){
      this.studentService.deleteStudent(id).subscribe( data => {
        console.log(data);
        this.getStudents();
      })
  }

}
