package pl.benzo.enzo.cryptomsg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;
import pl.benzo.enzo.cryptomsg.web.service.MsgDBService;
import pl.benzo.enzo.cryptomsg.web.service.MsgService;


@Configuration
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
