package pl.benzo.enzo.cryptomsg.web.service;

import org.springframework.stereotype.Service;

import pl.benzo.enzo.cryptomsg.util.TimeConverter;
import pl.benzo.enzo.cryptomsg.web.MsgApi;
import pl.benzo.enzo.cryptomsg.web.model.Msg;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.model.dto.response.ReadMsgResponse;
import pl.benzo.enzo.cryptomsg.web.model.mapper.CreateMsgMapper;
import pl.benzo.enzo.cryptomsg.web.model.mapper.ReadMsgMapper;
import pl.benzo.enzo.cryptomsg.web.repository.mongo.MsgRepository;

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
        final LocalDateTime timeNow = LocalDateTime.now();
        tmpMsg.setSendAt(timeNow);
        final LocalDateTime deleteIn = TimeConverter.addMinutes(timeNow, tmpMsg.getDeleteAfter());
        tmpMsg.setDeleteAt(deleteIn);
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
}
