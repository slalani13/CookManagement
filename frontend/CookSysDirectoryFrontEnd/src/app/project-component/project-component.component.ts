import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditProjectComponent } from '../edit-project/edit-project.component';
import { Router } from '@angular/router';
import { projectResponseData } from '../models/projectData';
import { UserService } from '../user.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-project-component',
  imports: [CommonModule, EditProjectComponent],
  standalone: true,
  templateUrl: './project-component.component.html',
  styleUrl: './project-component.component.css'
})
export class ProjectComponentComponent implements OnInit{

  @Output() projectEdited = new EventEmitter<void>();
  @Output() projectClosed = new EventEmitter<void>();

  @Input() team_id: number = 0;
  @Input() project_id: number = 0;
  @Input() name: string = '';
  @Input() description: string = '';
  @Input() active: boolean = false;
  @Input() project_data: projectResponseData|null = null;

  user:User|null = null;

  editing_project:boolean = false;
  
  constructor(private router: Router, private userService:UserService){

  }
  ngOnInit(): void {
    this.userService.getUser().subscribe(user => {
      this.user = user;
    });
  }

  toProjectPage(){
    this.router.navigate(['/project-page'], { queryParams: { project_id: this.project_data!.id }});
  }

  setEditing():void{
    this.editing_project = true;
  }

  closeMenu():void{
    this.editing_project = false;
    this.projectClosed.emit();
  }

  closeMenuAndRefresh():void{
    this.editing_project = false;
    this.projectEdited.emit();
  }

}
