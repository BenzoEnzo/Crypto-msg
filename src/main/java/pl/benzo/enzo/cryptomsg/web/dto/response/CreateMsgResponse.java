package pl.benzo.enzo.cryptomsg.web.dto.response;

import java.time.LocalDateTime;
public record CreateMsgResponse(String id, LocalDateTime sendAt) {

}
