package pl.benzo.enzo.cryptomsg.web.repository.crud;

import pl.benzo.enzo.cryptomsg.web.model.Msg;

import java.util.List;
import java.util.Optional;


public interface CrudRepository extends Repository<Msg,String>{

    Msg save(Msg msg);

    Optional<Msg> findById(String id);

    List<Msg> findAll();

    void deleteById(String id);
}
