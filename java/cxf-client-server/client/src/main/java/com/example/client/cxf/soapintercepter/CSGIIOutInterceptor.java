package com.example.client.cxf.soapintercepter;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CSGIIOutInterceptor  extends AbstractPhaseInterceptor{

    public CSGIIOutInterceptor() {
        super(Phase.PREPARE_SEND);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        try {

            Map<String, String> envMap = new HashMap<>();
            envMap.put("s", "http://manzj.net/services/test");
            envMap.put("d","http://manzj.net/metadata");

            //在命名空间下的元素都以自定义前缀生成
            Map<String, String> namespaceMap = new HashMap<>();
            namespaceMap.put("http://manzj.net/services/test", "s");
            namespaceMap.put("http://manzj.net/metadata", "d");
            JAXBDataBinding dataBinding = (JAXBDataBinding) message.getExchange().getEndpoint().getService()
                    .getDataBinding();
            dataBinding.setNamespaceMap(namespaceMap);

            message.put("soap.env.ns.map", envMap);
            message.put("disable.outputstream.optimization", true);


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
