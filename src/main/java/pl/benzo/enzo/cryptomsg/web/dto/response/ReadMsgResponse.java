package pl.benzo.enzo.cryptomsg.web.dto.response;

import java.time.LocalDateTime;

public record ReadMsgResponse(String content, LocalDateTime openedAt, boolean isSuccess) {
}