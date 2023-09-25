package pl.benzo.enzo.cryptomsg.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.cryptomsg.web.model.Msg;

@Repository
public interface MsgRepository extends MongoRepository<Msg,String> {
}
