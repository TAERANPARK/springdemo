package com.multi.di.di6;

import lombok.Data;

@Data
public class DbServer {
    private String serverName;
    private String serverUrl;
    private int serverPort;
    private int connectionCount;
}
