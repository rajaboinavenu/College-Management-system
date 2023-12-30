import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from '../professor';
import { ProfessorService } from '../professor.service';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css']
})
export class ProfessorListComponent implements OnInit {

  professor: Professor = new Professor();
  professors: Professor[] | undefined;

constructor(private professorService:ProfessorService , 
              private router: Router) { }

  ngOnInit(): void {
    this.getProfessors();
  }

  updateProfessor(id: any){
    this.router.navigate(['update-professor', id]);
  }

  public getProfessors(){
    this.professorService.getProfessorsList().subscribe(data => {
      this.professors = data;
    });
  }

  public getProfessorsByDesc(){
    this.professorService.getProfessorsListDesc().subscribe(data => {
      this.professors = data;
    });
  }

  deleteProfessor(id: any){
    this.professorService.deleteProfessor(id).subscribe( data => {
      console.log(data);
      this.getProfessors();
    })
}

}
