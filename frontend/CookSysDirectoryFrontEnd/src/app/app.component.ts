import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ModalPopupComponent } from "./modal-popup/modal-popup.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ModalPopupComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'CookSysDirectoryFrontEnd';

}
