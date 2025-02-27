import { Component, Output, EventEmitter, Input } from '@angular/core';
import { User } from '../models/user.model';
import { CompanyService } from '../company.service';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-user-modal',
  imports: [FormsModule, CommonModule],
  templateUrl: './add-user-modal.component.html',
  styleUrl: './add-user-modal.component.css'
})
export class AddUserModalComponent {
  @Input() isModalVisible: boolean = false;  // To receive showModal from the parent
  @Output() modalClose = new EventEmitter<void>();  // To emit close event to parent
  
  
  // Class variables for form inputs
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  phone: string = '';
  isAdmin: boolean = false;
  password: string = '';
  confirmPassword: string = '';

  constructor(
    private companyService: CompanyService,
    private userService: UserService
  ) {}

  close() {
    this.modalClose.emit();  // Emit the close event
  }

  submitForm() {
    console.log(this.firstName);
    console.log(this.lastName);
    console.log(this.email);
    console.log(this.phone);
    console.log(this.isAdmin);
    console.log(this.password);
    console.log(this.confirmPassword);
    this.modalClose.emit();
  }

}
