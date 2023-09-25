package pl.benzo.enzo.cryptomsg.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;
import pl.benzo.enzo.cryptomsg.web.service.MsgService;

public class ProfileConfiguration {

    @Bean
    @Profile("atom")
    public MsgService msgServiceForAtom(ImplBaseRepository atomRepository) {
        return new MsgService(atomRepository);
    }

    @Bean
    @Profile("integration")
    public MsgService msgServiceForIntegration(ImplBaseRepository integrationRepository) {
        return new MsgService(integrationRepository);
    }
}
