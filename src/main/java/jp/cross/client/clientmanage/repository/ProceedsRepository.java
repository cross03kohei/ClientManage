package jp.cross.client.clientmanage.repository;

import jp.cross.client.clientmanage.entity.Proceeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProceedsRepository extends JpaRepository<Proceeds,Integer>, JpaSpecificationExecutor<Proceeds> {

    @Query(value = "SELECT * FROM proceeds ORDER BY date DESC", nativeQuery = true)
    List<Proceeds> getProceedsDesc();

    @Query("SELECT m FROM Proceeds m")
    List<Proceeds> getProceedsList();
}
