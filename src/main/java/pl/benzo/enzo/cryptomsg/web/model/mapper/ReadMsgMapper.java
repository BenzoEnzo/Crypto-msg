package pl.benzo.enzo.cryptomsg.web.model.mapper;

import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.ReadMsgResponse;

public class ReadMsgMapper implements Mapper<ReadMsgRequest, ReadMsgResponse> {

    @Override
    public Msg requestMapper(ReadMsgRequest readMsgRequest) {
        return null;
    }
    @Override
    public ReadMsgResponse responseMapper(Msg msg) {
        return new ReadMsgResponse(msg.getContent(),msg.getOpenAt(),msg.isSuccess());
    }
}
