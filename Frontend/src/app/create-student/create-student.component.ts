import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {
  // students: Student[] = [];

    student: Student = new Student();
    studentForm!: FormGroup;
  constructor(private studentService:StudentService, 
              private router:Router, private fb: FormBuilder) { 
                this.studentForm = this.fb.group({
                  firstName: ['', [Validators.required, Validators.maxLength(50)]],
                  lastName: ['', [Validators.required, Validators.maxLength(50)]],
                  email: ['', [Validators.required, Validators.email]],
                  departmentName: ['', Validators.required]
                });
              }


              

  ngOnInit(): void {
  }

    goToStudentList(){
      this.router.navigate(['/students']);
    }

    onSubmit(): void {
      if (this.studentForm.valid) {
        this.studentService.createStudent(this.studentForm.value).subscribe(
          (response) => {
            console.log('Student created successfully:', response);
            this.goToStudentList();
            // You can add further actions, like showing a success message or redirecting the user
          },
          (error) => {
            console.error('Error creating student:', error);
            // Handle the error, show an error message, etc.
          }
        );
      }
    }
    onReset(): void {
      this.studentForm.reset();
    }
    

}
