package com.example.form.infraestructure.configuration.security;

import com.example.form.infraestructure.exception.TokenInvalidException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.replace("Bearer", "");
            UsernamePasswordAuthenticationToken usernamePAT = null;
            try {
                usernamePAT = tokenService.getAuthentication(token);
            } catch (TokenInvalidException exception) {
                response.setHeader("error", "Token Invalid");
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                Map<String, String> error = new HashMap<>();
                error.put("title", exception.getMessage());
                error.put("status", "400");
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }
            if (usernamePAT != null) {
                SecurityContextHolder.getContext().setAuthentication(usernamePAT);
            } else {
                response.setHeader("error", "Expired Session");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());

                Map<String, String> error = new HashMap<>();
                error.put("title", "Expired Session");
                error.put("status", "401");
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        }
        try {
            filterChain.doFilter(request, response);
        } catch (Exception ignored) {

        }

    }
}
