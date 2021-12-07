package com.medical.clinic.appointment_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class AppointmentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentManagementSystemApplication.class, args);
	}

}
