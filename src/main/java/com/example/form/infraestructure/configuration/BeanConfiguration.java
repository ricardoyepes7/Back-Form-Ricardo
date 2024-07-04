package com.example.form.infraestructure.configuration;

import com.example.form.domain.api.*;
import com.example.form.domain.spi.*;
import com.example.form.domain.usecase.*;
import com.example.form.infraestructure.output.feignclient.adapter.LocationFeignAdapter;
import com.example.form.infraestructure.output.feignclient.adapter.UniversityFeignAdapter;
import com.example.form.infraestructure.output.feignclient.feign.ICountryStateCityApi;
import com.example.form.infraestructure.output.feignclient.feign.IUniversityHipolabsApi;
import com.example.form.infraestructure.output.feignclient.mapper.LocationEntityMapper;
import com.example.form.infraestructure.output.feignclient.mapper.UniversityEntityMapper;
import com.example.form.infraestructure.output.jpa.adapter.DegreeJpaAdapter;
import com.example.form.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.example.form.infraestructure.output.jpa.mapper.DegreeEntityMapper;
import com.example.form.infraestructure.output.jpa.mapper.UserEntityMapper;
import com.example.form.infraestructure.output.jpa.repository.IDegreeRepository;
import com.example.form.infraestructure.output.jpa.repository.IUserRepository;
import com.example.form.infraestructure.output.soapclient.adapter.LanguageSoapAdapter;
import com.example.form.infraestructure.output.soapclient.mapper.LanguageSoapMapper;
import com.example.form.infraestructure.output.soapclient.soap.LanguageSoapClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Component
public class BeanConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("es"));
        return localeResolver;
    }

    @Bean
    public Locale locale() {
        return LocaleContextHolder.getLocale();
    }

    @Bean
    public ILocationServicePort locationServicePort(ILocationProviderPort locationPersistencePort) {
        return new LocationUseCase(locationPersistencePort);
    }

    @Bean
    public ILocationProviderPort locationProviderPort(@Value("${countrystatecity.api.key}") String token,
                                                      ICountryStateCityApi countryStateCityApi,
                                                      LocationEntityMapper locationEntityMapper) {
        return new LocationFeignAdapter(countryStateCityApi, locationEntityMapper, token);
    }

    @Bean
    public IUserServicePort userServicePort(IUserProviderPort userProviderPort) {
        return new UserUseCase(userProviderPort);
    }

    @Bean
    public IUserProviderPort userProviderPort(IUserRepository userRepository,
                                              UserEntityMapper userEntityMapper) {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUniversityServicePort universityServicePort(IUniversityProviderPort universityProviderPort) {
        return new UniversityUseCase(universityProviderPort);
    }

    @Bean
    public IUniversityProviderPort universityProviderPort(IUniversityHipolabsApi universityHipolabsApi, UniversityEntityMapper universityEntityMapper) {
        return new UniversityFeignAdapter(universityHipolabsApi, universityEntityMapper);
    }

    @Bean
    public IDegreeServicePort degreeServicePort(IDegreeProviderPort degreeProviderPort) {
        return new DegreeUseCase(degreeProviderPort);
    }

    @Bean
    public IDegreeProviderPort degreeProviderPort(IDegreeRepository degreeRepository, DegreeEntityMapper degreeEntityMapper) {
        return new DegreeJpaAdapter(degreeRepository, degreeEntityMapper);
    }

    @Bean
    public ILanguageServicePort languageServicePort(ILanguageProviderPort languageProviderPort) {
        return new LanguageUseCase(languageProviderPort);
    }

    @Bean
    public ILanguageProviderPort languageProviderPort(LanguageSoapClient languageSoapClient,
                                                      LanguageSoapMapper languageSoapMapper) {
        return new LanguageSoapAdapter(languageSoapClient, languageSoapMapper);
    }
}
