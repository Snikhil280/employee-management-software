package com.nikhil.ems.controller;

import com.nikhil.ems.model.dto.request.LoginRequest;
import com.nikhil.ems.model.dto.response.ApiResponseDto;
import com.nikhil.ems.model.dto.response.AuthResponseDto;
import com.nikhil.ems.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authManager;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<ApiResponseDto<AuthResponseDto>> login(@RequestBody LoginRequest request) {
    authManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(), request.getPassword()
        )
    );
    String token = jwtUtil.generateToken(request.getEmail());
    return ResponseEntity.ok(
        new ApiResponseDto<>(
            new AuthResponseDto("Login successful", token)
        )
    );
  }
}
