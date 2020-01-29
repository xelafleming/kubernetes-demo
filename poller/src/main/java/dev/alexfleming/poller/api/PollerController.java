package dev.alexfleming.poller.api;

import dev.alexfleming.poller.service.PollerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/poller")
public class PollerController {

  private final PollerService service;

  public PollerController(final PollerService service) {
    this.service = service;
  }

  @GetMapping(path = "/invoke")
  public String invoke(@RequestParam final Integer timesToPoll) {
    service.pollWebServerIdentity(timesToPoll);
    return String.format("Poller complete - polled %s times...", timesToPoll);
  }

}
