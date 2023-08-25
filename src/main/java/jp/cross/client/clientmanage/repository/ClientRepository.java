package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Proceeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client,Integer>, JpaSpecificationExecutor<Client> {
    @Query("SELECT m FROM Client m WHERE m.id = :id")
    Client getClient(@Param("id") Integer id);
}
