package com.harshit.springbootmicroservices.service;

import java.util.List;

import com.harshit.springbootmicroservices.domain.Difficulty;
import com.harshit.springbootmicroservices.domain.Region;
import com.harshit.springbootmicroservices.domain.Tour;
import com.harshit.springbootmicroservices.domain.TourBuilder;
import com.harshit.springbootmicroservices.repository.TourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourBuilder tourBuilder;

    public Tour createTour(
        String title,
        String description,
        String blurp,
        Integer price,
        String duration,
        String bullets,
        String keywords,
        String tourPackageName,
        Difficulty difficulty,
        Region region
    ) {
        return tourRepository.save(tourBuilder
            .withTitle(title)
            .withDescription(description)
            .withBlurp(blurp)
            .withPrice(price)
            .withDuration(duration)
            .withBullets(bullets)
            .withKeywords(keywords)
            .withDifficulty(difficulty)
            .withRegion(region)
            .withTourPackage(tourPackageName)
            .build()); 
    }

    public List<Tour> lookup() {
        return tourRepository.findAll();
    }

    public Long totalCount() {
        return tourRepository.count();
    }
}