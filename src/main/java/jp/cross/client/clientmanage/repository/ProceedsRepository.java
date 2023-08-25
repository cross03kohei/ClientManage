package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Proceeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProceedsRepository extends JpaRepository<Proceeds,Integer>, JpaSpecificationExecutor<Proceeds> {

    @Query("SELECT m FROM Proceeds m order by m.date desc")
    List<Proceeds> getProceedsList();

    @Query("SELECT m FROM Proceeds m WHERE m.client.id = :id order by m.date desc")
    List<Proceeds> getProceedsClient(@Param("id") Integer id);
}
