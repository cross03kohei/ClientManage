package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    @Query("SELECT m FROM Manager m WHERE m.id = :id")
    Manager getManager(@Param("id") Integer id);
}
