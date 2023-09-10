package pl.benzo.enzo.cryptomsg.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.cryptomsg.web.api.MsgApi;
import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;
import pl.benzo.enzo.cryptomsg.web.mechanism.MsgService;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
public class MsgController {
    private final MsgService msgService;
    public MsgController(MsgService msgService) {
        this.msgService = msgService;
    }

    @GetMapping
    public ResponseEntity<List<Msg>> listOfAllTemporary(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msgService.tmpGetAll());
    }
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateMsgResponse> create(@RequestBody CreateMsgRequest createMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( msgService.createCryptoMessage(createMsgRequest));
    }

    @PostMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReadMsgResponse> read(@RequestBody ReadMsgRequest readMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msgService.readCryptoMessage(readMsgRequest));

    }
}
