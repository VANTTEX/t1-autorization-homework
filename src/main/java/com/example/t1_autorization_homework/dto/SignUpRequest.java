package com.example.t1_autorization_homework.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "Логин")
    @Size(min = 3, max = 50, message = "Логин должен быть от 3 до 50 символов")
    @NotBlank(message = "Логин не может быть пустым")
    private String username;

    @Schema(description = "Адрес электронной почты")
    @Size(min = 5, max = 100, message = "Адрес электронной почты должен быть от 5 до 100 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустым")
    @Email(message = "email@example.ru")
    private String email;

    @Schema(description = "Пароль")
    @Size(max = 100, message = "Пароль не может превышать 100 символов")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}
