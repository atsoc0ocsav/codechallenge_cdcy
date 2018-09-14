package org.codechallenge_cdcy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.atsoc0ocsav")
public class ServiceConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
