package pl.benzo.enzo.cryptomsg.web.repository.h2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.crud.CrudRepository;

import java.util.List;
import java.util.Optional;


public class MsgRepository implements CrudRepository {

    private final EntityManager entityManager;

    public MsgRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Msg save(Msg msg) {
        if (msg.getId() == null) {
            entityManager.persist(msg);
            return msg;
        } else {
            return entityManager.merge(msg);
        }
    }

    @Override
    public Optional<Msg> findById(String id) {
        return Optional.ofNullable(entityManager.find(Msg.class, id));
    }

    @Override
    public List<Msg> findAll() {
        TypedQuery<Msg> query = entityManager.createQuery("SELECT m FROM Msg m", Msg.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(String id) {
        Msg msg = entityManager.find(Msg.class, id);
        if (msg != null) {
            entityManager.remove(msg);
        }
    }
}
