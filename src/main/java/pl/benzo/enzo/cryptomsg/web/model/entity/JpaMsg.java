package pl.benzo.enzo.cryptomsg.web.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pl.benzo.enzo.cryptomsg.web.model.Msg;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "Msgs")
@Entity
public class JpaMsg extends Msg {

    @Id
    private String id;
    private String content;
    private String key;
    private LocalDateTime sendAt;
    private LocalDateTime openAt;
    private LocalDateTime deleteAt;
    private boolean isSuccess;
    private int deleteAfter;

}
