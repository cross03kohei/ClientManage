package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
