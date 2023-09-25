package pl.benzo.enzo.cryptomsg.web.model.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import java.time.LocalDateTime;



@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@Setter
public class JpaMsg extends Msg {

    @Id
    private String id;
    @Column(name = "CONTENT")
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

    public JpaMsg(Msg msg) {
        this.setId(msg.getId());
        this.setContent(msg.getContent());
        this.setKey(msg.getKey());
        this.setSendAt(msg.getSendAt());
        this.setOpenAt(msg.getOpenAt());
        this.setDeleteAt(msg.getDeleteAt());
        this.setSuccess(msg.isSuccess());
        this.setDeleteAfter(msg.getDeleteAfter());
    }

    public JpaMsg(){}

    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public LocalDateTime getSendAt() {
        return sendAt;
    }

    @Override
    public LocalDateTime getOpenAt() {
        return openAt;
    }

    @Override
    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public int getDeleteAfter() {
        return deleteAfter;
    }
}
