package dev.alexfleming.poller.config;

import dev.alexfleming.poller.config.properties.PollerProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  @Bean
  public RestTemplate simpleWebServiceRestTemplate(final RestTemplateBuilder builder, final
      PollerProperties properties) {
    return builder.rootUri(properties.getSimpleWebServerBaseUrl()).build();
  }

}
