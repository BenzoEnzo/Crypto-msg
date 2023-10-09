package pl.benzo.enzo.cryptomsg.web;

import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.dto.response.ReadMsgResponse;

import java.util.List;

public interface MsgApi {
    CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest);
    ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest);

    List<Msg> tmpGetAll();

}

