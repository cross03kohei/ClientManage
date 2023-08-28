package jp.cross.client.clientmanage.request;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Manager;
import lombok.Data;

@Data
public class ProceedsRequest {
    private Integer id;
    private String content;
    private String data;
    private Integer cost;
    private Integer proceeds;
    private Integer payment;
    private Manager manager;
    private Client client;

}
