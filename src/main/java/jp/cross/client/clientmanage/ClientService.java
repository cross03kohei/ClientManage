package jp.cross.client.clientmanage;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Proceeds;
import jp.cross.client.clientmanage.repository.ClientRepository;
import jp.cross.client.clientmanage.repository.ManagerRepository;
import jp.cross.client.clientmanage.repository.ProceedsRepository;
import jp.cross.client.clientmanage.request.ClientRequest;
import jp.cross.client.clientmanage.specification.ProceedsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import jp.cross.client.clientmanage.specification.*;


@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    ProceedsRepository proceedsRepository;

    public List<Proceeds> getProceedsList(){
        return proceedsRepository.getProceedsList();
    }

    public List<Client> getClientList() { return clientRepository.findAll();
    }

    public List<Proceeds> searchProceeds(String date){
        return proceedsRepository.findAll(Specification.where(new ProceedsSpecification()
                .dateContains(date)));
    }

    public List<Client> searchClients(String name) {
        ClientSpecification cs = new ClientSpecification();
        return clientRepository.findAll(Specification.where(cs.clientNameContains(name)));
    }

    public void saveClient(ClientRequest c){
        clientRepository.save(createClient(c));
    }

    /**
     *Clientクラスに値を代入して渡す
     */

    private Client createClient(ClientRequest c){
        Client client = new Client();
        client.setId(c.getId());
        client.setClientName(c.getClientName());
        client.setTelephoneNumber(c.getTelephoneNumber());
        client.setAddress(c.getAddress());
        return client;
    }
}
