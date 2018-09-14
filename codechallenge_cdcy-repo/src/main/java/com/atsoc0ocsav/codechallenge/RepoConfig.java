package com.atsoc0ocsav.codechallenge;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.atsoc0ocsav.codechallenge")
@EnableJpaRepositories(basePackages = { "com.atsoc0ocsav.codechallenge.repo" })
@EntityScan(basePackages = { "com.atsoc0ocsav.codechallenge.domain" })
public class RepoConfig {

}