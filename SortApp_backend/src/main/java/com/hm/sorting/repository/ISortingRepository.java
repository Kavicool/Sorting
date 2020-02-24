package com.hm.sorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.sorting.domain.SortedResult;

public interface ISortingRepository extends JpaRepository<SortedResult, Integer> {
}
