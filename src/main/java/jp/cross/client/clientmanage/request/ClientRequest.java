package jp.cross.client.clientmanage.request;

import lombok.Data;

@Data
public class ClientRequest {
    private Integer id;
    private String clientName;
    private String telephoneNumber;
    private String address;
}
