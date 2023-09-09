package pl.benzo.enzo.cryptomsg.web.transform.mapper;

import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;

public class ReadMsgMapper implements Mapper<ReadMsgRequest, ReadMsgResponse> {
    public Msg entityMapper(ReadMsgResponse response) {
        return null;
    }

    @Override
    public ReadMsgResponse responseMapper(ReadMsgRequest request) {
        return null;
    }

    public ReadMsgResponse responseMapper(Msg msg) {
        return new ReadMsgResponse(msg.getContent(), msg.getSend());
    }

    @Override
    public Msg requestMapper(ReadMsgRequest readMsgRequest) {
        return new Msg(readMsgRequest.id());
    }

}
