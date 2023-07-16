package com.example.form.infraestructure.input.rest;

import com.example.form.application.dto.DegreeDto;
import com.example.form.application.dto.UserDto;
import com.example.form.application.dto.UserRegisterDto;
import com.example.form.application.handler.interfaces.IDegreeHandler;
import com.example.form.application.handler.interfaces.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final IUserHandler userHandler;
    private final IDegreeHandler degreeHandler;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        userHandler.createUser(userRegisterDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<UserDto> getUserInformation(@AuthenticationPrincipal String username) {
        return ResponseEntity.ok(userHandler.getUserInformation(username));
    }

    @PutMapping
    private ResponseEntity<HttpStatus> updateUser(@AuthenticationPrincipal String username,
                                                  @Valid @RequestBody UserDto userDto) {
        userHandler.updateUser(username, userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/degrees")
    public ResponseEntity<List<DegreeDto>> getUserDegrees(@AuthenticationPrincipal String username) {
        return ResponseEntity.ok(degreeHandler.getUserDegrees(username));
    }

    @PostMapping("/degrees")
    public ResponseEntity<HttpStatus> saveUserDegrees(@AuthenticationPrincipal String username,
                                                      @RequestBody List<DegreeDto> degrees) {
        degreeHandler.saveUserDegrees(username, degrees);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
