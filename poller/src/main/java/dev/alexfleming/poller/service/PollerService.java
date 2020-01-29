package dev.alexfleming.poller.service;

import dev.alexfleming.poller.client.SimpleWebServerClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PollerService {

  private final SimpleWebServerClient client;

  private final RabbitTemplate rabbitTemplate;

  public PollerService(final SimpleWebServerClient client,
      final RabbitTemplate rabbitTemplate) {
    this.client = client;
    this.rabbitTemplate = rabbitTemplate;
  }

  public void pollWebServerIdentity(Integer timesToPoll) {
    while (timesToPoll > 0) {
      rabbitTemplate.convertAndSend("podIdentity", client.getIdentity().getPodIdentifier());
      timesToPoll--;
    }
  }
}
