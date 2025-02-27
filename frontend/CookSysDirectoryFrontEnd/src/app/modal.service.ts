import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  private showModalSource = new BehaviorSubject<boolean>(false);
  showModal$ = this.showModalSource.asObservable();

  show() {
    this.showModalSource.next(true);
  }

  hide() {
    this.showModalSource.next(false);
  }
}