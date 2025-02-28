import { Component, NgModule, OnInit } from '@angular/core';
import { createProject, getProjectsFromTeam } from '../services/projectService';
import { projectRequestData, projectResponseData } from '../models/projectData';
import { credentialsData } from '../models/credentialsData';
import { ProjectComponentComponent } from '../project-component/project-component.component';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { CreateProjectComponent } from "../create-project/create-project.component";
import { EditProjectComponent } from '../edit-project/edit-project.component';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-projects',
  imports: [ProjectComponentComponent, CommonModule, NavbarComponent, CreateProjectComponent],
  standalone:true,
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})

export class ProjectsComponent implements OnInit{

  team_id:number = 1;
  editing_project:boolean = false;
  creating_project:boolean = false;
  projects:projectResponseData[] = [];
  user:User|null = null;

  currentPage = 1;
  itemsPerPage = 3;
  
  constructor(private route: ActivatedRoute, private userService:UserService){
  }

  ngOnInit(): void {
    //this.fetchProjectsFromTeam();
    this.route.queryParams.subscribe(params => {
      const team_id = Number(params['team_id']);
      this.team_id = team_id;
      this.fetchProjectsFromTeam();
    });
    this.userService.getUser().subscribe(user => {
      this.user = user;
    });
  }

  fetchProjectsFromTeam(){
    getProjectsFromTeam(this.team_id).then((data)=>{
      this.projects = [...data];
      console.log("projects fetched successfully")
    })
  };

  get paginatedProjects() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.projects.slice(startIndex, endIndex);
  }

  get totalPages() {
    return Math.ceil(this.projects.length / this.itemsPerPage);
  }

  nextPage() {
    if ((this.currentPage * this.itemsPerPage) < this.projects.length) {
      this.currentPage++;
    }
    else{
      this.currentPage = 1;
    }
  }

  prevPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
    else{
      this.currentPage = this.totalPages;
    }
  }

  setCreating(){
    this.creating_project = true;
  }

  closeMenu(){
    this.creating_project = false;
  }

  closeMenuAndRefresh(){
    this.fetchProjectsFromTeam();
    this.currentPage = this.totalPages;
    this.creating_project = false;
  }

}
