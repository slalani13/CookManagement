import { Component, OnInit } from '@angular/core';
import { getProjectsFromTeam } from '../services/projectService';
import { projectData } from '../models/projectData';

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
    this.fetchProjectsFromTeam();
  }

  fetchProjectsFromTeam(){
    getProjectsFromTeam(this.team_id).then((data)=>{
      this.projects = [...data];
      console.log("projects fetched successfully")
    })
  };

}
