package com.multi.di.di6;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DbServer {
    //@Value( "${com.multi.serverName3}")
    @Value("${com.multi.serverName3}")
    private String serverName;
    @Value("${com.multi.severUrl3}")
    private String serverUrl;      // XML에서 p:serverUrl=... 로 주입
    @Value("${com.multi.serverPort2}")
    private int serverPort;
    @Value("${com.multi.connectionCount3}")
    private int connectionCount;


}