package com.hm.sorting.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hm.sorting.domain.SortedResult;
import com.hm.sorting.repository.ISortingRepository;
import com.hm.sorting.service.SortingServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class SortingServiceImplTest {
	
	@InjectMocks
	private SortingServiceImpl sortingService;	
	
	@Mock
	private ISortingRepository repository;
	
	@Test
	public void getSortedNumber() throws Exception {
		when(repository.save(any())).thenReturn(SortedResult("16,80,50,12,100,9,15"));
		SortedResult sortedResult = sortingService.sortOrder("16,80,50,12,100,9,15");
		assertEquals("16,80,50,12,100,9,15", sortedResult.getBeforeSort());
		assertEquals("9, 12, 15, 16, 50, 80, 100", sortedResult.getAfterSort());
	}

	private SortedResult SortedResult(String sortNumbers) {
		SortedResult sortValue = new SortedResult();
		sortValue.setBeforeSort("16,80,50,12,100,9,15");
		sortValue.setAfterSort("9, 12, 15, 16, 50, 80, 100");		
		return sortValue;
	}
	
}