package com.multi.di.di7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateServer {
    private String serverUrl;
    private int port;
    private String account;
    private String password;
}