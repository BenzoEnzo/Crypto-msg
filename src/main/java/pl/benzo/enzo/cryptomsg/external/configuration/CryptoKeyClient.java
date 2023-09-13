package pl.benzo.enzo.cryptomsg.external.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.benzo.enzo.cryptomsg.external.KeyApi;

import java.util.List;

@Slf4j
@Component
public class CryptoKeyClient implements KeyApi {

    private WebClient webClient;

    @Autowired
    public CryptoKeyClient(WebClient.Builder webClientBuilder, ExternalApi externalApi){
        this.webClient = webClientBuilder
                .baseUrl(externalApi.getKey())
                .filter(Logger.logRequest())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<String> getKey(){
        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> ResponseEntity.ok().body(responseBody))
                .block();

    }

    public ResponseEntity<Boolean> validateKey(String encryptedKey){
        return webClient.post()
                .uri("/verify")
                .bodyValue(encryptedKey)
                .retrieve()
                .bodyToMono(Boolean.class)
                .map(responseBody -> ResponseEntity.ok().body(responseBody))
                .block();
    }
}
