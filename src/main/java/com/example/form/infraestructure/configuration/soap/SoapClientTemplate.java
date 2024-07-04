package com.example.form.infraestructure.configuration.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
public class SoapClientTemplate extends WebServiceGatewaySupport {
    private final SoapActionCallback soapActionCallback = new SoapActionCallback("http://www.oorsprong.org/websamples.countryinfo");
    private final String url = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    public <T> Object execute(T parameter){
        return getWebServiceTemplate().marshalSendAndReceive(url,parameter, soapActionCallback);
    }
}
