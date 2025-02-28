import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CompanyService } from '../company.service';
import { User } from "../models/user.model"
import { createTeam } from '../services/teamService';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';
import { getAllTeams } from '../services/teamService'


@Component({
  selector: 'app-create-team',
  imports: [CommonModule, FormsModule],
  templateUrl: './create-team.component.html',
  styleUrl: './create-team.component.css'
})
export class CreateTeamComponent implements OnInit {
  teamName = ''
  description = ''
  users: User[] = []
  addedUsers: User[] = []
  selectedUser: any = undefined
  modalOpen = true
  companyId: number | null = null



  @Output() closeModal = new EventEmitter<any>()

  constructor(private company: CompanyService, private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit() {
    this.company.selectedCompanyId$.subscribe(company => {
      this.companyId = company;
      if (company) {
        this.fetchUsers(company);
      } else {
        console.log("INTO ERROR")
        this.users = [];
      }
    });
  }
  fetchUsers(companyId: number): void {
    this.company.getUsersByCompanyId().subscribe((users: User[]) => {
      const validUsers = users.filter(user => user.profile && user.profile.firstName);
      this.users = validUsers
      console.log(`This company users: ${this.users}`)
    })  
  }

  addUser() {
    if (this.selectedUser) {
      if (!this.addedUsers.includes(this.selectedUser)) {
        this.addedUsers.push(this.selectedUser)
      }
      const index = this.users.indexOf(this.selectedUser)
      if (index != -1) {
        this.users.splice(index, 1)
      }
    }
  }

  removeUser(user: any) {
    const index = this.addedUsers.indexOf(user)
    if (index != -1) {
      this.addedUsers.splice(index, 1)
      this.users.push(user)
    }
  }

  async newTeam(): Promise<void> {
    if (this.companyId === null) {
      console.error("Company ID is null");
      return; // Early exit or handle the error as needed
    }
    const teamRequest = {
      name: this.teamName,
      description: this.description,
      company: this.companyId,
      users: this.addedUsers
    }

    const response = createTeam(0, teamRequest)

    if (response) {
      console.log("Team Created Successfully:", response)
      this.router.navigate(['/home'])
      this.exit()
    } else {
      console.error("Team Createion Failed")
    }
  }

  exit() {
    this.closeModal.emit()
  }

  async refreshPage() {
    this.router.navigate([this.router.url]);  // This triggers a navigation to the same URL
  }

}

