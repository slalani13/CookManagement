import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs';
import { User } from './models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userSource = new BehaviorSubject<User | null>(null);
  user$ = this.userSource.asObservable();

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<User> {
    return this.http.post<User>('http://localhost:8080/login', { email, password }).pipe(
      tap(user => this.userSource.next(user))
    )
  }

  updateUser(user: User) {
    this.userSource.next(user);
  }

  getUser(): User | null {
    return this.userSource.value;
  }

  setUser(user: User) {
    this.userSource.next(user);
  }


}
