package dev.alexfleming.api.messaging;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class IdentityListener {

  private final Set<String> podIdentities = new HashSet<>();

  private Integer pollsRetrieved = 0;

  private static final Logger LOGGER = LoggerFactory.getLogger(IdentityListener.class);

  @RabbitListener(queues = "podIdentity")
  public void getIdentity(@Payload String podIdentity) {
    podIdentities.add(podIdentity);
    pollsRetrieved++;
    LOGGER.info("Received pings from {}. Received {} pings.", podIdentities, pollsRetrieved);
  }
}