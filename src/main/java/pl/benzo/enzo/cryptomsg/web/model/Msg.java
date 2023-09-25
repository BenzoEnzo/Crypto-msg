package pl.benzo.enzo.cryptomsg.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Msg {

    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    private LocalDateTime deleteAt;
    private boolean isSuccess;
    private int deleteAfter;

    public Msg(){}

    public Msg(String content, int deleteAfter) {
        this.content = content;
        this.deleteAfter = deleteAfter;
    }
}
