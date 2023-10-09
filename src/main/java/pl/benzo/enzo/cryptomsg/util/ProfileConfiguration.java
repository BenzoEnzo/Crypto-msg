package pl.benzo.enzo.cryptomsg.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;
import pl.benzo.enzo.cryptomsg.web.service.MsgDBService;
import pl.benzo.enzo.cryptomsg.web.service.MsgService;

public class ProfileConfiguration {

    @Bean
    @Profile("atom")
    public MsgDBService msgServiceForAtom(ImplBaseRepository atomRepository) {
        return new MsgDBService(atomRepository);
    }

    @Bean
    @Profile("integration")
    public MsgDBService msgServiceForIntegration(ImplBaseRepository integrationRepository) {
        return new MsgDBService(integrationRepository);
    }
}
