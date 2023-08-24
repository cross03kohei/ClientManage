package jp.cross.client.clientmanage.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jp.cross.client.clientmanage.entity.Proceeds;
import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

public class ProceedsSpecification {

    public Specification<Proceeds> dateContains(String date){
        return StringUtils.isEmpty(date) ? null : new Specification<Proceeds>() {
            @Override
            public Predicate toPredicate(Root<Proceeds> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("date"), date + "%");
            }
        };

    }
}
