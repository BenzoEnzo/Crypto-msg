package pl.benzo.enzo.cryptomsg.web.repository.h2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.benzo.enzo.cryptomsg.util.IdGenerator;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.entity.JpaMsg;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("atom")
@Transactional()
public class MsgJpaRepository implements ImplBaseRepository {


    private final EntityManager entityManager;

    @Autowired
    public MsgJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Msg msg) {
        final String id = IdGenerator.generateId();
        msg.setId(id);
        JpaMsg jpaMsg = new JpaMsg(msg);
        entityManager.merge(jpaMsg);
    }

    @Override
    public Optional<Msg> findById(String id) {
        TypedQuery<JpaMsg> query = entityManager.createQuery("SELECT m FROM JpaMsg m WHERE m.id = :id", JpaMsg.class);
        query.setParameter("id", id);  // ustawiamy wartość parametru zapytania
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Msg> findAll() {
        TypedQuery<Msg> query = entityManager.createQuery("SELECT m FROM JpaMsg m", Msg.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(String id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
