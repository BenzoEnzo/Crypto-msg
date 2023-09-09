package pl.benzo.enzo.cryptomsg.web.transform.dto.request;

import pl.benzo.enzo.cryptomsg.external.dto.KeyDto;

public record ReadMsgRequest(String id, KeyDto securityKey) {
}
