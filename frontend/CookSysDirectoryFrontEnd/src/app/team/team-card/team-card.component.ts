import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
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
    users: [],
  };
  @Input() project: any[] = []

  id = 0;
  numProjects= 0;

  constructor(private router: Router) {}

  ngOnInit() {
    this.id = this.team.id
    console.log(this.id)
    console.log(this.team.users)
    this.numProjects = this.project.length
    console.log(`team-card ${this.project}`)

    console.log('Team data in TeamCardComponent:', this.team);
  }

  onSubmit() {
    this.router.navigate(['/projects'], { queryParams: { team_id: this.id }} )
  }
}
