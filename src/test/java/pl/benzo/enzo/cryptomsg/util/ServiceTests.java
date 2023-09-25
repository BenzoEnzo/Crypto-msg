package pl.benzo.enzo.cryptomsg.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.mongo.MsgRepository;
import pl.benzo.enzo.cryptomsg.web.service.MsgService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@Slf4j
@ExtendWith(MockitoExtension.class)
public class ServiceTests {
    private static final Logger logger = LoggerFactory.getLogger(ServiceTests.class);

    @Mock
    private MsgRepository msgRepository;

    @InjectMocks
    private MsgService msgService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(ServiceTests.class);
    }

    @Test
    public void getListOfAllTest() {
        Msg msg1 = new Msg();
        when(msgRepository.findAll()).thenReturn(Collections.singletonList(msg1));

        List<Msg> result = msgService.tmpGetAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(msg1, result.get(0));

        logger.info("Testy serwisu zwracającego wszystkie wiadomości zakończony sukcesem!");
    }
}