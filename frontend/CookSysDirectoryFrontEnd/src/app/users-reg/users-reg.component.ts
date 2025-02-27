import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface User {
  name: string;
  email: string;
  active: boolean;
  admin: boolean;
  status: string;
}

@Component({
  selector: 'app-users-reg',
  imports: [],
  templateUrl: './users-reg.component.html',
  styleUrl: './users-reg.component.css'
})
export class UsersRegComponent {
  @Input() companyId: Number = 0;
  users: User[] = [];

  constructor(private http: HttpClient) { } // Inject HttpClient

  ngOnInit(): void {
    if (this.companyId) {
      this.getUsers();  // Fetch users when the component loads if companyId is available
    }
  }


  getUsers(): void {
      const url = `https://localhost:8080/users/${this.companyId}`;
      this.http.get<User[]>(url).subscribe((data: User[]) => {
          this.users = data;  // Assign the fetched data to the users array
        }, (error) => {
          console.error('Error fetching users', error);  // Handle error
        });
    }

}
