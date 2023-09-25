package pl.benzo.enzo.cryptomsg.web.repository.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class MsgRepository implements CrudRepository {


    private final MongoTemplate mongoTemplate;

    public MsgRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Msg save(Msg msg) {
        return mongoTemplate.save(msg);
    }

    @Override
    public Optional<Msg> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Msg.class));
    }

    @Override
    public List<Msg> findAll() {
        return mongoTemplate.findAll(Msg.class);
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Msg.class);
    }
}
