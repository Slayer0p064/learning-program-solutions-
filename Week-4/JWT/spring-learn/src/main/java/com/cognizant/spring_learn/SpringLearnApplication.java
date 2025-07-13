package com.cognizant.spring_learn;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:country.xml")
public class SpringLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Autowired
	private Country country;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		displayCountry();
	}

	public void displayCountry() {
		LOGGER.info("START - displayCountry");

		LOGGER.info("Country: {}", country.toString());

		LOGGER.info("END - displayCountry");
	}
}
