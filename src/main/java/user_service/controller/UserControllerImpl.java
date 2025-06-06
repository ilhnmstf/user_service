package user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_service.dto.SaveUserDto;
import user_service.dto.UserDto;
import user_service.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @PostMapping
    @Override
    public ResponseEntity<UserDto> create(SaveUserDto user) {
        return ResponseEntity.ok().body(userService.create(user));
    }

    @GetMapping("/{userId}")
    @Override
    public ResponseEntity<UserDto> get(long userId) {
        return ResponseEntity.ok().body(userService.get(userId));
    }

    @PutMapping("/{userId}")
    @Override
    public ResponseEntity<UserDto> update(long userId, SaveUserDto user) {
        return ResponseEntity.ok().body(userService.update(userId, user));
    }

    @DeleteMapping("/{userId}")
    @Override
    public ResponseEntity<Void> delete(long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/subscribe")
    @Override
    public ResponseEntity<Void> subscribe(long userId, long followeeId) {
        userService.subscribe(userId, followeeId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/unsubscribe")
    @Override
    public ResponseEntity<Void> unSubscribe(long userId, long followeeId) {
        userService.unSubscribe(userId, followeeId);
        return ResponseEntity.ok().build();
    }
}
