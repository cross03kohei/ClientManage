package jp.cross.client.clientmanage.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jp.cross.client.clientmanage.entity.Client;
import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

public class ClientSpecification {
    public Specification<Client> clientNameContains(String name){
        return StringUtils.isEmpty(name) ? null : new Specification<Client>() {
            @Override
            public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("clientName"), name + "%");
            }
        };
    }
}
