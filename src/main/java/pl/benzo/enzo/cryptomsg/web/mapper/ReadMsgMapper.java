package pl.benzo.enzo.cryptomsg.web.mapper;

import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.response.ReadMsgResponse;

public class ReadMsgMapper {
    public ReadMsgResponse responseMapper(Msg msg) {
        return new ReadMsgResponse(msg.getContent(),msg.getOpenAt(),msg.isSuccess());
    }
}
