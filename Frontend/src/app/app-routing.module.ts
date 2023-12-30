import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDepartmentComponent } from './create-department/create-department.component';
import { CreateProfessorComponent } from './create-professor/create-professor.component';
import { CreateStudentComponent } from './create-student/create-student.component';
import { DepartmentListComponent } from './department-list/department-list.component';
import { ProfessorListComponent } from './professor-list/professor-list.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateProfessorComponent } from './update-professor/update-professor.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
    { path: 'students', component : StudentListComponent},
    { path: 'students/desc', component : StudentListComponent},
    { path: 'professors', component : ProfessorListComponent},
    { path: 'professors/desc', component : ProfessorListComponent},
    { path: 'create-student', component : CreateStudentComponent},
    { path: 'create-professor', component : CreateProfessorComponent},
    { path: 'create-department', component : CreateDepartmentComponent},
    { path: 'departments', component : DepartmentListComponent},
    { path: 'departments/desc', component : DepartmentListComponent},
    { path: 'update-student/:id', component : UpdateStudentComponent},
    { path: 'update-professor/:id', component : UpdateProfessorComponent},
    { path: '', redirectTo: 'students', pathMatch: 'full'}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
