package pl.benzo.enzo.cryptomsg.web.mapper;

import pl.benzo.enzo.cryptomsg.util.TimeConverter;
import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.response.CreateMsgResponse;

import java.time.LocalDateTime;

public class CreateMsgMapper {

    public Msg requestMapper(CreateMsgRequest createMsgRequest) {
        final LocalDateTime sendAt = LocalDateTime.now();
        final LocalDateTime deleteAt = TimeConverter.addMinutes(sendAt, createMsgRequest.deleteAfterTime());
        return new Msg(createMsgRequest.content(),createMsgRequest.deleteAfterTime(),deleteAt,sendAt);
    }

    public CreateMsgResponse responseMapper(Msg msg) {
        return new CreateMsgResponse(msg.getId(),msg.getSendAt());
    }

}