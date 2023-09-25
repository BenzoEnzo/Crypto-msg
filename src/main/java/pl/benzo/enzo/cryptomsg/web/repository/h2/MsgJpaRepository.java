package pl.benzo.enzo.cryptomsg.web.repository.h2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("atom")
public class MsgJpaRepository implements ImplBaseRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Msg msg) {
        if (msg.getId() == null) {
            entityManager.persist(msg);
        } else {
            entityManager.merge(msg);
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
