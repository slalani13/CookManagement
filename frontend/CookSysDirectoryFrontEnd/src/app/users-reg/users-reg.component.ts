import { Component, Input, OnInit } from '@angular/core';
import { UserRegistryCardComponent } from '../user-registry-card/user-registry-card.component';
import { CommonModule } from '@angular/common';
import { CompanyService } from '../company.service';
import { User } from '../models/user.model';


@Component({
  selector: 'app-users-reg',
  imports: [UserRegistryCardComponent, CommonModule],
  templateUrl: './users-reg.component.html',
  styleUrl: './users-reg.component.css'
})
export class UsersRegComponent implements OnInit{
  users: User[] = [];
  selectedCompanyId: number | null = null;

  constructor(private companyService: CompanyService) {}

  ngOnInit(): void {
    this.companyService.selectedCompanyId$.subscribe(companyId => {
      this.selectedCompanyId = companyId;
      if (companyId) {
        this.fetchUsers(companyId);
      } else {
        this.users = [];
      }
    });
  }

  fetchUsers(companyId: number): void {
    this.companyService.getUsersByCompanyId().subscribe(users => {
      this.users = users;
      console.log('Users for selected company:', this.users);
    });
  }

}
