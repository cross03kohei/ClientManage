package jp.cross.client.clientmanage.request;

import jp.cross.client.clientmanage.entity.Client;
import jp.cross.client.clientmanage.entity.Manager;
import lombok.Data;

import java.util.Date;

@Data
public class ProceedsRequest {
    private Integer id;
    private String content;
    private Date date;
    private Integer cost;
    private Integer proceeds;
    private Integer payment;

}
