package com.example.client.controller;

import com.example.client.socket.SocketClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/test")
    public String toString() {
        SocketClient socketClient = new SocketClient();
        return super.toString();
    }
}
