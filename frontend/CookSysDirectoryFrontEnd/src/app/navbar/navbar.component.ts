import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  ngOnInit(): void {
    const menuButton = document.getElementById('menu-button');
    const menu = document.getElementById('menu');

    menuButton?.addEventListener('click', () => {
      menu?.classList.toggle('show');
    });
  }

}
