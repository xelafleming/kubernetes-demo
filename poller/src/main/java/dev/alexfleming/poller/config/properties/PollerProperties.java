package dev.alexfleming.poller.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "poller")
@Component
public class PollerProperties {

  private String simpleWebServerBaseUrl;

  public String getSimpleWebServerBaseUrl() {
    return simpleWebServerBaseUrl;
  }

  public void setSimpleWebServerBaseUrl(String simpleWebServerBaseUrl) {
    this.simpleWebServerBaseUrl = simpleWebServerBaseUrl;
  }
}
