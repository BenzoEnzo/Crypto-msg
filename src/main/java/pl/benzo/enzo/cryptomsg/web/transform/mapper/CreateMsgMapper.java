package pl.benzo.enzo.cryptomsg.web.transform.mapper;

import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;

public class CreateMsgMapper implements Mapper<CreateMsgRequest,CreateMsgResponse> {

    @Override
    public Msg requestMapper(CreateMsgRequest createMsgRequest) {
        return new Msg(createMsgRequest.content(),createMsgRequest.deleteAfterTime());
    }

    @Override
    public CreateMsgResponse responseMapper(Msg msg) {
        return new CreateMsgResponse(msg.getId(),msg.getSendAt());
    }

}