import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsBlogComponent } from './news.component';

describe('NewsBlogComponent', () => {
  let component: NewsBlogComponent;
  let fixture: ComponentFixture<NewsBlogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewsBlogComponent]
    });
    fixture = TestBed.createComponent(NewsBlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
