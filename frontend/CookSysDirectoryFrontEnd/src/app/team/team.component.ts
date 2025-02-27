import { Component } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { CommonModule } from '@angular/common';
import { TeamCardComponent } from './team-card/team-card.component'
import { CreateTeamComponent } from '../create-team/create-team.component';
import { getAllTeams } from '../services/teamService'

@Component({
  selector: 'app-team',
  imports: [CommonModule, NavbarComponent, TeamCardComponent, CreateTeamComponent],
  templateUrl: './team.component.html',
  styleUrl: './team.component.css'
})
export class TeamComponent {
  teams: any[] = []
  overlayShown = false

  constructor() {}
  ngOnInit() {
    this.fetchTeams()
    console.log(this.teams)
  }

  toggleOverlay() {
    this.overlayShown = !this.overlayShown
  }

  fetchTeams() {
    getAllTeams().then((teams: any[]) => {
      this.teams = teams
    })
  }
}
