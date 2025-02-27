import { Component, Output, EventEmitter, Input } from '@angular/core';
import { User } from '../models/user.model';
import { CompanyService } from '../company.service';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { createUserFromRequest } from '../services/userService';

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
  username: string = '';
  email: string = '';
  phone: string = '';
  isAdmin: boolean = false;
  password: string = '';
  confirmPassword: string = '';

  constructor(
    private companyService: CompanyService,
    private userService: UserService,
    private router: Router 
  ) {}

  close() {
    this.modalClose.emit();  // Emit the close event
  }

  submitForm() {
    console.log(this.firstName);
    console.log(this.lastName);
    console.log(this.username);
    console.log(this.email);
    console.log(this.phone);
    console.log(this.isAdmin);
    console.log(this.password);
    console.log(this.confirmPassword);
    // createUser takes credentials: username, password and profile: firstname, lastname, email, phone, and isAdmin. Use userService to call createUser. Need to create model for UserRequestDto
    // Construct request payload
  const credentials = {
    username: this.username,
    password: this.password
  };

  const profile = {
    firstName: this.firstName,
    lastName: this.lastName,
    email: this.email,
    phone: this.phone
  };

  const userRequest = {
    credentials: credentials,
    profile: profile,
    isAdmin: this.isAdmin
  };

  console.log(userRequest);

  createUserFromRequest(userRequest).then((data) => {
    console.log(data);
    const companyId = this.companyService.getCompanyId(); 
    this.companyService.addUserToCompany(Number(companyId), credentials).subscribe(
            (response) => {
              console.log("User added to company:", response);
              this.modalClose.emit(); // Close modal
              // this.router.navigate(['/users']);
              // // location.reload(); // Reload page
            },
            (error) => {
              console.error("Error adding user to company:", error);
            }
          );
  });

  // this.userService.createUser(userRequest).subscribe(
  //   (user) => {
  //     console.log("User created successfully:", user);
      
  //     // Get companyId using company service
  //     const companyId = this.companyService.getCompanyId(); 
  //     // addUserToCompany takes a company id and user credentials which is username and password and add user to company
  //     this.companyService.addUserToCompany(Number(companyId), credentials).subscribe(
  //       (response) => {
  //         console.log("User added to company:", response);
  //         this.modalClose.emit(); // Close modal
  //         this.router.navigate(['/users']);
  //         // location.reload(); // Reload page
  //       },
  //       (error) => {
  //         console.error("Error adding user to company:", error);
  //       }
  //     );
  //   },
  //   (error) => {
  //     console.error("Error creating user:", error);
  //   }
  // );
  }

}
