package com.example.form.application.handler.implementation;

import com.example.form.application.dto.DegreeDto;
import com.example.form.application.handler.interfaces.IDegreeHandler;
import com.example.form.application.mapper.DegreeDtoMapper;
import com.example.form.domain.api.IDegreeServicePort;
import com.example.form.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DegreeHandlerImp implements IDegreeHandler {
    private final IUserServicePort userServicePort;
    private final IDegreeServicePort degreeServicePort;
    private final DegreeDtoMapper degreeDtoMapper;

    @Override
    public List<DegreeDto> getUserDegrees(String email) {
        long userId = userServicePort.getUserByEmail(email).getId();
        return degreeServicePort.getAllDegreesByUserId(userId)
                .stream()
                .map(degreeDtoMapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public void saveUserDegrees(String email, List<DegreeDto> degreesDto) {
        long userId = userServicePort.getUserByEmail(email).getId();
        degreeServicePort.deleteAllDegreesByUserId(userId);
        degreesDto.stream()
                .map(degreeDtoMapper::toModel)
                .peek(degree -> degree.setUserId(userId))
                .forEach(degreeServicePort::saveDegree);
    }
}
