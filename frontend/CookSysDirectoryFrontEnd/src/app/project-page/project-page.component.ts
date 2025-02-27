import { Component, Input, OnInit } from '@angular/core';
import { getProject, getProjectsFromTeam, updateProject, updateProjectContent } from '../services/projectService';
import { CommonModule } from '@angular/common';
import { projectResponseData } from '../models/projectData';
import { NavbarComponent } from '../navbar/navbar.component';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { EditProjectComponent } from '../edit-project/edit-project.component';

@Component({
  selector: 'app-project-page',
  imports: [CommonModule, NavbarComponent, FormsModule, EditProjectComponent],
  standalone: true,
  templateUrl: './project-page.component.html',
  styleUrl: './project-page.component.css'
})
export class ProjectPageComponent implements OnInit{

  project_id: number = 0;
  project:projectResponseData|null = null;
  edit:boolean = false;
  editing_project:boolean = false;
  content:string = "";

  constructor(private route: ActivatedRoute){
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.project_id = Number(params['project_id']);
    });
    this.fetchProjectData();
  }

  editMode(): void{
    this.edit = true;
  }

  fetchProjectData(): void{
    getProject(this.project_id).then((data) =>{
      this.project = data as projectResponseData;
      this.content = this.project.content;
      this.edit = false;
    })
  }

  doneEditing(): void{
    if (this.project)
    updateProjectContent(this.project_id, {content:this.content, credentials: {username:"jane_smith", password:"password" }}).then((data)=>{
      console.log(JSON.stringify(data)+" project content edited successfully")
    }).then(() =>{
      this.fetchProjectData();
    })
  }
  
  setEditing():void{
    this.editing_project = true;
  }
  
  closeMenuAndRefresh():void{
    this.editing_project = false;
    this.fetchProjectData();
  }

  getContentParts(content: string): string[] {
    if (!content) return [];
    return content.split(/(\s+)/);
  }

  isUrl(text: string): boolean {
    return /https?:\/\/[^\s]+/.test(text);
  }

}
