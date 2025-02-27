import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";
import { Announcement } from '../models/announcement.model';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, NavbarComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  showModal = false;
  announcements: Announcement[] = [];
  currentPage = 1;
  itemsPerPage = 10;

  constructor(private companyService: CompanyService) {}

  ngOnInit(): void {
   this.companyService.announcements$.subscribe(announcements => {
      this.announcements = announcements || [];
      console.log('Announcements:', this.announcements);
    });
  }

  openModal() {
    console.log('Opening modal');
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }

  onSubmit() {
    // Handle form submission logic here
    this.closeModal();
  }

  get paginatedAnnouncements() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.announcements.slice(startIndex, endIndex);
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
