import { Component } from '@angular/core';
import { ModalService } from '../modal.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-modal-popup',
  imports: [CommonModule],
  templateUrl: './modal-popup.component.html',
  styleUrls: ['./modal-popup.component.css']
})
export class ModalPopupComponent {
  constructor(public modalService: ModalService) {}

  close() {
    this.modalService.hide();
  }
}