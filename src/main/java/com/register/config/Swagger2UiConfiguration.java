package com.register.config;

import com.google.common.base.Predicates;
import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * The Swagger2UiConfiguration class
 *
 * @author Younuss EL KASSMI
 */

@Configuration
@AllArgsConstructor
@EnableSwagger2
public class Swagger2UiConfiguration {

  private BuildProperties buildProperties;
  private ConfigurableEnvironment environment;

  @Bean
  public Docket api() {

    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            //.apis(RequestHandlerSelectors.any())
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    String env = "";
    final String[] activeProfiles = environment.getActiveProfiles();
    if (activeProfiles.length > 0) {
      env += " - " + activeProfiles[0];
    }
    return new ApiInfo(
            "EOS USER REGISTRATION REST API",
            "Documentation de l'API REST pour EOS.",
            "version " + buildProperties.getVersion() + env,
            null,
            new Contact("Younuss EL KASSMI", null, "younuss.elkassmi@gmail.com"),
            "Utilisation test", null, Collections.emptyList());
  }
}