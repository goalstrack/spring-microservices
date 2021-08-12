package org.sravan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SampleRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRestServiceApplication.class, args);
	}

}
