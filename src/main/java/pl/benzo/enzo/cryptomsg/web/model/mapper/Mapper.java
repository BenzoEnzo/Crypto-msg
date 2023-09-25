package pl.benzo.enzo.cryptomsg.web.model.mapper;

import pl.benzo.enzo.cryptomsg.web.model.Msg;

public interface Mapper <R,S> {
    Msg requestMapper(R r);
    S responseMapper(Msg msg);
}
