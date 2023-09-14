package pl.benzo.enzo.cryptomsg.external;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/key")
@RequiredArgsConstructor
public class KeyController {
    private final KeyApi keyApi;
    @GetMapping
    public ResponseEntity<String> getSecurityKey(){
        return keyApi.getKey();
    }

    @PostMapping(value = "/verify-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> validateToken(@RequestBody String encryptedKey){
        return keyApi.validateKey(encryptedKey);
    }
}
