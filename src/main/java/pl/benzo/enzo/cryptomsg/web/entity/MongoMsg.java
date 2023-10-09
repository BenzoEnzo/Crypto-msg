package pl.benzo.enzo.cryptomsg.web.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
        setDeleteAfter(msg.getDeleteAfter());
        this.deleteAtMongo = msg.getDeleteAt();
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
