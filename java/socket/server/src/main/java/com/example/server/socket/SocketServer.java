package com.example.server.socket;

import com.example.server.ServerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class SocketServer {

    private static final Logger LOG = LoggerFactory.getLogger(SocketServer.class);

    public SocketServer() {
        try {
            ServerSocket server = new ServerSocket(6001);

            LOG.info("服务器端等待连接");

            while (true){
                Socket  socket = server.accept();
                new Thread(new Task(socket,Task.TYPE_3)).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }







}
