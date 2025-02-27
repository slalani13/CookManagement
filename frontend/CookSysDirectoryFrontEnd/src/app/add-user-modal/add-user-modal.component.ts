import { Component, Output, EventEmitter } from '@angular/core';
import { User } from '../models/user.model';
import { CompanyService } from '../company.service';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms'; 

@Component({
  selector: 'app-add-user-modal',
  imports: [],
  templateUrl: './add-user-modal.component.html',
  styleUrl: './add-user-modal.component.css'
})
export class AddUserModalComponent {

  @Output() userAdded = new EventEmitter<User>();
  
  // Class variables for form inputs
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  phone: string = '';
  isAdmin: boolean = false;

  constructor(
    private companyService: CompanyService,
    private userService: UserService
  ) {}

  // Submit the new user
  // onSubmit(): void {

  //   const newUser = {
  //     profile: {
  //       firstName: this.firstName,
  //       lastName: this.lastName,
  //       email: this.email,
  //       phone: this.phone
  //     },
  //     active: true,
  //     admin: this.isAdmin,
  //     status: 'active'
  //   };


    // Call the service to add the user to the team and update the user's team
    // this.companyService.addUserToTeam(newUser).subscribe((addedUser) => {
    //   this.userService.updateUserTeam(addedUser).subscribe(() => {
    //     this.userAdded.emit(addedUser); // Emit the new user data to parent
    //   });
    // });
  }

  // Close the modal (optional if using Angular modal library)
  // closeModal(): void {
  //   // Logic to close modal
  // }

  // open() {
  //   console.log('module is open!');
  // }

// }
