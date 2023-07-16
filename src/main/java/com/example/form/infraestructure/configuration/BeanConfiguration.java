package com.example.form.infraestructure.configuration;

import com.example.form.domain.api.IDegreeServicePort;
import com.example.form.domain.api.ILocationServicePort;
import com.example.form.domain.api.IUniversityServicePort;
import com.example.form.domain.api.IUserServicePort;
import com.example.form.domain.spi.IDegreePersistencePort;
import com.example.form.domain.spi.ILocationPersistencePort;
import com.example.form.domain.spi.IUniversityPersistencePort;
import com.example.form.domain.spi.IUserPersistencePort;
import com.example.form.domain.usecase.DegreeUseCase;
import com.example.form.domain.usecase.LocationUseCase;
import com.example.form.domain.usecase.UniversityUseCase;
import com.example.form.domain.usecase.UserUseCase;
import com.example.form.infraestructure.output.feign.adapter.LocationFeignAdapter;
import com.example.form.infraestructure.output.feign.adapter.UniversityFeignAdapter;
import com.example.form.infraestructure.output.feign.feignclient.ICountryStateCityApi;
import com.example.form.infraestructure.output.feign.feignclient.IUniversityHipolabsApi;
import com.example.form.infraestructure.output.feign.mapper.LocationEntityMapper;
import com.example.form.infraestructure.output.feign.mapper.UniversityEntityMapper;
import com.example.form.infraestructure.output.jpa.adapter.DegreeJpaAdapter;
import com.example.form.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.example.form.infraestructure.output.jpa.mapper.DegreeEntityMapper;
import com.example.form.infraestructure.output.jpa.mapper.UserEntityMapper;
import com.example.form.infraestructure.output.jpa.repository.IDegreeRepository;
import com.example.form.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ILocationServicePort locationServicePort(ILocationPersistencePort locationPersistencePort) {
        return new LocationUseCase(locationPersistencePort);
    }

    @Bean
    public ILocationPersistencePort locationPersistencePort(@Value("${countrystatecity.api.key}") String token,
                                                            ICountryStateCityApi countryStateCityApi,
                                                            LocationEntityMapper locationEntityMapper) {
        return new LocationFeignAdapter(countryStateCityApi, locationEntityMapper, token);
    }

    @Bean
    public IUserServicePort userServicePort(IUserPersistencePort userPersistencePort) {
        return new UserUseCase(userPersistencePort);
    }

    @Bean
    public IUserPersistencePort userPersistencePort(IUserRepository userRepository,
                                                    UserEntityMapper userEntityMapper) {
        return new UserJpaAdapter(userRepository, userEntityMapper,passwordEncoder());
    }

    @Bean
    public IUniversityServicePort universityServicePort(IUniversityPersistencePort universityPersistencePort) {
        return new UniversityUseCase(universityPersistencePort);
    }

    @Bean
    public IUniversityPersistencePort universityPersistencePort(IUniversityHipolabsApi universityHipolabsApi, UniversityEntityMapper universityEntityMapper) {
        return new UniversityFeignAdapter(universityHipolabsApi, universityEntityMapper);
    }
    @Bean
    public IDegreeServicePort degreeServicePort(IDegreePersistencePort degreePersistencePort){
        return new DegreeUseCase(degreePersistencePort);
    }
    @Bean
    public IDegreePersistencePort degreePersistencePort(IDegreeRepository degreeRepository, DegreeEntityMapper degreeEntityMapper){
        return new DegreeJpaAdapter(degreeRepository,degreeEntityMapper);
    }
}
