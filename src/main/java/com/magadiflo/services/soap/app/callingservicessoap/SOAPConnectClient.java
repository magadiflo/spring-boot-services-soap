package com.magadiflo.services.soap.app.callingservicessoap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnectClient extends WebServiceGatewaySupport {

    public Object callWebServices(String url, Object request) {
        return this.getWebServiceTemplate().marshalSendAndReceive(url, request);
    }

}
