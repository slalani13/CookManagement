import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user.model';
import { Company } from '../models/company.model';
import { UserService } from '../user.service';
import { CompanyService } from '../company.service';
import { CommonModule } from '@angular/common';
import { Announcement } from '../models/announcement.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-select-company',
  imports: [CommonModule],
  templateUrl: './select-company.component.html',
  styleUrl: './select-company.component.css'
})
export class SelectCompanyComponent implements OnInit{
  user: User | null = null;
  companies: Company[] = [];
  // selectedCompany: Company | null = null;
  // announcements: Announcement[] = [];
  selectedCompany$: Observable<Company> | null = null;
  announcements$: Observable<Announcement[]> | null = null;

  constructor(private router: Router, private userService: UserService, private companyService: CompanyService) {}

  ngOnInit(): void {
      this.userService.user$.subscribe(user => {
        this.user = user;
        if (user && user.companies) {
          this.companies = user.companies as Company[];
        }
      });
  }

  onCompanySelect(event: Event): void {
    const selectedCompanyId = (event.target as HTMLSelectElement).value;
    console.log('Selected company ID:', selectedCompanyId);

    // Set the selected company ID in CompanyService
    this.companyService.setSelectedCompanyId(Number(selectedCompanyId));

    // Fetch company details
    this.selectedCompany$ = this.companyService.getCompanyById(Number(selectedCompanyId));
    this.selectedCompany$.subscribe(company => {
      console.log('Selected company details:', company);
      this.companyService.setCompany(company);
    });

    // Fetch announcements for the selected company
    this.announcements$ = this.companyService.getAnnouncementsByCompanyId(Number(selectedCompanyId));
    this.announcements$.subscribe(announcements => {
      this.companyService.setAnnouncements(announcements);
    });

    this.router.navigate(['/home']);
  }
}
