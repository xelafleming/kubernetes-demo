package dev.alexfleming.poller.client;

import dev.alexfleming.poller.model.SimpleWebServerIdentity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimpleWebServerClient {

    private final RestTemplate restTemplate;

    public SimpleWebServerClient(@Qualifier("simpleWebServiceRestTemplate") final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SimpleWebServerIdentity getIdentity() {
        return restTemplate.getForObject("/identity", SimpleWebServerIdentity.class);
    }
}
