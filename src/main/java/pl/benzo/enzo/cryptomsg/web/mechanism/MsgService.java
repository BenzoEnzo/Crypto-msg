package pl.benzo.enzo.cryptomsg.web.mechanism;


import org.springframework.stereotype.Service;
import pl.benzo.enzo.cryptomsg.web.api.MsgApi;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.CreateMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.request.ReadMsgRequest;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.CreateMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.dto.response.ReadMsgResponse;
import pl.benzo.enzo.cryptomsg.web.transform.mapper.CreateMsgMapper;
import pl.benzo.enzo.cryptomsg.web.transform.mapper.Mapper;
import pl.benzo.enzo.cryptomsg.web.transform.mapper.ReadMsgMapper;

import java.time.LocalDateTime;

@Service
public class MsgService implements MsgApi {
    private final MsgRepository msgRepository;

    public MsgService(MsgRepository msgRepository){
        this.msgRepository = msgRepository;
    }
    @Override
    public CreateMsgResponse createCryptoMessage(CreateMsgRequest createMsgRequest) {
        final CreateMsgMapper createMsgMapper = new CreateMsgMapper();
        final CreateMsgResponse createMsgResponse = createMsgMapper.responseMapper(createMsgRequest);
        if(createMsgResponse.securityKey().isCorrect()){
            final Msg msg = createMsgMapper.entityMapper(createMsgResponse);
            msgRepository.save(msg);
        }
        return createMsgResponse;
    }

    @Override
    public ReadMsgResponse readCryptoMessage(ReadMsgRequest readMsgRequest){
        final Msg msg = msgRepository.findById(readMsgRequest.id()).orElse(null);
        if(readMsgRequest.securityKey().isCorrect() && msg != null){
        final ReadMsgMapper readMsgMapper = new ReadMsgMapper();
        return readMsgMapper.responseMapper(msg);
        } else return null;
    }

}
