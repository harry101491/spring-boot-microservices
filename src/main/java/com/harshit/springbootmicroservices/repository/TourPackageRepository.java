package com.harshit.springbootmicroservices.repository;

import com.harshit.springbootmicroservices.domain.TourPackage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TourPackageRepository extends JpaRepository<TourPackage, String> {}