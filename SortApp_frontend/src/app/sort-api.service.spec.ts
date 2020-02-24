import { TestBed } from '@angular/core/testing';

import { SortApiService } from './sort-api.service';

describe('SortApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SortApiService = TestBed.get(SortApiService);
    expect(service).toBeTruthy();
  });
});
