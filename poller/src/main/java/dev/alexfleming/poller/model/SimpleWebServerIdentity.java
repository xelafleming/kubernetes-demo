package dev.alexfleming.poller.model;

public class SimpleWebServerIdentity {

  private String podIdentifier;

  public SimpleWebServerIdentity(String podIdentifier) {
    this.podIdentifier = podIdentifier;
  }

  public SimpleWebServerIdentity() {
  }

  public String getPodIdentifier() {
    return podIdentifier;
  }

  public void setPodIdentifier(String podIdentifier) {
    this.podIdentifier = podIdentifier;
  }
}
