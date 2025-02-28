import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ModalPopupComponent } from "./modal-popup/modal-popup.component";
import { ModalService } from './modal.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'CookSysDirectoryFrontEnd';
  showAuthModal = false;

  constructor(private modalService: ModalService) {}
  
  ngOnInit() {
    this.modalService.showModal$.subscribe(show => {
      this.showAuthModal = show;
    });
  }
  
  closeAuthModal() {
    this.modalService.hide();
  }

}
