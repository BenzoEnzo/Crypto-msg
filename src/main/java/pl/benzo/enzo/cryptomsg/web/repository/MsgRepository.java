package pl.benzo.enzo.cryptomsg.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.cryptomsg.web.mechanism.MsgApi;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.ReadMsgResponse;

import java.util.List;


@Repository
public interface MsgRepository extends MongoRepository<Msg,String> {

    @RestController
    @RequestMapping("/api/msg")
    class MsgController {
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
}
