import { Component, Input, OnInit } from '@angular/core';
import { UserRegistryCardComponent } from '../user-registry-card/user-registry-card.component';
import { CommonModule } from '@angular/common';
import { CompanyService } from '../company.service';
import { User } from '../models/user.model';
import { Company } from '../models/company.model';
import { NavbarComponent } from '../navbar/navbar.component';


@Component({
  selector: 'app-users-reg',
  imports: [UserRegistryCardComponent, CommonModule, NavbarComponent],
  templateUrl: './users-reg.component.html',
  styleUrl: './users-reg.component.css'
})
export class UsersRegComponent implements OnInit{
  users: User[] = [];
  selectedCompanyId: number = 0;
  company: Company | null = null;

  constructor(private companyService: CompanyService) {}

  ngOnInit(): void {
    const companyId = this.companyService.getCompanyId();
    console.log("USER REGISTRY company ID: " + companyId);
    this.companyService.getCompanyById(Number(this.companyService.getCompanyId())).subscribe(company => {
      console.log("Company: " + company);
      this.company = company;
      this.users = [...company.users];
      console.log("Users: " + this.users);
    });

    // this.companyService.selectedCompanyId$.subscribe(companyId => {
    //   this.selectedCompanyId = companyId;
    //   if (companyId) {
    //     this.fetchUsers(companyId);
    //   } else {
    //     this.users = [];
    //   }
    // });
  }

  // fetchUsers(companyId: number): void {
  //   this.companyService.getUsersByCompanyId().subscribe(users => {
  //     this.users = users;
  //     console.log('Users for selected company:', this.users);
  //   });
  // }

  // fetchUsersByCompany(company: Company): void {
  //   // const data: User[] | null = this.company?.users;
  //   console.log("Fetching users!");
  //   if (Array.isArray(this.company) )
  //   this.users = [...this.company.users];
  //   console.log("Here are the company users: " + this.users);
  // }

}
