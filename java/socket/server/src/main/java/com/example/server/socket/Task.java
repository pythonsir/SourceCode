package com.example.server.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Task implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(Task.class);
    private Socket socket;
    private String type; //
    public static final String TYPE_1 = "byte";
    public static final String TYPE_2 = "line";
    public static final String TYPE_3 = "error";


    public Task(Socket socket,String type){
        this.socket = socket;
        this.type = type;
    }

    @Override
    public void run() {


            try {
                if(type.equals(TYPE_1)){
                    operateByte();
                }
                if(type.equals(TYPE_2)){
                    operateLine();
                }
                if(type.equals(TYPE_3)){
                    operateTest();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void operateLine() throws IOException {
        // Reader reader = new InputStreamReader(socket.getInputStream());
        // Writer writer = new OutputStreamWriter(socket.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String temp;
        int index;
        while ((temp=br.readLine()) != null) {
            if ((index = temp.indexOf("EOF")) != -1) {//遇到eof时就结束接收
                sb.append(temp.substring(0, index));
                break;
            }
            sb.append(temp);
        }

        LOG.info("get-client: "+ sb);
        OutputStream write = socket.getOutputStream();
        String message="你好  客户端";
        write.write(message.getBytes("UTF-8"));
        write.write("EOF\n".getBytes("UTF-8"));
        LOG.info("to-client: "+ message);
        write.flush();
        write.close();
        br.close();
        socket.close();

    }

    private void operateTest() throws  IOException{

        t1();
        t1();
        t1();
        socket.close();

    }
    private void t1()throws  IOException{
        InputStream read = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] bytes = new byte[1024];
        while ((len = read.read(bytes)) != -1){
            if(len == 12){
                sb.append(new String(bytes,0,len,"UTF-8"));
                break;
            }

        }
        LOG.info("get-client: "+ sb);
        OutputStream write = socket.getOutputStream();
        String message="发送"+sb+"回应";
        write.write(message.getBytes("UTF-8"));
        write.flush();
        LOG.info("to-client: "+ message);

    }

    private void operateByte() throws IOException {
        InputStream read = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len;
        int index;
        while ((len = read.read(bytes))!= -1){
            String temp = new String(bytes,0,len,"UTF-8");
            if((index = temp.indexOf("EOF")) != -1){
                sb.append(temp.substring(0,index));
                break;
            }
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        read.close();
        LOG.info("get-client: "+ sb);
        OutputStream write = socket.getOutputStream();
        String message="你好  客户端";
        write.write(message.getBytes("UTF-8"));
        write.write("EOF".getBytes("UTF-8"));
        LOG.info("to-client: "+ message);
        write.flush();
        write.close();
        socket.close();
    }
}
