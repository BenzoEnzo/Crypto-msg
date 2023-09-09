package pl.benzo.enzo.cryptomsg.web.transform.mapper;

import pl.benzo.enzo.cryptomsg.web.mechanism.Msg;

public interface Mapper <R,S> {
    Msg entityMapper(S response);
    S responseMapper(R request);
    Msg requestMapper(R r);
}
