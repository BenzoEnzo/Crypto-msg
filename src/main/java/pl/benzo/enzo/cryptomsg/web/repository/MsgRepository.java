package pl.benzo.enzo.cryptomsg.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.benzo.enzo.cryptomsg.web.MsgApi;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.ReadMsgResponse;

import java.util.List;


@Repository
public interface MsgRepository extends MongoRepository<Msg,String> {
}
