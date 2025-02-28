import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CloseButtonComponent } from '../close-button/close-button.component';
import { CommonModule } from '@angular/common';
import { updateProject } from '../services/projectService';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-project',
  imports: [CloseButtonComponent, CommonModule, FormsModule],
  standalone: true,
  templateUrl: './edit-project.component.html',
  styleUrl: './edit-project.component.css'
})
export class EditProjectComponent {
  @Input() team_id: number = 0;
  @Input() project_id: number = 0;
  @Input() active: boolean = false;
  @Output() closeMenu = new EventEmitter<void>();
  @Output() edited = new EventEmitter<void>();

  @Input() project_name:string = "name";
  @Input() project_description:string = "description";
  @Input() isActive:boolean = true;

  constructor(){
  }

  ngOnInit(): void {
  }

  close() : void {
    this.closeMenu.emit();
    this.active = false;
  }

  editChosenProject(){
    updateProject(this.project_id, {name: this.project_name, description: this.project_description,
       team:this.project_id, active:this.isActive}).then((data)=>{
      console.log(JSON.stringify(data)+" project edited successfully")
    }).then(() =>{
      this.active = false;
      this.edited.emit()
    })
  };

}
