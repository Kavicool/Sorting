package com.hm.sorting.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sorting.domain.SortedResult;
import com.hm.sorting.repository.ISortingRepository;

@Service
public class SortingServiceImpl implements SortingService {

	@Autowired
	private ISortingRepository repository;

	@Override
	public SortedResult sortOrder(String sortNumbers) {
		Instant start = Instant.now();

		SortedResult sortValue = new SortedResult();
		sortValue.setBeforeSort(sortNumbers);

		String[] sortArray = sortNumbers.split(",");
		int[] results = new int[sortArray.length];
		for (int i = 0; i < sortArray.length; i++) {
			results[i] = Integer.parseInt(sortArray[i]);
		}

		SortingUtil ob = new SortingUtil();
		ob.swapCount = 0;
		ob.sort(results, 0, results.length - 1);		
				
		sortValue.setAfterSort(Arrays.toString(results).replace("[", "").replace("]", ""));
		sortValue.setSwapCount(Integer.toString(ob.swapCount));		
		
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis(); // in millis 
		sortValue.setTimeToSort(Long.toString(timeElapsed));

		repository.save(sortValue);
		return sortValue;
	}
}
