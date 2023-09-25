package pl.benzo.enzo.cryptomsg.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@AllArgsConstructor
@Document
@Collation(value = "Msgs")
@Data
public class Msg {

    @Id
    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    @Indexed(name = "deleteAt", expireAfterSeconds = 1)
    private LocalDateTime deleteAt;
    private boolean isSuccess;
    private int deleteAfter;

    public Msg(){}

    public Msg(String content, int deleteAfter) {
        this.content = content;
        this.deleteAfter = deleteAfter;
    }
}
