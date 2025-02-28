import { Component, Input } from '@angular/core'; 
import { CommonModule } from '@angular/common';
import { User } from '../models/user.model';
import { NgxPaginationModule } from 'ngx-pagination'; // Import here


@Component({
  selector: 'app-user-registry-card',
  imports: [CommonModule, NgxPaginationModule],
  standalone: true,
  templateUrl: './user-registry-card.component.html',
  styleUrl: './user-registry-card.component.css'
})
export class UserRegistryCardComponent {
  @Input() users: User[] = [];
  page: number = 1;
  
}
