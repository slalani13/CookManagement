import { Component, OnInit, HostListener } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-navbar',
  imports: [RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {
  user: User | null = null;
  showMenu = false;

  constructor(private userService: UserService) { }
  @HostListener('window:resize', ['$event'])
  onresize(event: Event) {
    const width = (event.target as Window).innerWidth
    if (width > 768) {
      this.showMenu = true;
    }
  }

  toggleMenu() {
    this.showMenu = !this.showMenu;
  }

  ngOnInit(): void {
    const menuButton = document.getElementById('menu-button');
    const menu = document.getElementById('menu');

    menuButton?.addEventListener('click', () => {
      menu?.classList.toggle('show');
    });

    this.userService.getUser().subscribe(user => {
      this.user = user;
    });

  }

  handleLogout() {
   this.userService.logout();
   console.log(this.userService.getUser());
  }

}
