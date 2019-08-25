package com.harshit.springbootmicroservices.domain;

import com.harshit.springbootmicroservices.repository.TourPackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TourBuilder {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    private String title; 
    private String description;
    private String blurp;
    private Integer price;
    private String duration;
    private String bullets;
    private String keywords;
    private TourPackage tourPackage;
    private Difficulty difficulty;
    private Region region;


    public TourBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TourBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public TourBuilder withBlurp(String blurp) {
        this.blurp = blurp;
        return this;
    }

    public TourBuilder withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TourBuilder withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public TourBuilder withBullets(String bullets) {
        this.bullets = bullets;
        return this;
    }

    public TourBuilder withKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public TourBuilder withTourPackage(String tourName) {
        if((tourPackageRepository.findByName(tourName) == null)) {
            this.tourPackage = null;
            return this;
        }
        this.tourPackage = tourPackageRepository.findByName(tourName);
        return this;
    }

    public TourBuilder withDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public TourBuilder withRegion(Region region) {
        this.region = region;
        return this;
    }

    public Tour build() {
        return new Tour(
            this.title, 
            this.description, 
            this.blurp, 
            this.price, 
            this.duration, 
            this.bullets, 
            this.keywords, 
            this.tourPackage, 
            this.difficulty, 
            this.region
        );
    }
}