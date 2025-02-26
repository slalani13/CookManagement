import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs';
import { User } from './models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userSubject = new BehaviorSubject<User | null>(null);
  user$ = this.userSubject.asObservable();

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post<User>('http://localhost:8080/login', { email, password }).pipe(
      tap(user => this.userSubject.next(user))
    )
  }

  updateUser(user: any): void {
    this.userSubject.next(user);
  }

  getUser(): Observable<User | null> {
    return this.user$;
  }
}
