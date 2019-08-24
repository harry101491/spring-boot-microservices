package com.harshit.springbootmicroservices.repository;

import java.math.BigDecimal;

import com.harshit.springbootmicroservices.domain.Tour;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, BigDecimal> {

}