package pl.benzo.enzo.cryptomsg.web.mechanism;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MsgRepository extends MongoRepository<Msg,String> {

}
