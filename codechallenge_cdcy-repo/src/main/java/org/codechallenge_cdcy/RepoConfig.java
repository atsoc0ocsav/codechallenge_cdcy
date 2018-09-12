package org.codechallenge_cdcy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.atsoc0ocsav")
@EnableJpaRepositories(basePackages = { "org.codechallenge_cdcy.repo" })
@EntityScan(basePackages = { "org.codechallenge_cdcy.model" })
public class RepoConfig {

}
