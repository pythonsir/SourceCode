package com.example.demo.config;


import com.example.demo.interceptors.CxfInterceptorsForOut;
import com.example.demo.test.MyServerSoapEndpointImpl;
import com.example.demo.test.MyService;
import com.example.demo.test.UserPortType;
import com.sun.xml.internal.ws.api.databinding.Databinding;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;


@Configuration
//@ImportResource("classpath:cxf.xml")
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean dispatcherServlet1(){
        return new ServletRegistrationBean(new CXFServlet(),"/service/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public UserPortType userPortType(){
        return new MyServerSoapEndpointImpl();
    }

    @Bean
    public Endpoint endpoint() {

        EndpointImpl endpoint=new EndpointImpl(springBus(), userPortType());//绑定要发布的服务
        endpoint.getInInterceptors().add(new LoggingInInterceptor());
        endpoint.getOutInterceptors().add(new LoggingOutInterceptor());
        endpoint.getOutInterceptors().add(new CxfInterceptorsForOut());
        endpoint.publish("/my"); //显示要发布的名称
        return endpoint;

    }

}
