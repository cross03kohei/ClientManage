package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ClientRepository extends JpaRepository<Client,Integer>, JpaSpecificationExecutor<Client> {

}
