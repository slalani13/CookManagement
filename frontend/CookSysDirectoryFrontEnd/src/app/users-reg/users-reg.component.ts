import { Component, Input, OnInit } from '@angular/core';
import { UserRegistryCardComponent } from '../user-registry-card/user-registry-card.component';
import { CommonModule } from '@angular/common';
import { CompanyService } from '../company.service';
import { User } from '../models/user.model';
import { Company } from '../models/company.model';
import { NavbarComponent } from '../navbar/navbar.component';
import { AddUserModalComponent } from '../add-user-modal/add-user-modal.component';
import { NgxPaginationModule } from 'ngx-pagination';

@Component({
  selector: 'app-users-reg',
  imports: [UserRegistryCardComponent, CommonModule, NavbarComponent, AddUserModalComponent, NgxPaginationModule],
  templateUrl: './users-reg.component.html',
  styleUrl: './users-reg.component.css'
})
export class UsersRegComponent implements OnInit{
  users: User[] = [];
  selectedCompanyId: number = 0;
  company: Company | null = null;
  showModal: boolean = false;
  page: number = 1; 

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

  }

  openModal() {
    this.showModal=true;
  }

  closeModal() {
    this.showModal = false;
    this.updateUsers();
  }

  updateUsers() {
    this.companyService.getCompanyById(Number(this.companyService.getCompanyId())).subscribe(company => {
      console.log("Company: " + company);
      this.company = company;
      this.users = [...company.users];
      console.log("Users: " + this.users);
    });
  }

}
