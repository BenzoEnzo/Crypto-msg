package pl.benzo.enzo.cryptomsg.web.mechanism;


import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "Msgs")
@AllArgsConstructor
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

    public Msg(String content, int deleteAfter) {
        this.content = content;
        this.deleteAfter = deleteAfter;
    }

    public Msg(String content,LocalDateTime openAt,boolean isSuccess){
        this.content = content;
        this.openAt = openAt;
        this.isSuccess = isSuccess;
    }
    public Msg() {
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDateTime getSendAt() {
        return sendAt;
    }

    public void setSendAt(LocalDateTime sendAt) {
        this.sendAt = sendAt;
    }

    public LocalDateTime getOpenAt() {
        return openAt;
    }

    public void setOpenAt(LocalDateTime openAt) {
        this.openAt = openAt;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getDeleteAfter() {
        return deleteAfter;
    }

    public void setDeleteAfter(int deleteAfter) {
        this.deleteAfter = deleteAfter;
    }
}
