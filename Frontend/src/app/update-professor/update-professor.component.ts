import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Professor } from '../professor';
import { ProfessorService } from '../professor.service';

@Component({
  selector: 'app-update-professor',
  templateUrl: './update-professor.component.html',
  styleUrls: ['./update-professor.component.css']
})
export class UpdateProfessorComponent implements OnInit {

  professor: Professor = new Professor();
  id: any;

  constructor(private professorService:ProfessorService, private router : Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params[ 'id' ];
    this.professorService.getProfessorById(this.id).subscribe(data =>{
      this.professor = data;
    },error => console.log(error));
  }

    onSubmit(){
      this.professorService.updateProfessor(this.id, this.professor).subscribe( data =>{
        this.goToProfessorList();
      },error => console.log(error));
    }

    
    goToProfessorList(){
      this.router.navigate(['/professors']);
    }

}
