package com.example.t1_autorization_homework.jwt;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Токен")
public class JwtAuthenticationResponse {
    @Schema(description = "Токен доступа")
    private String token;
}
