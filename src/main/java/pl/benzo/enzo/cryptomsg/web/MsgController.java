package pl.benzo.enzo.cryptomsg.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;
import pl.benzo.enzo.cryptomsg.web.mechanism.MsgApi;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
public class MsgController {
    private final MsgApi msgApi;

    public MsgController(MsgApi msgApi) {
        this.msgApi = msgApi;
    }

    @GetMapping
    public ResponseEntity<List<Msg>> listOfAllTemporary(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msgApi.tmpGetAll());
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateMsgResponse> create(@RequestBody CreateMsgRequest createMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(msgApi.createCryptoMessage(createMsgRequest));
    }

    @PostMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReadMsgResponse> read(@RequestBody ReadMsgRequest readMsgRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msgApi.readCryptoMessage(readMsgRequest));

    }
}
