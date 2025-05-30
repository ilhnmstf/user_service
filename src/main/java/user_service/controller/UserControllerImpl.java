package user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping("/{userId}/cache")
    @Override
    public ResponseEntity<UserCacheDto> getUserCacheForFeed(@PathVariable long userId) {
        return ResponseEntity.ok().body(userService.getUserCache(userId));
    }

    @GetMapping("/{userId}/auth")
    @Override
    public ResponseEntity<UserAuthDto> getUserAuth(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUserAuth(username));
    }
}
