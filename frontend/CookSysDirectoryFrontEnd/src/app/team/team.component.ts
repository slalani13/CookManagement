import { Component } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { CommonModule } from '@angular/common';
import { TeamCardComponent } from './team-card/team-card.component'
import { CreateTeamComponent } from '../create-team/create-team.component';
import { getAllTeams } from '../services/teamService'
import { getProjectsFromTeam } from '../services/projectService';

@Component({
  selector: 'app-team',
  imports: [CommonModule, NavbarComponent, TeamCardComponent, CreateTeamComponent],
  templateUrl: './team.component.html',
  styleUrl: './team.component.css'
})
export class TeamComponent {
  teams: any[] = []
  projects: any[] = []
  overlayShown = false

  constructor() {}
  ngOnInit() {
    this.fetchTeams()
    console.log(this.teams)
  }

  toggleOverlay() {
    this.overlayShown = !this.overlayShown
  }

  async fetchTeams() {
    const teams = await getAllTeams()
    // getAllTeams().then((teams: any[]) => {
    //   this.teams = teams
    // })
    console.log("Before loop")
    for (let team of teams) {
      const project = await getProjectsFromTeam(team.id)
      console.log(`team id: ${team.id}`)
      this.projects.push(project)
    }
    console.log("BELOW IS this.teams: ")
    console.log(this.projects);
    this.teams = teams
  }
}
