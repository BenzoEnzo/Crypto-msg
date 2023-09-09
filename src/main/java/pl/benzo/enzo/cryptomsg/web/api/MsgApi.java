package pl.benzo.enzo.cryptomsg.web.api;

import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;

public interface MsgApi {
    CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest);
    ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest);

}
