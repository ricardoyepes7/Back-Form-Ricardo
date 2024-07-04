package com.example.form.infraestructure.configuration.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.form.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClientTemplate soapClientTemplate(Jaxb2Marshaller marshaller) {
        SoapClientTemplate languageSoapClient = new SoapClientTemplate();
        languageSoapClient.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        languageSoapClient.setMarshaller(marshaller);
        languageSoapClient.setUnmarshaller(marshaller);
        return languageSoapClient;
    }
}
