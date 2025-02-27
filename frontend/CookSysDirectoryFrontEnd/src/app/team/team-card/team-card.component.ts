import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { TeamComponent } from '../team.component';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-team-card',
  imports: [CommonModule],
  templateUrl: './team-card.component.html',
  styleUrl: './team-card.component.css'
})
export class TeamCardComponent {
  @Input() team: any = {
    id: 0,
    name: '',
    employees: [],
    projects: []
  };
  id = 0;
  numProjects= 0;

  constructor(private router: Router) {}

  ngOnInit() {
    this.id = this.team.id
    this.numProjects = this.team.projects.length
  }

  onSubmit() {
    this.router.navigate(['/projects'])
  }
}
