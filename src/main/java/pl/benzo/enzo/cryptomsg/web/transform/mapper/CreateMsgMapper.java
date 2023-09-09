package pl.benzo.enzo.cryptomsg.web.transform.mapper;

import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;

import java.time.LocalDateTime;

public class CreateMsgMapper implements Mapper<CreateMsgRequest,CreateMsgResponse> {

    public Msg entityMapper(CreateMsgResponse createMsgResponse) {
        return new Msg(createMsgResponse.securityKey().isCorrect(),createMsgResponse.content(), createMsgResponse.send());
    }

    public CreateMsgResponse responseMapper(CreateMsgRequest createMsgRequest){
        return new CreateMsgResponse(createMsgRequest.securityKey(), createMsgRequest.content(), createMsgRequest.send());
    }

    public Msg requestMapper(CreateMsgRequest createMsgRequest) {
        return null;
    }

}