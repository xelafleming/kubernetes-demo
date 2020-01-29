package dev.alexfleming.api.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

  @Bean
  public Queue podIdentity() {
    return new Queue("podIdentity");
  }

}