package pl.benzo.enzo.cryptomsg.web.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import java.time.LocalDateTime;


@Document
@Collation(value = "Msgs")
public class MongoMsg extends Msg {
    @Id
    private String id;

    @Indexed(expireAfterSeconds = 1)
    private LocalDateTime deleteAtMongo;

    public MongoMsg() {}

    public MongoMsg(Msg msg) {
        setContent(msg.getContent());
        setKey(msg.getKey());
        setSendAt(msg.getSendAt());
        setOpenAt(msg.getOpenAt());
        setDeleteAt(msg.getDeleteAt());
        setSuccess(msg.isSuccess());
        setDeleteAfter(msg.getDeleteAfter());
        this.deleteAtMongo = msg.getDeleteAt();  // copy value to the indexed field
    }

    @Override
    public LocalDateTime getDeleteAt() {
        return deleteAtMongo;
    }

    @Override
    public void setDeleteAt(LocalDateTime deleteAt) {
        super.setDeleteAt(deleteAt);
        this.deleteAtMongo = deleteAt;
    }
}
