package pl.benzo.enzo.cryptomsg.external;

import org.springframework.http.ResponseEntity;
import pl.benzo.enzo.cryptomsg.external.configuration.CryptoKeyClient;

public interface KeyApi {

    ResponseEntity<String> getKey();
    ResponseEntity<Boolean> validateKey(String encryptedKey);
}
