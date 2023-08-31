package jp.cross.client.clientmanage.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "proceeds")
@Getter
@Setter
public class Proceeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主キーが自動生成される
    private Integer id;

    /**
     * 日付型のカラム
     */
    @Column(name = "date",length = 30)
    private String date;

    /**
     * 売上
     */
    @Column(name = "proceeds")
    private Integer proceeds;

    /**
     * 経費
     */
    @Column(name = "cost")
    private Integer cost;

    /**
     * 入金額
     */
    @Column(name = "payment")
    private Integer payment;

    /**
     * 概要
     */
    @Column(name = "content",length = 30)
    private String content;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * 外部キーの設定
     */
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;



}
