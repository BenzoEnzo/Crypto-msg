package pl.benzo.enzo.cryptomsg.web.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.PrimaryKey;
import pl.benzo.enzo.cryptomsg.web.model.Msg;

import java.time.LocalDateTime;


@Table(name = "Msgs")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JpaMsg extends Msg {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "content_msg")
    private String content;
    @Column(name = "key_msg")
    private String key;
    @Column(name = "sendAt_msg")
    private LocalDateTime sendAt;
    @Column(name = "openAt_msg")
    private LocalDateTime openAt;
    @Column(name = "deleteAt_msg")
    private LocalDateTime deleteAt;
    @Column(name = "isSuccess_msg")
    private boolean isSuccess;
    @Column(name = "deleteAfter_msg")
    private int deleteAfter;

}
