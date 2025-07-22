package com.example.t1_autorization_homework.contollers;

import com.example.t1_autorization_homework.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class ExampleController {
    private final UserService userService;

    @GetMapping
    @Operation(summary = "Доступен только авторизованным пользователям")
    public String example() {
        return "Привет, Т1";
    }

    @GetMapping("/admin")
    @Operation(summary = "Доступен только админам")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Привет, админ";
    }

    @GetMapping("/premium-user")
    @Operation(summary = "Доступен только премиум-пользователям")
    @PreAuthorize("hasAnyRole('PREMIUM_USER', 'ADMIN')")
    public String premiumUser() {
        return "Привет, премиум-пользователь";
    }

    @GetMapping("/get-admin")
    @Operation(summary = "Получить роль ADMIN")
    public void getAdmin() {
        userService.getAdmin();
    }

    @GetMapping("/get-premium-user")
    @Operation(summary = "Получить роль PREMIUM-USER")
    public void getPremiumUser() {
        userService.getPremiumUser();
    }
}
