package com.example.client.controller;

import com.example.client.cxf.*;
import com.example.client.cxf.soapintercepter.CSGIIOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Holder;

@RestController
public class BaseController {

    @RequestMapping("/test")
    public String Index() {

//        UserServiceImpService userServiceImpService = new UserServiceImpService();
//
//        UserService userService = userServiceImpService.getUserServiceImpPort();
//
//        User user = new User();
//        user.setSex("10");
//        user.setUserid("bbbbbb");
//        user.setUsername("aaaaaaaa");
//
//        String test = userService.getName(user);

        try {

            String address = "http://localhost:8081/service/my?wsdl";

            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.setServiceClass(UserPortType.class);
            jaxWsProxyFactoryBean.setAddress(address);
            jaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
            jaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
            jaxWsProxyFactoryBean.getOutInterceptors().add(new CSGIIOutInterceptor());
            UserPortType userPortType= (UserPortType)jaxWsProxyFactoryBean.create();
            UserType userType = new UserType();
            UserHeaderType userHeaderType = new UserHeaderType();
            userHeaderType.setFrom("100");
            userHeaderType.setTo("200");
            userType.setHeader(userHeaderType);
            UserBodyType userBodyType =   new UserBodyType();
            userBodyType.setUsername("张三");
            userBodyType.setSex("男");
            userBodyType.setAge(28);
            userType.setBody(userBodyType);

            ReqHeaderType reqHeaderType = new ReqHeaderType();
            reqHeaderType.setMac("11111111111111");
            reqHeaderType.setIp("127.0.0.1");
            reqHeaderType.setAddress("localhost:7777");
            reqHeaderType.setFrom("100");
            reqHeaderType.setTo("200");

            javax.xml.ws.Holder<RspHeaderType> rspHeader = new Holder<>();

            ResUserType resUserType = userPortType.getName(userType,reqHeaderType,rspHeader);

            return  "aaaa";
        }catch (Exception e){

            return  "fail";
        }



    }
}
