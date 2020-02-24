package com.hm.sorting.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortedResult {
	@Id
	@GeneratedValue
	private int sortId;
	private String beforeSort;
	private String afterSort;
	private String timeToSort;
	private String swapCount;
}
