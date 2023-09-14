package pl.benzo.enzo.cryptomsg.web.mechanism;


import org.springframework.stereotype.Service;
import pl.benzo.enzo.cryptomsg.web.conditions.TimeConverter;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.mapper.CreateMsgMapper;
import pl.benzo.enzo.cryptomsg.web.transform.mapper.ReadMsgMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MsgService implements MsgApi {
    private final MsgRepository msgRepository;

    public MsgService(MsgRepository msgRepository){
        this.msgRepository = msgRepository;
    }
    public List<Msg> tmpGetAll(){
        return msgRepository.findAll();
    }
    @Override
    public CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest) {
        final CreateMsgMapper createMsgMapper = new CreateMsgMapper();
        Msg tmpMsg = createMsgMapper.requestMapper(createMsgRequest);
        tmpMsg.setDeleteIn(TimeConverter.addMinutes(LocalDateTime.now(), tmpMsg.getDeleteAfter()));
        msgRepository.save(tmpMsg);
        return createMsgMapper.responseMapper(tmpMsg);
    }

    @Override
    public ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest){
      final ReadMsgMapper readMsgMapper = new ReadMsgMapper();
      Msg msg = msgRepository.findById(readMsgRequest.id()).orElse(null);
      if(Objects.nonNull(msg)){
          msg.setSuccess(true);
          msg.setOpenAt(LocalDateTime.now());
          final ReadMsgResponse readMsgResponse = readMsgMapper.responseMapper(msg);
          msgRepository.deleteById(msg.getId());
          return readMsgResponse;
      } else throw new IllegalArgumentException("Msg doesnt exist");
    }

    public void cleanDatabase(){
        msgRepository.deleteAll();
    }
}
