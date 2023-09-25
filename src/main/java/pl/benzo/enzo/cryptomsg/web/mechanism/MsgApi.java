package pl.benzo.enzo.cryptomsg.web.mechanism;

import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.ReadMsgResponse;

import java.util.List;

public interface MsgApi {
    CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest);
    ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest);

    List<Msg> tmpGetAll();

}

