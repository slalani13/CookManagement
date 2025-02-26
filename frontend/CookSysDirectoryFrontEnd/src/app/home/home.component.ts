import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";

@Component({
  selector: 'app-home',
  imports: [CommonModule, NavbarComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  showModal = false;
  announcements = [
    { id: 1, title: 'Announcement 1', content: 'Content for announcement 1', date: new Date() },
    { id: 2, title: 'Announcement 2', content: 'Content for announcement 2', date: new Date() },
    { id: 3, title: 'Announcement 3', content: 'Content for announcement 3', date: new Date() },
    { id: 4, title: 'Announcement 4', content: 'Content for announcement 4', date: new Date() },
    { id: 5, title: 'Announcement 5', content: 'Content for announcement 5', date: new Date() },
    { id: 6, title: 'Announcement 6', content: 'Content for announcement 6', date: new Date() },
    { id: 7, title: 'Announcement 7', content: 'Content for announcement 7', date: new Date() },
    { id: 8, title: 'Announcement 8', content: 'Content for announcement 8', date: new Date() },
    { id: 9, title: 'Announcement 9', content: 'Content for announcement 9', date: new Date() },
    { id: 10, title: 'Announcement 10', content: 'Content for announcement 10', date: new Date() },
    { id: 11, title: 'Announcement 11', content: 'Content for announcement 11', date: new Date() },
    { id: 12, title: 'Announcement 12', content: 'Content for announcement 12', date: new Date() },
    { id: 13, title: 'Announcement 13', content: 'Content for announcement 13', date: new Date() },
    { id: 14, title: 'Announcement 14', content: 'Content for announcement 14', date: new Date() },
    { id: 15, title: 'Announcement 15', content: 'Content for announcement 15', date: new Date() }
  ];
  currentPage = 1;
  itemsPerPage = 10;

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
