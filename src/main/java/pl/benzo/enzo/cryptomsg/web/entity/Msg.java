package pl.benzo.enzo.cryptomsg.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Getter
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
