package pl.benzo.enzo.cryptomsg.web.mapper;

import pl.benzo.enzo.cryptomsg.web.entity.Msg;

public interface Mapper <R,S> {
    Msg requestMapper(R r);
    S responseMapper(Msg msg);
}
