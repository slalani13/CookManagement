import { Component, OnInit } from '@angular/core';
import { createProject, getProjectsFromTeam } from '../services/projectService';
import { projectData } from '../models/projectData';
import { credentialsData } from '../models/credentialsData';

@Component({
  selector: 'app-projects',
  imports: [],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent implements OnInit{

  team_id:number = 1;
  projects:projectData[] = [];
  
  constructor(){
  }

  ngOnInit(): void {
    //this.fetchProjectsFromTeam();
    //this.addProjectToTeam();
  }

  fetchProjectsFromTeam(){
    getProjectsFromTeam(this.team_id).then((data)=>{
      this.projects = [...data];
      console.log("projects fetched successfully")
    })
  };

  addProjectToTeam(){
    createProject(this.team_id, {name: "test", description:"description test", team:1, active:true,
       credentials: {username:"jane_smith", password:"password" } as credentialsData}).then((data)=>{
      console.log(JSON.stringify(data)+" project added successfully")
    })
  };

}
