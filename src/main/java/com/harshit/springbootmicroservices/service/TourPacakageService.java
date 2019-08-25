package com.harshit.springbootmicroservices.service;

import java.util.List;

import com.harshit.springbootmicroservices.domain.TourPackage;
import com.harshit.springbootmicroservices.repository.TourPackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPacakageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(String code, String name) {
        if(!tourPackageRepository.existsById(code)) {
            return tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    public Long totalTourPacakges() {
        return tourPackageRepository.count();
    }

    public List<TourPackage> lookUp() {
        return tourPackageRepository.findAll();
    }
}