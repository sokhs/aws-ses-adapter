package com.c4lab.aws.ses.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSesAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSesAdapterApplication.class, args);

		System.out.println(
				"AWS_PROFILE = " + System.getenv("AWS_PROFILE")
		);
	}

}
