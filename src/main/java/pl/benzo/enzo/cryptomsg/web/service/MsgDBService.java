package pl.benzo.enzo.cryptomsg.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.benzo.enzo.cryptomsg.web.entity.Msg;
import pl.benzo.enzo.cryptomsg.web.repository.crud.ImplBaseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MsgDBService {
    private final ImplBaseRepository msgRepository;
    public List<Msg> listOfMessages(){
        return msgRepository.findAll();
    }

    public void saveMsg(Msg msg){
        msgRepository.save(msg);
    }

    public void deleteMsg(String id){
        msgRepository.deleteById(id);
    }
    public Msg findMsgById(String id){
        return msgRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message with ID" + id + " doesnt exist"));
    }
}
