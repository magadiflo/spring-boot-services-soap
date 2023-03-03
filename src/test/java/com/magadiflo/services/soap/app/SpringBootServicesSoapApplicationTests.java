package com.magadiflo.services.soap.app;

import com.cdyne.ws.weatherws.GetCityWeatherByZIP;
import com.cdyne.ws.weatherws.GetCityWeatherByZIPResponse;
import com.magadiflo.services.soap.app.callingservicessoap.ConfigurationHello;
import com.magadiflo.services.soap.app.callingservicessoap.SOAPConnectClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @SpringBootTest: Se encargará de establecer un set de pruebas y además le configuramos un puerto random para su ejecución
 * @ContextConfiguration: Esta anotación nos permitirá utilizar clases de contexto para este caso: ConfigurationHello
 * @TestPropertySource: Nos permitirá utilizar los properties
 */

@ContextConfiguration(classes = ConfigurationHello.class, loader = AnnotationConfigContextLoader.class)
@TestPropertySource("/application.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootServicesSoapApplicationTests {

    @Autowired
    private SOAPConnectClient client;

    @Value("${WSDL.SOAPClient}")
    private String clientEndPoint;

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @BeforeEach
    public void init() throws Exception {
        this.marshaller.setPackagesToScan("com.cdyne.ws.weatherws");
        this.marshaller.afterPropertiesSet();
    }

    @Test
    public void unLockUser() {
        GetCityWeatherByZIP request = new GetCityWeatherByZIP();
        request.setZIP("4544445");
        GetCityWeatherByZIPResponse response = (GetCityWeatherByZIPResponse) client.callWebServices(clientEndPoint, request);
        Assertions.assertEquals(true, response.getGetCityWeatherByZIPResult().isSuccess());
    }

}
