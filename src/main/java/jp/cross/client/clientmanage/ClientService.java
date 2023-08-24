package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Proceeds;
import jp.cross.client.clientmanage.repository.ClientRepository;
import jp.cross.client.clientmanage.repository.ManagerRepository;
import jp.cross.client.clientmanage.repository.ProceedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ProceedsRepository proceedsRepository;



    public List<Proceeds> getProceedsAll(){
        return proceedsRepository.findAll();
    }

    /**
     * 日付が新しい順に習得する
     *
     */
    public List<Proceeds> getProceedsDesc(){
        return proceedsRepository.getProceedsDesc();
    }

    public List<Proceeds> getProceedsList(){
        return proceedsRepository.getProceedsList();
    }
}
