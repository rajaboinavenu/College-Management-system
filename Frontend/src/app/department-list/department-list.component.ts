import { Component, OnInit } from '@angular/core';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})
export class DepartmentListComponent implements OnInit {
  departments: any;

  constructor(private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.getDepartments();
  }

  public getDepartments(){
    this.departmentService.getDepartmentsList().subscribe(data => {
      this.departments = data;
    });
  }

  public getDepartmentsByDesc(){
    this.departmentService.getDepartmentsListDesc().subscribe(data => {
      this.departments = data;
    });
  }

  deleteDepartment(id: any){
    this.departmentService.deleteDepartment(id).subscribe( data => {
      console.log(data);
      this.getDepartments();
    })
}


}
