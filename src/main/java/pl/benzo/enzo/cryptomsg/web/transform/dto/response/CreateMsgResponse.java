package pl.benzo.enzo.cryptomsg.web.transform.dto.response;

import pl.benzo.enzo.cryptomsg.external.dto.KeyDto;

import java.time.LocalDateTime;
import java.util.Objects;

public record CreateMsgResponse(String id, LocalDateTime sendAt) {

}
