package pl.benzo.enzo.cryptomsg.web.model.mapper;

import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.CreateMsgResponse;

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