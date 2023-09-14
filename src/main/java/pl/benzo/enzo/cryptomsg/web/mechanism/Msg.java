package pl.benzo.enzo.cryptomsg.web.mechanism;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.cryptomsg.external.dto.KeyDto;

import java.time.LocalDateTime;


@Document(collection = "Msgs")
@Getter
@Setter
@AllArgsConstructor
public class Msg {

    @Id
    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    @Indexed(expireAfterSeconds = 0)
    private LocalDateTime deleteAt;
    private boolean isSuccess;
    private int deleteAfter;

    public Msg(String content, LocalDateTime sendAt, int deleteAfter) {
        this.content = content;
        this.sendAt = sendAt;
        this.deleteAfter = deleteAfter;
    }

    public Msg(String content,LocalDateTime openAt,boolean isSuccess){
        this.content = content;
        this.openAt = openAt;
        this.isSuccess = isSuccess;
    }
    public Msg() {

    }
}
