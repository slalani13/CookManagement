import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";
import { Announcement } from '../models/announcement.model';
import { CompanyService } from '../company.service';
import { User } from '../models/user.model';
import { Company } from '../models/company.model';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-home',
  imports: [CommonModule, NavbarComponent, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  showModal = false;
  announcements: Announcement[] = [];
  company = {} as Company;
  currentPage = 1;
  itemsPerPage = 4;
  user: User | null = null;
  title: string = '';
  message: string = '';
  errorMessage: string = '';

  constructor(private companyService: CompanyService, private userService: UserService) {}

  ngOnInit(): void {
   this.companyService.announcements$.subscribe(announcements => {
      if (announcements) {
        this.announcements = announcements.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime());
      }
  });
   this.userService.getUser().subscribe(user => {
      this.user = user;
    });
    this.companyService.company$.subscribe(company => {
      if (company) {
        this.companyService.getAnnouncementsByCompanyId(company.id).subscribe();
        this.company = company;
      }
    });
  }

  openModal() {
    console.log('Opening modal');
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.errorMessage = '';
  }

  onSubmit() {
    if (!this.title.trim()) {
      this.errorMessage = 'Title cannot be empty';
      return;
    }
    
    if (!this.message.trim()) {
      this.errorMessage = 'Message cannot be empty';
      return;
    }
    
    if (this.user && this.user.id && this.user.companies && this.user.companies.length > 0) {
      const authorId = this.user.id;
      const companyId = this.company.id;
      this.companyService.createAnnouncement({ authorId, companyId, title: this.title, message: this.message }).subscribe({
        next: (announcement) => {
          console.log(announcement);
          this.clearForm();
          this.closeModal();
        },
        error: (error: HttpErrorResponse) => {
          this.errorMessage = error.error.message || 'An error occurred while creating the announcement.';
        }
      });
    }
  }

  clearForm() {
    this.title = '';
    this.message = '';
  }

  get paginatedAnnouncements() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.announcements.slice(startIndex, endIndex);
  }

  get totalPages() {
    return Math.ceil(this.announcements.length / this.itemsPerPage);
  }

  nextPage() {
    if (this.currentPage * this.itemsPerPage < this.announcements.length) {
      this.currentPage++;
    }
  }

  prevPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }
}
