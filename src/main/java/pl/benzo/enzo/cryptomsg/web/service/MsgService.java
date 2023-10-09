package pl.benzo.enzo.cryptomsg.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.benzo.enzo.cryptomsg.util.TimeConverter;
import pl.benzo.enzo.cryptomsg.web.MsgApi;
import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.dto.response.ReadMsgResponse;
import pl.benzo.enzo.cryptomsg.web.mapper.CreateMsgMapper;
import pl.benzo.enzo.cryptomsg.web.mapper.ReadMsgMapper;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MsgService implements MsgApi {

    private final MsgDBService msgDBService;

    public List<Msg> tmpGetAll(){
        return msgDBService.listOfMessages();
    }
    @Override
    public CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest) {
        final CreateMsgMapper createMsgMapper = new CreateMsgMapper();
        final Msg msg = createMsgMapper.requestMapper(createMsgRequest);
        msgDBService.saveMsg(msg);
        return createMsgMapper.responseMapper(msg);
    }

    @Override
    public ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest){
      final ReadMsgMapper readMsgMapper = new ReadMsgMapper();
      final Msg msg = msgDBService.findMsgById(readMsgRequest.id());
      final ReadMsgResponse readMsgResponse = readMsgMapper.responseMapper(msg);
      msgDBService.deleteMsg(readMsgRequest.id());
      return readMsgResponse;
    }
}
