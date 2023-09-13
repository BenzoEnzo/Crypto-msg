package pl.benzo.enzo.cryptomsg.external.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Component
public class CryptoKeyClient {

    private WebClient webClient;

    @Autowired
    public CryptoKeyClient(WebClient.Builder webClientBuilder, ExternalApi externalApi){
        this.webClient = webClientBuilder
                .baseUrl(externalApi.getKey())
                .filter(Logger.logRequest())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<List<String>> getKey(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.getAll());
    }

    public ResponseEntity<Boolean> validateKey(String encryptedKey){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.validateSecurityKey(encryptedKey));
    }

}
