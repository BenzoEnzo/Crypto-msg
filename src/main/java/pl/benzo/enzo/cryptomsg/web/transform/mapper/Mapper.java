package pl.benzo.enzo.cryptomsg.web.transform.mapper;

import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;

public interface Mapper <R,S> {
    Msg requestMapper(R r);
    S responseMapper(Msg msg);
}
