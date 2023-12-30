import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { DepartmentListComponent } from './department-list/department-list.component';
import { DepartmentService } from './department.service';
import { StudentService } from './student.service';
import { CreateStudentComponent } from './create-student/create-student.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ProfessorService } from './professor.service';
import { ProfessorListComponent } from './professor-list/professor-list.component';
import { CreateProfessorComponent } from './create-professor/create-professor.component';
import { UpdateProfessorComponent } from './update-professor/update-professor.component';
import { CreateDepartmentComponent } from './create-department/create-department.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    DepartmentListComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    ProfessorListComponent,
    CreateProfessorComponent,
    UpdateProfessorComponent,
    CreateDepartmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [DepartmentService,StudentService,ProfessorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
