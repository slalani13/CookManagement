import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { UserService } from './user.service';
import { ModalService } from './modal.service';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private userService: UserService, private router: Router, private modalService: ModalService) {}

  canActivate(): Observable<boolean> {
    return this.userService.getUser().pipe(
      tap(user => console.log('AuthGuard: User data:', user)),
      map(user => {
        if (user) {
          return true;
        } else {
          // Show modal directly
          this.modalService.show();
          
          // Navigate to login page
          this.router.navigate(['/']);
          
          return false;
        }
      })
    );
  }
}