package com.fdp.FDP_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FdpSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FdpSpringBootApplication.class, args);
	}

}
