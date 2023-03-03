package com.magadiflo.services.soap.app.callingservicessoap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ConfigurationHello {

    @Value("${WSDL.ClientEndpoint}")
    private String clientEndPoint;

    /**
     * El primer Bean se encargará de que forma se genera la estructura de la data. por ende utilizamos el paquete
     * que contiene las clases JAXB para crear un contexto JAXB y poder retornamos un objeto marshaller.
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.cdyne.ws.weatherws");
        return marshaller;
    }

    /**
     * El segundo Bean se encapsulara el URL , el marshaller y el unmarshaller para poder invocar el servicio correctamente.
     */
    @Bean
    public SOAPConnectClient soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnectClient client = new SOAPConnectClient();
        client.setDefaultUri(this.clientEndPoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
