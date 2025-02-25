import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-company',
  imports: [],
  templateUrl: './select-company.component.html',
  styleUrl: './select-company.component.css'
})
export class SelectCompanyComponent {
  constructor(private router: Router) {}

  onCompanySelect(event: Event) {
    const selectElement = event.target as HTMLSelectElement
    const selectedValue = selectElement.value

    if (selectedValue) {
      this.router.navigate(['/home'])
    }

  }

}
