import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, of } from 'rxjs';
import { tap } from 'rxjs';
import { Company } from './models/company.model';
import { Announcement } from './models/announcement.model';
import {User} from './models/user.model';
import { credentialsData } from './models/credentialsData';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private companySource = new BehaviorSubject<Company | null>(null);
  company$ = this.companySource.asObservable();

  private announcementsSource = new BehaviorSubject<Announcement[] | null>(null);
  announcements$ = this.announcementsSource.asObservable();

  // New property to store selected company ID
  private selectedCompanyIdSource = new BehaviorSubject<number | null>(null);
  selectedCompanyId$ = this.selectedCompanyIdSource.asObservable();

  constructor(private http: HttpClient) { }

  getCompanyById(companyId: number) {
    return this.http.get<Company>(`http://localhost:8080/company/${companyId}`).pipe(
      tap(company => this.companySource.next(company))
    )
  }

  setCompany(company: Company) {
    this.companySource.next(company);
  }

  getAnnouncementsByCompanyId(companyId: number) {
    return this.http.get<Announcement[]>(`http://localhost:8080/announcements/${companyId}`).pipe(
      tap(announcements => this.announcementsSource.next(announcements))
    )
  }

  setAnnouncements(announcements: Announcement[]) {
    this.announcementsSource.next(announcements);
  }

  createAnnouncement(announcement: { authorId: number, companyId: number, title: string, message: string }): Observable<Announcement> {
    return this.http.post<Announcement>('http://localhost:8080/announcements', announcement).pipe(
      tap(announcement => {
        const currentAnnouncements = this.announcementsSource.value || [];
        this.announcementsSource.next([...currentAnnouncements, announcement]);
      })
    )
  }
  // Set the selected company ID
  setSelectedCompanyId(companyId: number) {
    this.selectedCompanyIdSource.next(companyId);
    console.log("Company source companyId: " + this.selectedCompanyIdSource.value);
  }

  getUsersByCompanyId() {
    const companyId = this.selectedCompanyIdSource.value;
  if (companyId) {
    return this.http.get<User[]>(`http://localhost:8080/company/${companyId}/users`);
  }
  return of([]); // Return an Observable of an empty array
  }

  getCompanyId():number | null{
    return this.selectedCompanyIdSource.value;
  }

  addUserToCompany(companyId: number, credentials: credentialsData) {
    return this.http.patch<Company>(`http://localhost:8080/company/${companyId}/add-user`, credentials).pipe(
      tap(company => this.companySource.next(company))
    );
  }

}
