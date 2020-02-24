package com.hm.sorting.service;

import org.springframework.stereotype.Component;

@Component
public class SortingUtil {
	int swapCount;

	public SortingUtil() {
		swapCount = 0;
	}

	public void sort(final int sortArr[], final int low, final int high) {
		if (low < high) {
			int pIndex = partition(sortArr, low, high);
			// Recursively sort elements before partition and after partition
			sort(sortArr, low, pIndex - 1);
			sort(sortArr, pIndex + 1, high);
		}
	}

	private int partition(final int sortArr[], final int low, final int high) {
		final int pivot = sortArr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (sortArr[j] < pivot) {
				i++;
				// swap sortArr[i] and sortArr[j]
				int temp = sortArr[i];
				sortArr[i] = sortArr[j];
				sortArr[j] = temp;
				swapCount++;
			}
		}

		// swap sortArr[i+1] and sortArr[high]
		int temp = sortArr[i + 1];
		sortArr[i + 1] = sortArr[high];
		sortArr[high] = temp;
		swapCount++;

		return i + 1;
	}
}
