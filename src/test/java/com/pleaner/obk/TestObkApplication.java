package com.pleaner.obk;

import org.springframework.boot.SpringApplication;

public class TestObkApplication {

	public static void main(String[] args) {
		SpringApplication.from(Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
