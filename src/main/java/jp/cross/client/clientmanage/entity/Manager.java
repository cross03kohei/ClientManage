package jp.cross.client.clientmanage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manager")
@Getter
@Setter
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主キーが自動生成される
    private Integer id;

    /**
     * 名前
     */
    @Column(name="manager_name", nullable = false, length = 30)
    private String managerName;

    /**
     * 所属
     */
    @Column(name="affiliation", nullable = false, length = 30)
    private String affiliation;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Proceeds> proceeds;

}
