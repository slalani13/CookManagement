import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRegistryCardComponent } from './user-registry-card.component';

describe('UserRegistryCardComponent', () => {
  let component: UserRegistryCardComponent;
  let fixture: ComponentFixture<UserRegistryCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserRegistryCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRegistryCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
