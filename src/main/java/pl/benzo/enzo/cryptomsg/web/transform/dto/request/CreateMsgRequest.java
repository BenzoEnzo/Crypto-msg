package pl.benzo.enzo.cryptomsg.web.transform.dto.request;

import pl.benzo.enzo.cryptomsg.external.dto.KeyDto;

import java.time.LocalDateTime;

public record CreateMsgRequest(String content, int deleteAfterTime) {
}
