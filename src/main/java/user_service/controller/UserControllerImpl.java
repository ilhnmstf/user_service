package user_service.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_service.dto.UserAuthDto;
import user_service.dto.UserCacheDto;
import user_service.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@Validated
public class UserControllerImpl implements UserController {
    private static final String INVALID_ID_MSG = "should more than 0";

    private final UserService userService;

    @GetMapping("/{userId}/cache")
    @Override
    public ResponseEntity<UserCacheDto> getUserCacheForFeed(
            @PathVariable @Min(value = 1, message = INVALID_ID_MSG) long userId) {
        return ResponseEntity.ok().body(userService.getUserCache(userId));
    }

    @GetMapping("/{userId}/auth")
    @Override
    public ResponseEntity<UserAuthDto> getUserAuth(@PathVariable @NotBlank String username) {
        return ResponseEntity.ok().body(userService.getUserAuth(username));
    }
}
