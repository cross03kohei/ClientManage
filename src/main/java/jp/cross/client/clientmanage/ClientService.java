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


}
