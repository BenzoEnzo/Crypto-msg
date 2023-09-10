package pl.benzo.enzo.cryptomsg.web.mechanism;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MsgData {
    private final MsgService msgService;

    public MsgData(MsgService msgService) {
        this.msgService = msgService;
    }
    @Scheduled(fixedRate = 20000000)
    private void cleaning(){
        msgService.cleanDatabase();
    }
}
