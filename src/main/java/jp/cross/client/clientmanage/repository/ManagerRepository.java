package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
