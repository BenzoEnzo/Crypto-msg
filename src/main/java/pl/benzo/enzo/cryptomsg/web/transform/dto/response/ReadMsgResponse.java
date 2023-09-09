package pl.benzo.enzo.cryptomsg.web.transform.dto.response;

import java.time.LocalDateTime;

public record ReadMsgResponse(String content, LocalDateTime send) {
}
