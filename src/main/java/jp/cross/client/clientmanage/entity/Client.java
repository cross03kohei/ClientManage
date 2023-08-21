package jp.cross.client.clientmanage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "client") //テーブル名の指定
@Getter
@Setter  //getメソッドとsetメソッドを自動的に作成してくれる
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主キーが自動生成される
    private Integer id;

    /**
     * 名前
     */
    @Column(name="name", nullable = false, length = 30)
    private String name;

    /**
     * 電話番号
     */
    @Column(name="telephone_number", nullable = false, length = 12)
    private String telephone_number;

    /**
     * 住所
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * orphanRemoval=true 親クラスが削除されると子クラスまで削除される
     */
    @OneToMany(orphanRemoval=true, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Proceeds> proceeds;


}
