package com.harshit.springbootmicroservices;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.harshit.springbootmicroservices.domain.Region;
import com.harshit.springbootmicroservices.service.TourPacakageService;
import com.harshit.springbootmicroservices.service.TourService;
import com.harshit.springbootmicroservices.domain.Difficulty;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMicroservicesApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TourPacakageService tourPacakageService;

	@Autowired
	private TourService tourService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Create the default tour packages
		tourPacakageService.createTourPackage("BC", "Backpack Cal");
		tourPacakageService.createTourPackage("CC", "California Calm");
		tourPacakageService.createTourPackage("CH", "California Hot springs");
		tourPacakageService.createTourPackage("CY", "Cycle California");
		tourPacakageService.createTourPackage("DS", "From Desert to Sea");
		tourPacakageService.createTourPackage("KC", "Kids California");
		tourPacakageService.createTourPackage("NW", "Nature Watch");
		tourPacakageService.createTourPackage("SC", "Snowboard Cali");
		tourPacakageService.createTourPackage("TC", "Taste of California");
		tourPacakageService.lookUp().forEach(tourPackage -> logger.info("The Tour Pacakge is: -> {}", tourPackage));

		TourFromFile.importTours().forEach(t -> tourService.createTour(
			t.title,
			t.description,
			t.blurb,
			Integer.valueOf(t.price),
			t.length,
			t.bullets,
			t.keywords,
			t.packageType,
			Difficulty.valueOf(t.difficulty),
			Region.findByLabel(t.region)
		));

		tourService.lookup().forEach(tour -> logger.info("The Tour is: -> {}", tour));
	}
	
	/**
	 * Helper class to import the records in the ExploreCalifornia.json
	 */
	static class TourFromFile {
		//attributes as listed in the .json file
		private String packageType, title, description, blurb, price, length, bullets, keywords,  difficulty, region;

		/**
		 * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
		 *
		 * @return a List of TourFromFile objects.
		 * @throws IOException if ObjectMapper unable to open file.
         */
		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),new TypeReference<List<TourFromFile>>(){});
		}
	}
}
