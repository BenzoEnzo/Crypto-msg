package pl.benzo.enzo.cryptomsg.web.mechanism;


import org.springframework.stereotype.Service;

@Service
public class MsgService {
    private final MsgRepository msgRepository;
    public MsgService(MsgRepository msgRepository){
        this.msgRepository = msgRepository;
    }

}
