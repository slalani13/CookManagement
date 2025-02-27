import { Component, Input } from '@angular/core'; 

export interface User {
  name: string;
  email: string;
  active: boolean;
  admin: boolean;
  status: string;
}


@Component({
  selector: 'app-user-registry-card',
  imports: [],
  templateUrl: './user-registry-card.component.html',
  styleUrl: './user-registry-card.component.css'
})
export class UserRegistryCardComponent {
  @Input() users: User[] = [];  // Receiving users data
  @Input() companyId: number = 0;  // Receiving companyId from parent

}
