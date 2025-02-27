import { Component, OnInit } from '@angular/core';
import { getProjectsFromTeam } from '../services/projectService';

@Component({
  selector: 'app-project-page',
  imports: [],
  templateUrl: './project-page.component.html',
  styleUrl: './project-page.component.css'
})
export class ProjectPageComponent implements OnInit{

  constructor(){
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
