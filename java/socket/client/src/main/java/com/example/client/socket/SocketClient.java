package com.example.client.socket;

import com.example.client.ClientApplication;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;


public class SocketClient {

    public static final Logger LOG;

    private  Socket socket;

    static {
        LOG = LoggerFactory.getLogger(SocketClient.class);
    }
    public SocketClient()  {
        String host = "127.0.0.1";
        int port = 6001;
        try {
            socket = new Socket(host,port);
            this.operateByteTest();
            this.operateByteTest1();
            this.operateByteTest2();
            OutputStream write = socket.getOutputStream();
            InputStream read = socket.getInputStream();
            write.close();
            read.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void operateLine() throws IOException{
        // Reader reader = new InputStreamReader(socket.getInputStream());
        // Writer writer = new OutputStreamWriter(socket.getOutputStream());
        String message="你好  服务端";
        OutputStream write = socket.getOutputStream();
        write.write(message.getBytes("UTF-8"));
        write.flush();
        LOG.info("to-server:" + message);
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
        LOG.info("get-server:" + sb);
        write.close();
        br.close();
        socket.close();


    }

    private void operateByteTest() throws IOException{
        String message="100110011001";
        LOG.info(message.getBytes("UTF-8").length+"");
        OutputStream write = socket.getOutputStream();
        write.write(message.getBytes("UTF-8"));
        write.flush();
        LOG.info("to-server:" + message);
        InputStream read = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        while (true){
          int size = read.available();
          if(size <= 0){
              continue;
          }
          byte[] bytes = new byte[size];
          read.read(bytes);
          sb.append(new String(bytes,0,size,"UTF-8"));
          break;
        }
        LOG.info("get-server:" + sb);
    }
    private void operateByteTest1() throws IOException{
        String message="100210021002";
        LOG.info(message.getBytes("UTF-8").length+"");
        OutputStream write = socket.getOutputStream();
        write.write(message.getBytes("UTF-8"));
        //  write.write("EOF".getBytes("UTF-8"));
        write.flush();
        LOG.info("to-server:" + message);
        InputStream read = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        while (true){
            int size = read.available();
            if(size <= 0){
                continue;
            }
            byte[] bytes = new byte[size];
            read.read(bytes);
            sb.append(new String(bytes));
            break;
        }
        LOG.info("get-server:" + sb);
    }
    private void operateByteTest2() throws IOException{
        String message="100310031003";
        LOG.info(message.getBytes("UTF-8").length+"");
        OutputStream write = socket.getOutputStream();
        write.write(message.getBytes("UTF-8"));
        //  write.write("EOF".getBytes("UTF-8"));
        write.flush();
        LOG.info("to-server:" + message);
        InputStream read = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        while (true){
            int size = read.available();
            if(size <= 0){
                continue;
            }
            byte[] bytes = new byte[size];
            read.read(bytes);
            sb.append(new String(bytes));
            break;
        }
        LOG.info("get-server:" + sb);
    }


    private void operateByte() throws IOException {

            String message="你好  服务端";
            OutputStream write = socket.getOutputStream();
            write.write(message.getBytes("UTF-8"));
          //  write.write("EOF".getBytes("UTF-8"));
            write.flush();
            write.close();
            LOG.info("to-server:" + message);
            InputStream read = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            int index;
            while ((len = read.read(bytes)) != -1){
                String temp = new String(bytes,0,len,"UTF-8");
                if((index = temp.indexOf("EOF")) != -1){
                    sb.append(temp.substring(0,index));
                    break;
                }
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            LOG.info("get-server:" + sb);
            read.close();
            socket.close();


    }




}
