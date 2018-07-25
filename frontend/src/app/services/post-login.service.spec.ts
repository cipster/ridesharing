import { TestBed, inject } from '@angular/core/testing';

import { PostLoginService } from './post-login.service';

describe('PostLoginService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PostLoginService]
    });
  });

  it('should be created', inject([PostLoginService], (service: PostLoginService) => {
    expect(service).toBeTruthy();
  }));
});
