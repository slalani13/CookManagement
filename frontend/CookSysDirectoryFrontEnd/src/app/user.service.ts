import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs';
import { User } from './models/user.model';
import { UserRequest } from './models/userRequest';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userSource = new BehaviorSubject<User | null>(null);
  user$ = this.userSource.asObservable();

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    return this.http.post<User>('http://localhost:8080/users/login', { username, password }).pipe(
      tap(user => {
        this.userSource.next(user);
      })
    )
  }

  logout(user: User): Observable<void> {
    return this.http.post<void>('http://localhost:8080/users/logout', { body: user }).pipe(
      tap(() => this.userSource.next(null))
    );
  }

  updateUser(user: User) {
    this.userSource.next(user);
  }

  getUser(): Observable<User | null> {
    return this.user$;
  }

  setUser(user: User) {
    this.userSource.next(user);
  }

  createUser(userRequest: UserRequest) {
    return this.http.post<any>('http://localhost:8080/users/', userRequest ).pipe(
      tap(user => this.userSource.next(user))
    )
  }

}
