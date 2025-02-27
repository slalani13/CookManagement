import { Component, OnInit } from '@angular/core';
import { getProjectsFromTeam } from '../services/projectService';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-project-page',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './project-page.component.html',
  styleUrl: './project-page.component.css'
})
export class ProjectPageComponent implements OnInit{

  constructor(){
  }

  ngOnInit(): void {

  }

}
