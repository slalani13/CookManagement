import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../models/user.model';
import { catchError, of, tap } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = ''
  password: string = ''
  errorMessage: string = '';

  constructor(private router: Router, private userService: UserService) {} 

  navigateToSelectCompany() {
    this.userService.login(this.username, this.password).pipe(
      tap((user: User) => {
        console.log(user);
        this.userService.setUser(user);
        this.router.navigate(['/select-company']);
      }),
      catchError((error) => {
        console.error('Login failed:', error);
        this.errorMessage = error.error.message || 'Login failed';
        return of(null); // Return an observable with a null value to handle the error
      })
    ).subscribe();
  }
}
