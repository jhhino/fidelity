package com.hino.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hino.loyalty.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
