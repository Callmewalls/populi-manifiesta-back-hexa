package com.example.demo.auth.infrastructure.in.web;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.domain.TokenResponse;
import com.example.demo.auth.infrastructure.jwt.JwtService;
import com.example.demo.auth.infrastructure.security.CustomUserDetails;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final TokenWebMapper mapper;

    public AuthController(AuthenticationManager authManager,
            JwtService jwtService,
            TokenWebMapper mapper) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.mapper = mapper;
    }

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenResponseWeb.class))),
    })
    public TokenResponseWeb login(@RequestBody LoginRequestWeb request) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();

        TokenResponse token = jwtService.generateToken(
                principal.getId(),
                principal.getUsername());

        return mapper.toWebResponse(token);
    }
}
