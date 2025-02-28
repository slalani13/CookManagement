import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CloseButtonComponent } from '../close-button/close-button.component';
import { CommonModule } from '@angular/common';
import { createProject } from '../services/projectService';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-project',
  imports: [CloseButtonComponent, CommonModule, FormsModule],
  standalone: true,
  templateUrl: './create-project.component.html',
  styleUrl: './create-project.component.css'
})
export class CreateProjectComponent implements OnInit {

  @Input() team_id: number = 0;
  @Input() active: boolean = false;
  @Output() closeMenu = new EventEmitter<void>();
  @Output() created = new EventEmitter<void>();

  new_name:string = "name";
  new_description:string = "description";

  constructor(){
  }

  ngOnInit(): void {
  }

  close() : void {
    this.closeMenu.emit();
    this.active = false;
  }

  addProjectToTeam(){
    createProject(this.team_id, {name: this.new_name, description:this.new_description, team:this.team_id, active:true}).then((data)=>{
      console.log(JSON.stringify(data)+" project added successfully")
    }).then(()=>{
      this.active = false;
      this.created.emit();
    }
    )
  };

}
