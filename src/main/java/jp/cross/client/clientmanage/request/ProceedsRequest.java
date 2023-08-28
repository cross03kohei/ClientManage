package jp.cross.client.clientmanage.request;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Manager;
import lombok.Data;

@Data
public class ProceedsRequest {
    private String content;
    private String date;
    private Integer cost;
    private Integer proceeds;
    private Integer payment;
    private Integer managerId;
    private Integer clientId;
}
