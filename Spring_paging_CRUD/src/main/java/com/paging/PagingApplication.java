package com.paging;

import com.paging.model.Country;
import com.paging.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class PagingApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(PagingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("Russia","Moscow"));
		countryRepository.save(new Country("Belarus","Minsk"));
		countryRepository.save(new Country("America","Washington"));
		countryRepository.save(new Country("Ukraine","Kiev"));
		countryRepository.save(new Country("Australia","Sidney"));
		countryRepository.save(new Country("Germany","Berlin"));


		/*countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("China","Peking"));*/
	}
}
