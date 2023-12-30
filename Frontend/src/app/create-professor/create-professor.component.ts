import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from '../professor';
import { ProfessorService } from '../professor.service';

@Component({
  selector: 'app-create-professor',
  templateUrl: './create-professor.component.html',
  styleUrls: ['./create-professor.component.css']
})
export class CreateProfessorComponent implements OnInit {

  professor: Professor = new Professor();

  constructor(private professorService:ProfessorService, 
              private router:Router) { }

  ngOnInit(): void {
  }

  saveProfessor(){
    this.professorService.createProfessor(this.professor).subscribe( data => {
      console.log(data);
      this.goToProfessorList();
    },
   error => console.log(error));
  }

  goToProfessorList(){
    this.router.navigate(['/professors']);
  }

  onSubmit(){
      console.log(this.professor);
      this.saveProfessor();
  }

}
