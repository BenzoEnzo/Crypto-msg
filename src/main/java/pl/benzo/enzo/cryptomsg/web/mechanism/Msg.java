package pl.benzo.enzo.cryptomsg.web.mechanism;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.cryptomsg.external.dto.KeyDto;

import java.time.LocalDateTime;


@Document(collection = "Msgs")
public class Msg {

    @Id
    private String id;
    private String content;
    private String key;
    private LocalDateTime send;
    private LocalDateTime open;
    private boolean isSuccess;

    public KeyDto getKeyDto() {
        return keyDto;
    }

    public void setKeyDto(KeyDto keyDto) {
        this.keyDto = keyDto;
    }

    private KeyDto keyDto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getSend() {
        return send;
    }

    public void setSend(LocalDateTime send) {
        this.send = send;
    }

    public LocalDateTime getOpen() {
        return open;
    }

    public void setOpen(LocalDateTime open) {
        this.open = open;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Msg(boolean isSuccess, String content, LocalDateTime send) {
        this.isSuccess = isSuccess;
        this.content = content;
        this.send = send;
    }

    public Msg(String key,String content){
        this.key = key;
        this.content = content;
    }

    public Msg(String id){

    }
}
