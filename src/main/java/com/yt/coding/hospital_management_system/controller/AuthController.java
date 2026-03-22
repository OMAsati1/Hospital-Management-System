    package com.yt.coding.hospital_management_system.controller;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.yt.coding.hospital_management_system.dto.LoginSRequestDto;
import com.yt.coding.hospital_management_system.dto.SignUpRequestDto;
import com.yt.coding.hospital_management_system.dto.LoginResponseDto;
    import com.yt.coding.hospital_management_system.dto.SignUpResponseDto;
    import com.yt.coding.hospital_management_system.security.AuthService;

    import lombok.RequiredArgsConstructor;

    @RestController
    @RequestMapping("/auth")
    @RequiredArgsConstructor
    public class AuthController {
        private final AuthService authSecurity;

        @PostMapping("/login")
        public ResponseEntity<LoginResponseDto> login(@RequestBody LoginSRequestDto loginRequestDto) {
            return ResponseEntity.ok(authSecurity.login(loginRequestDto));
        }

        @PostMapping("/signup")
        public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto signupRequestDto) {  
            return ResponseEntity.ok(authSecurity.signup(signupRequestDto));
        }
    }

    