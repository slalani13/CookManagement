import { Component, OnInit } from '@angular/core';
import { ModalService } from '../modal.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-modal-popup',
  imports: [CommonModule],
  templateUrl: './modal-popup.component.html',
  styleUrls: ['./modal-popup.component.css']
})
export class ModalPopupComponent implements OnInit{
showModal = false;

  constructor(public modalService: ModalService) {}

  ngOnInit(): void {
      this.modalService.showModal$.subscribe(show => {
        this.showModal = show;
      });
  }

  close() {
    this.modalService.hide();
  }
}