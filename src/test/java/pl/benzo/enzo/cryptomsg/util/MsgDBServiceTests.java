package pl.benzo.enzo.cryptomsg.util;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;
import pl.benzo.enzo.cryptomsg.web.service.MsgDBService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MsgDBServiceTests {
    @Mock
    private ImplBaseRepository msgRepository;

    @InjectMocks
    private MsgDBService msgDBService;

    @Test
    public void shouldReturnAllMessages() {
        List<Msg> expectedMessages = Arrays.asList(
                new Msg("Content Testowy"),
                new Msg("Content Testowy 2")
        );

        when(msgRepository.findAll()).thenReturn(expectedMessages);

        List<Msg> actualMessages = msgDBService.listOfMessages();

        assertEquals(expectedMessages, actualMessages);
    }

    @Test
    public void shouldDeleteMessage(){
        Msg msg = new Msg("testowy");

        msgDBService.deleteMsg(msg.getId());

        verify(msgRepository,times(1)).deleteById(msg.getId());
    }

    @Test
    public void shouldSaveMessage(){
        Msg msg = new Msg("testowy");

        msgDBService.saveMsg(msg);

        verify(msgRepository,times(1)).save(msg);
    }

    @Test
    void shouldFindMessageById() {
        Msg expectedMsg = new Msg("Content Testowy");
        String id = expectedMsg.getId();

        when(msgRepository.findById(id)).thenReturn(Optional.of(expectedMsg));

        Msg actualMsg = msgDBService.findMsgById(id);

        assertEquals(expectedMsg, actualMsg);
    }

    @Test
    void shouldThrowExceptionWhenMessageNotFoundById() {
        String id = "1";
        when(msgRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> msgDBService.findMsgById(id));
    }
}

