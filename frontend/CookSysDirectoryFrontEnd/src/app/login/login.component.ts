import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../models/user.model';
import { catchError, of, tap } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = ''
  password: string = ''

  constructor(private router: Router, private userService: UserService) {} 

  navigateToSelectCompany() {
    this.userService.login(this.email, this.password).pipe(
      tap((user: User) => {
        console.log(user);
        this.router.navigate(['/select-company']);
      }),
      catchError((error) => {
        console.error('Login failed:', error);
        return of(null); // Return an observable with a null value to handle the error
      })
    ).subscribe();
  }
}
